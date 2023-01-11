package repository;

import domain.model.TopicAssembly;
import domain.model.VoteAssembly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteAssemblyRepository extends CrudRepository<VoteAssembly, Long>{

	Long countByTopicVoteAndVoteTrue(TopicAssembly topicVote);

	Long countByTopicVoteAndVoteFalse(TopicAssembly topicVote);

}
