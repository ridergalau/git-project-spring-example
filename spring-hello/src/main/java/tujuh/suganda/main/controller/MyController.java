package tujuh.suganda.main.controller;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import tujuh.suganda.main.services.ServiceWord;

@CrossOrigin(origins = "*")
@RestController
@Primary
public class MyController {
	ServiceWord myService = new ServiceWord();

	@RequestMapping(value = "/sayhelo", method = RequestMethod.GET)
	@ResponseBody
	public String cekKata(@RequestParam(value = "name", defaultValue = "World") String person) throws JsonProcessingException {
		return myService.hello(person);
	}
}
