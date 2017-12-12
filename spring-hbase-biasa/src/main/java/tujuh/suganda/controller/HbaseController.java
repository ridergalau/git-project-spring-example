package tujuh.suganda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tujuh.suganda.model.MessageModel;
import tujuh.suganda.service.HbaseService;


@CrossOrigin(origins = "*")
@Controller
public class HbaseController {
	@Autowired
	HbaseService hbase;
	
	@GetMapping("/scantable")
	@ResponseBody
	public ResponseEntity<?> getTimeline(@RequestParam(value = "table") String table,@RequestParam(value = "cf") String cf) {
		MessageModel msg = new MessageModel();
		
		try {
			msg = hbase.getData(table, cf);
		} catch (Exception e) {
			// TODO: handle exception
			msg.setStatus("false");
			msg.setMessage(e.getMessage());
			return new ResponseEntity(msg, HttpStatus.SERVICE_UNAVAILABLE);
		}
		return new ResponseEntity (msg, HttpStatus.OK);
	}
}
