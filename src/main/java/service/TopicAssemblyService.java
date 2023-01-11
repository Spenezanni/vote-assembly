package service;

import java.util.Optional;
import domain.dto.TopicAssemblyDto;
import domain.model.TopicAssembly;
import mapper.TopicAssemblyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TopicAssemblyRepository;

@Service
public class TopicAssemblyService {
	@Autowired
	private TopicAssemblyRepository topicAssemblyRepository;
	@Autowired
	private TopicAssemblyMapper topicAssemblyMapper;

	public TopicAssemblyDto saveTopicAssembly(TopicAssemblyDto topicAssemblyDto) {
		TopicAssembly topicAssemblyToInsert = topicAssemblyMapper.dtoToTopicAssembly(topicAssemblyDto);
		TopicAssembly topicVoteInserted = topicAssemblyRepository.save(topicAssemblyToInsert);
		return topicAssemblyMapper.entityToTopicAssemblyDto(topicVoteInserted);
	}
	public Optional<TopicAssembly> findById(Long topicAssemblyId) {
		return topicAssemblyRepository.findById(topicAssemblyId);
	}

}
