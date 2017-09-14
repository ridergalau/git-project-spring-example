package tujuh.suganda.controller;

import static java.lang.String.format;
import static java.lang.System.nanoTime;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tujuh.suganda.model.MyModel;

@CrossOrigin(origins = "*")
@RestController
@Primary
public class SimpleController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);
	MyModel model = new MyModel();

	@GetMapping("/get")
	@ResponseBody
	@Cacheable("cacheExample")
	public ResponseEntity<?> getALL(@RequestParam("who") String who) {
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
		return new ResponseEntity(model, HttpStatus.OK);
	}

	@GetMapping("/get1")
	@ResponseBody
	public ResponseEntity<?> getALLs() {
		String logFormat = "%s execute Method took %d millis with result: %s";
		String message = "I'M ROCK AND ROLL";
		long start1 = nanoTime();
		model.setMessage(message);
		model.setTime("Rider");
		long end1 = nanoTime();
		LOGGER.info(format(logFormat, "Rest", TimeUnit.NANOSECONDS.toMillis(end1 - start1), message));
		return new ResponseEntity(model, HttpStatus.OK);
	}

}
