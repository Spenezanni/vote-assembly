package service;

import java.util.Optional;

import domain.dto.VoteAssemblyDto;
import domain.model.TopicAssembly;
import domain.model.VoteAssembly;
import exception.ClosedSessionException;
import exception.Messages;
import mapper.VoteAssemblyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VoteAssemblyRepository;

@Service
public class VoteAssemblyService {

	@Autowired
	private TopicAssemblyService topicAssemblyService;
	@Autowired
	private SessionAssemblyService sessionAssemblyService;
	@Autowired
	private VoteAssemblyRepository voteAssemblyRepository;
	@Autowired
	private VoteAssemblyMapper voteAssemblyMapper;
	
	public VoteAssemblyDto voteAssembly(VoteAssemblyDto voteAssemblyDto) {

		Optional<TopicAssembly> optionalTopicAssembly = topicAssemblyService.findById(voteAssemblyDto.getTopicAssemblyId());
		if (optionalTopicAssembly.isPresent()) {
			if (sessionAssemblyService.isSessionOpenOfTopicVote(optionalTopicAssembly.get())) {
				return executeVote(voteAssemblyDto, optionalTopicAssembly);
			}
			throw new ClosedSessionException(Messages.THE_SESSION_ASSEMBLY_IS_CLOSED);
		}
		throw new IllegalArgumentException(Messages.THE_TOPIC_ASSEMBLY_NOT_EXISTS);
	}
	private VoteAssemblyDto executeVote(VoteAssemblyDto voteAssemblyDto, Optional<TopicAssembly> optionalTopicVote) {
		VoteAssembly voteAssembly = voteAssemblyMapper.dtoToVoteAssembly(optionalTopicVote.get(), voteAssemblyDto);
		VoteAssembly voteSaved = voteAssemblyRepository.save(voteAssembly);
		return voteAssemblyMapper.entityToVoteAssemblyDto(voteSaved);
	}

	public VoteAssemblyDto result(VoteAssemblyDto voteAssemblyDto) {
		Optional<TopicAssembly> optionalTopicAssembly = topicAssemblyService.findById(voteAssemblyDto.getTopicAssemblyId());
		if (optionalTopicAssembly.isPresent()) {
			if (sessionAssemblyService.isSessionOpenOfTopicVote(optionalTopicAssembly.get())) {
				Long countVoteYes = voteAssemblyRepository.countByTopicVoteAndVoteTrue(optionalTopicAssembly.get());
				Long countVoteNo = voteAssemblyRepository.countByTopicVoteAndVoteFalse(optionalTopicAssembly.get());
				return voteAssemblyMapper.entityToVoteAssemblyDto(optionalTopicAssembly.get(), countVoteYes, countVoteNo);
			}
			throw new ClosedSessionException(Messages.THE_SESSION_ASSEMBLY_IS_NOT_CLOSE);
		}
		throw new IllegalArgumentException(Messages.THE_TOPIC_ASSEMBLY_NOT_EXISTS);
	}

}
