package tujuh.suganda.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tujuh.suganda.model.Person;

public interface PersonService {
	Person save(Person p);
	String delete(Person p);
	Person findOne(String id);
	List<Person> findByAdress(String title);
	Iterable<Person> findAll();
	Page<Person> findByName(String author, PageRequest pageRequest);
	
}