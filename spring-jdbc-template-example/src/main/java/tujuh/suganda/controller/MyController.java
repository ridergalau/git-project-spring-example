package tujuh.suganda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tujuh.suganda.dao.MysqlDao;
import tujuh.suganda.model.DataModel;
import tujuh.suganda.model.MessageModel;

@Controller
public class MyController {
	@Autowired
	MysqlDao daoMysql;

	MessageModel message = new MessageModel();

	@RequestMapping(value = "/all")
	public @ResponseBody MessageModel getAll() {
		try {
			message = daoMysql.getAllData();
		} catch (Exception e) {
		}
		return message;
	}

	@GetMapping("/alls")
	@ResponseBody
	public ResponseEntity<?> getALL() {
		message = daoMysql.getAllData();
		return new ResponseEntity(message, HttpStatus.OK);
	}

	@RequestMapping(value = "/findBy")
	public @ResponseBody MessageModel findBy(@RequestParam("field") String field, @RequestParam("value") String value) {
		try {
			message = daoMysql.findBy(field, value);
		} catch (Exception e) {
		}
		return message;
	}

	@PostMapping(value = "/insert")
	public @ResponseBody MessageModel insert(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("city") String city,
			@RequestParam("country") String country, @RequestParam("ip") String ip) {
		DataModel dataModel = new DataModel(id, name, email, city, country, ip);
		try {
			message = daoMysql.insert(dataModel);
		} catch (Exception e) {
		}
		return message;
	}

}
