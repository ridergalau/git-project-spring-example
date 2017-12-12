package tujuh.suganda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tujuh.suganda.model.Person;
import tujuh.suganda.repository.PersonRepo;
import tujuh.suganda.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	private PersonRepo repoPerson;

	@Autowired
	public void setPersonRepository(PersonRepo bookRepository) {
		this.repoPerson = bookRepository;
	}

	@Override
	public Person save(Person p) {
		return repoPerson.save(p);
	}

	@Override
	public String delete(Person p) {
		String message = "";
		try {
			repoPerson.delete(p);
			message="Delete Succes!";
		} catch (Exception e) {
			message="Delete Fail!";
		}
		
		return message;
	}

	@Override
	public Person findOne(String id) {
		return repoPerson.findOne(id);
	}

	@Override
	public Iterable<Person> findAll() {
		return repoPerson.findAll();
	}

	@Override
	public Page<Person> findByName(String name, PageRequest pageRequest) {
		return repoPerson.findByName(name, pageRequest);
	}

	@Override
	public List<Person> findByAdress(String title) {
		return repoPerson.findByAddress(title);
	}
}
