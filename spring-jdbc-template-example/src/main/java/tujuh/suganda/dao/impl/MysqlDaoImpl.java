package tujuh.suganda.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import tujuh.suganda.dao.MysqlDao;
import tujuh.suganda.model.DataModel;
import tujuh.suganda.model.MessageModel;

@Service
public class MysqlDaoImpl implements MysqlDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(MysqlDaoImpl.class);
	Date date = new Date();
	String thedate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(date);
	String insertdata = "insert into data values(?,?,?,?,?,?)";
	MessageModel msg = new MessageModel();
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public MessageModel getAllData() {

		String sql = "select * from data;";
		try {
			List<Map<String, Object>> data = jdbcTemplate.queryForList(sql);
			msg.setData(data);
			msg.setStatus("true");
		} catch (Exception e) {
			msg.setData("null");
			msg.setStatus("false");
			msg.setMessage(e.getMessage());
		}
		LOGGER.info("has been executed - " + thedate);
		return msg;
	}

	@Override
	public MessageModel findBy(String field, String value) {
		String sql = "select * from data where " + field + "='" + value + "'";
		try {
			List<Map<String, Object>> data = jdbcTemplate.queryForList(sql);
			msg.setData(data);
			msg.setStatus("true");
		} catch (Exception e) {
			msg.setData("null");
			msg.setStatus("false");
			msg.setMessage(e.getMessage());
		}
		LOGGER.info(sql + " has been executed - " + thedate);
		return msg;
	}

	@Override
	public MessageModel insert(DataModel data) {
		try {
			jdbcTemplate.update(insertdata, new Object[] { data.getId(), data.getName(), data.getEmail(),
					data.getCity(), data.getCountry(), data.getIp() });
			msg.setData(data.getId() + " has been Saved!");
			msg.setStatus("200");
			msg.setMessage("True");
		} catch (Exception e) {
			msg.setData(data.getId() + " Failed!");
			msg.setStatus("404");
			msg.setMessage("false");
		}
		LOGGER.info(insertdata + " has been executed - " + thedate);
		return msg;
	}

}
