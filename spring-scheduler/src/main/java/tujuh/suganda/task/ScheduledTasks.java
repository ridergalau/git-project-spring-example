package tujuh.suganda.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	// will be execute every 10 minutes
	@Scheduled(fixedRate = 1000 * 10)
	public void reportCurrentTime() {
		System.out.println(
				"============================= " + dateFormat.format(new Date()) + " =============================");
	}

	// 0 24 13 * *
	// seconds, minutes,hour,day,month
	// cron scheduler
	@Scheduled(cron = "27 * * * * ?")
	public void reportCurrentTime1() {
		System.out.println(
				"********************* " + dateFormat.format(new Date()) + " *********************");
	}

}
