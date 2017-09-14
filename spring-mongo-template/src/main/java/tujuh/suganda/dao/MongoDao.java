package tujuh.suganda.dao;

import java.util.List;

import tujuh.suganda.model.MessageModel;

public interface MongoDao {
	String saveCar(String id, String name, String manufacture, String date, String owner, List group);
	MessageModel getAll();
	MessageModel saveData(String id, String name, String manufacture, String date, String owner, List group);
	MessageModel findByName(String name);
	MessageModel findByField(String field,String value);
	MessageModel findLimit(int limit);
}
