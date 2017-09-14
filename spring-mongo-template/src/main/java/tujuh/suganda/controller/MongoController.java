package tujuh.suganda.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import tujuh.suganda.dao.MongoDao;
import tujuh.suganda.model.MessageModel;

@CrossOrigin(origins = "*")
@RestController
@Primary
public class MongoController {
	Date date = new Date();
	@Autowired
	MongoDao mongo;
	
	MessageModel msg = new MessageModel();
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
			@RequestParam(value = "manufacture") String manufacture, @RequestParam(value = "owner") String owner,
			@RequestParam(value = "group") String group){
		String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(date);
		List<String> list = Arrays.asList(group.split("\\s*,\\s*"));
		return mongo.saveCar(id, name, manufacture, thedate, owner, list);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public MessageModel save(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name,
			@RequestParam(value = "manufacture") String manufacture, @RequestParam(value = "owner") String owner,
			@RequestParam(value = "group") String group) {
		String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(date);
		
		List<String> list = Arrays.asList(group.split("\\s*,\\s*"));
		msg = mongo.saveData(id, name, manufacture, thedate, owner, list);
		return msg;
	}

	@RequestMapping(value = "/findName", method = RequestMethod.GET)
	@ResponseBody
	public MessageModel find(@RequestParam(value = "name") String name)  {
		msg = mongo.findByName(name);
		return msg;
	}
	
	@RequestMapping(value = "/findLimit", method = RequestMethod.GET)
	@ResponseBody
	public MessageModel findLimit(@RequestParam(value = "limit") int limit) {
		msg = mongo.findLimit(limit);
		return msg;
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public MessageModel getAll() throws JsonProcessingException {
		msg = mongo.getAll();
		return msg;
	}

	@RequestMapping(value = "/findByField", method = RequestMethod.GET)
	@ResponseBody
	public MessageModel findByField(@RequestParam(value = "field") String field,@RequestParam(value = "value") String value) {
		msg = mongo.findByField(field,value);
		return msg;
	}
	
}
