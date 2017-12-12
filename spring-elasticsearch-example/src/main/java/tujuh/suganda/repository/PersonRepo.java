package tujuh.suganda.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import tujuh.suganda.model.Person;
public interface PersonRepo extends ElasticsearchRepository<Person, String> {
	Page<Person> findByName(String name, Pageable pageable);
    List<Person> findByAddress(String address);
}
