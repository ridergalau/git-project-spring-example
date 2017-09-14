package tujuh.suganda.main.services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ServiceWord {
	public String hello(String person) throws JsonProcessingException {
		String hello ="Hello "+person+" !"; 
		return hello;
	  }
}
