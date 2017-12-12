package tujuh.suganda.conf;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration

public class HbaseConf {

	@Autowired
	Environment env;

	@Bean(name = "config_hbase")
	public org.apache.hadoop.conf.Configuration sampleConfig() {
		org.apache.hadoop.conf.Configuration config = HBaseConfiguration.create();
		config.set("hbase.master", env.getProperty("hmaster"));
		config.setInt("timeout", 5000);
		config.set("hbase.zookeeper.quorum", env.getProperty("zookeeper"));
		config.set("zookeeper.znode.parent", "/hbase-unsecure");
		return config;
	}
}
