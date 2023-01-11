package service;

import domain.dto.SessionAssemblyDto;
import domain.model.SessionAssembly;
import domain.model.TopicAssembly;
import exception.Messages;
import mapper.SessionAssemblyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.SessionAssemblyRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionAssemblyService {
	@Autowired
	private SessionAssemblyRepository sessionRepository;
	@Autowired
	private TopicAssemblyService topicVoteService;
	@Autowired
	private SessionAssemblyMapper sessionAssemblyMapper;
	public SessionAssemblyDto openSession(SessionAssemblyDto sessionDto) {
		Optional<TopicAssembly> topicAssembly = topicVoteService.findById(sessionDto.getTopicAssemblyId());
		if (topicAssembly.isPresent()) {
			SessionAssembly sessionAssembly = sessionAssemblyMapper.dtoToSessionAssembly(topicAssembly.get(), LocalDateTime.now(), sessionDto);
			SessionAssembly sessionSaved = sessionRepository.save(sessionAssembly);
			return sessionAssemblyMapper.entityToSessionAssemblyDto(sessionSaved);
		}
		throw new IllegalArgumentException(Messages.THE_TOPIC_ASSEMBLY_NOT_EXISTS);
	}
	public Boolean isSessionOpenOfTopicVote(TopicAssembly topicAssembly) {
		Optional<SessionAssembly> optionalSession = sessionRepository.findByTopicVote(topicAssembly);
		if (optionalSession.isPresent()) {
			return LocalDateTime.now().isBefore(optionalSession.get().getFinalVote());
		}
		throw new IllegalArgumentException(Messages.THE_SESSION_ASSEMBLY_NOT_EXISTS);
	}

	public List<String> doHaveAnOpenSessionThatCanBeClosed() {
		List<SessionAssembly> sessionsOpen = sessionRepository.findByProduceMessageFalseOrProduceMessage(null);
		return sessionsOpen.stream()
			.filter(session -> session.getFinalVote().isBefore(LocalDateTime.now()))
			.map(this::saveAndReturnTopicVoteDescription)
			.collect(Collectors.toList());
	}
	private String saveAndReturnTopicVoteDescription(SessionAssembly session) {
		session.setProduceMessage(Boolean.TRUE);
		SessionAssembly sessionSaved = sessionRepository.save(session);
		return sessionSaved.getTopicAssembly().getDescription();
	}
}
