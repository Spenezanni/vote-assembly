package repository;

import domain.model.TopicAssembly;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicAssemblyRepository extends CrudRepository<TopicAssembly, Long>{

}
