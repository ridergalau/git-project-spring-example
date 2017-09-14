package tujuh.suganda.dao;

import tujuh.suganda.model.DataModel;
import tujuh.suganda.model.MessageModel;

public interface MysqlDao {
	MessageModel getAllData();

	MessageModel findBy(String field, String value);

	MessageModel insert(DataModel data);
}