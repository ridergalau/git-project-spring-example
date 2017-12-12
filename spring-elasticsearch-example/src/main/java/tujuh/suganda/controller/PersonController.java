package tujuh.suganda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;
import tujuh.suganda.model.MessageModel;
import tujuh.suganda.model.Person;
import tujuh.suganda.service.PersonService;

@CrossOrigin(origins = "*")
@RestController
@Primary
public class PersonController {
	@Autowired
	PersonService person;

	@PostMapping(value = "/insert")
	public @ResponseBody MessageModel insert(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("address") String address, @RequestParam("gender") String gender) {
		Person dataModel = new Person(id, name, address, gender);
		MessageModel send = new MessageModel();
		try {
			dataModel = person.save(dataModel);
			send.setMessage("true");
			send.setData(dataModel);
			send.setStatus("inserted");
		} catch (Exception e) {
			send.setMessage("false");
			send.setData(dataModel);
			send.setStatus("saving failed!");
		}
		return send;
	}

	@DeleteMapping(value = "/delete")
	public @ResponseBody MessageModel delete(@RequestParam("id") String id) {
		Person p = new Person();
		p.setId(id);
		String msg = person.delete(p);
		MessageModel send = new MessageModel();
		send.setMessage("true");
		send.setData(msg);
		send.setStatus("");
		return send;
	}

	@PostMapping(value = "/findById")
	public @ResponseBody MessageModel findOne(@RequestParam("id") String id) {
		Person p = new Person();
		p = person.findOne(id);
		MessageModel send = new MessageModel();
		send.setMessage("true");
		send.setData(p);
		send.setStatus("");
		return send;
	}

	@PostMapping(value = "/findByAddress")
	public @ResponseBody MessageModel findByAddress(@RequestParam("address") String address) {
		List<Person> p = null;
		p = person.findByAdress(address);
		MessageModel send = new MessageModel();
		send.setMessage("true");
		send.setData(p);
		send.setStatus("");
		return send;
	}

	@PostMapping(value = "/findByName")
	public @ResponseBody MessageModel findByName(@RequestParam("name") String name) {
		Page<Person> p = null;
		List<Person> listP = new ArrayList<>();
		p = person.findByName(name, new PageRequest(0, 5));
		MessageModel send = new MessageModel();
		for (Person str : p) {
			listP.add(str);
		}
		send.setMessage("true");
		send.setData(listP);
		send.setStatus("");
		return send;
	}

	@GetMapping(value = "/findAll")
	public @ResponseBody MessageModel findAll() {
		Iterable<Person> dataModel = null;
		List<Person> datanya = new ArrayList<>();
		MessageModel send = new MessageModel();
		
		try {
			dataModel = person.findAll();
			
			for (Person str : dataModel) {
				datanya.add(str);
			}
			send.setMessage("true");
			send.setData(datanya);
			send.setStatus("");
		} catch (Exception e) {
		}
		return send;
	}

}
