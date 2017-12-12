package tujuh.suganda.service;

import java.io.IOException;
import java.text.ParseException;

import tujuh.suganda.model.MessageModel;

public interface HbaseService {
	MessageModel getData (String tableName, String column) throws IOException, ParseException;

}
