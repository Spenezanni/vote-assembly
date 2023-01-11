package repository;

import java.util.List;
import java.util.Optional;

import domain.model.SessionAssembly;
import domain.model.TopicAssembly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionAssemblyRepository extends CrudRepository<SessionAssembly, Long>{

	Optional<SessionAssembly> findByTopicVote(TopicAssembly topicVote);

	List<SessionAssembly> findByProduceMessageFalseOrProduceMessage(Boolean produceMessage);

}
