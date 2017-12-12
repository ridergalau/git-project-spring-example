package tujuh.suganda.service.impl;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tujuh.suganda.dao.*;

import tujuh.suganda.model.MessageModel;
import tujuh.suganda.service.HbaseService;
@Service
public class HbaseServiceImpl implements HbaseService {
	@Autowired
	DaoHbase dao;
	
	@Override
	public MessageModel getData(String tableName, String column) throws IOException, ParseException {
		MessageModel msg = new MessageModel();
		try {
			msg.setMessage("Success!");
			msg.setStatus("ok");
			msg.setData(dao.scanAll(tableName, column));
		} catch (Exception e) {
			msg.setMessage("Fail!");
			msg.setStatus("not bad!");
			msg.setData(e.getMessage());
		}
		return msg;
	}

}
