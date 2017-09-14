package tujuh.suganda.dao.impl;

import static java.lang.String.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tujuh.suganda.config.Config;
import tujuh.suganda.dao.MongoDao;
import tujuh.suganda.model.CarModel;
import tujuh.suganda.model.MessageModel;

@Service
public class MongoDaoImpl implements MongoDao {
	  private static final Logger LOGGER = LoggerFactory.getLogger(MongoDaoImpl.class);
	  Date date = new Date();
		
	  String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
	static ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
	static MongoOperations mongo = (MongoOperations) ctx.getBean("mongoTemplate");

	@Override
	public String saveCar(String id, String name, String manufacture, String date, String owner, List group) {
		CarModel car = new CarModel(id, name, manufacture, date, owner, group);
		mongo.save(car);
		LOGGER.info("has been executed - "+ thedate);
		return name + " Saved !";
	}

	@Override
	public MessageModel getAll() {
		MessageModel message = new MessageModel();
		try {
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC, "date"));
			List<CarModel> listdata = mongo.find(query, CarModel.class);
			message.setData(listdata);
			message.setMessage("true");
			message.setStatus("200");
		} catch (Exception e) {
			message.setData("null");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - "+ thedate);
		return message;
	}

	@Override
	public MessageModel saveData(String id, String name, String manufacture, String date, String owner, List group) {
		CarModel car = new CarModel(id, name, manufacture, date, owner, group);
		MessageModel message = new MessageModel();
		try {
			mongo.save(car);
			message.setData(name+ "Saved At:"+date);
			message.setMessage("true");
			message.setStatus("200");
		} catch (Exception e) {
			message.setData("Saving Fail...");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - "+ thedate);
		return message;
	}

	@Override
	public MessageModel findByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		MessageModel message = new MessageModel();
		try {
			List<CarModel> listdata = mongo.find(query, CarModel.class);
			message.setData(listdata);
			message.setMessage("true");
			message.setStatus("200");

		} catch (Exception e) {
			message.setData("null");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - "+ thedate);
		return message;
	}

	@Override
	public MessageModel findLimit(int limit) {
		MessageModel message = new MessageModel();
		try {
			Query query = new Query();
			query.limit(limit);
			query.with(new Sort(Sort.Direction.DESC, "date"));
			List<CarModel> listdata = mongo.find(query, CarModel.class);
			message.setData(listdata);
			message.setMessage("true");
			message.setStatus("200");
		} catch (Exception e) {
			message.setData("null");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - "+ thedate);
		return message;
	}

	@Override
	public MessageModel findByField(String field, String value) {
		Query query = new Query(Criteria.where(field).is(value));
		MessageModel message = new MessageModel();
		try {
			List<CarModel> listdata = mongo.find(query, CarModel.class);
			message.setData(listdata);
			message.setMessage("true");
			message.setStatus("200");

		} catch (Exception e) {
			message.setData("null");
			message.setMessage("false");
			message.setStatus("404");
		}
		LOGGER.info("has been executed - "+ thedate);
		return message;
	}
	
	

}