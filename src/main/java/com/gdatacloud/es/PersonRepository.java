package com.gdatacloud.es;
import com.tianyalei.elasticsearch.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
 
public interface PersonRepository extends ElasticsearchRepository<Person, Integer> {
 
}
