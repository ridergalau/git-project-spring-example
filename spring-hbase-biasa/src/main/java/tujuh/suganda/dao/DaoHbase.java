package tujuh.suganda.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class DaoHbase {
//	private final static TableName hTable = TableName.valueOf("test");

	@Autowired
	org.apache.hadoop.conf.Configuration config;

	public List<Map> scanAll(String tableName,String column) throws IOException, ParseException {
		TableName hTable = TableName.valueOf(tableName);
		
		List<Map> value = new ArrayList();
		
		try (Connection connection = ConnectionFactory.createConnection(config)) {
			Table table = connection.getTable(hTable);

			final byte[] CF = column.getBytes();
			Scan scan = new Scan();
			scan.addFamily(CF);
			ResultScanner rs = table.getScanner(scan);

			for (Result r = rs.next(); r != null; r = rs.next()) {
				for (KeyValue keyValue : r.list()) {
					Map isi = new HashMap();
					isi.put("rowkey", r.getRow());

					isi.put(Bytes.toString(keyValue.getQualifier()), Bytes.toString(keyValue.getValue()));
					
					System.out.println("Qualifier : " + Bytes.toString(keyValue.getQualifier()) + " : Value : "
							+ Bytes.toString(keyValue.getValue()));
					value.add(isi);
				}
			}
		}
		return value;
	}
}
