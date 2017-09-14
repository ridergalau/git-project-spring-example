package tujuh.suganda.service;

import static java.lang.String.format;
import static java.lang.System.nanoTime;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tujuh.suganda.controller.SimpleController;
import tujuh.suganda.model.MyModel;

public class SimpleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleService.class);

	MyModel model = new MyModel();


	public MyModel testData(String who)
	{
		String logFormat = "%s execute Method took  %d millis with result: %s";
		String message = who;
		long start1 = nanoTime();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end1 = nanoTime();
		model.setMessage(message);
		model.setTime("Rider");
		LOGGER.info(format(logFormat, "Rest", TimeUnit.NANOSECONDS.toMillis(end1 - start1), message));
		return model;
		
	}
	
}
