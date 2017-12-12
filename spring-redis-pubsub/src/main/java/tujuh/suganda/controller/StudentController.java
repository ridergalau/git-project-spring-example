package tujuh.suganda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tujuh.suganda.model.Student;
import tujuh.suganda.repository.StudentRepository;

@CrossOrigin(origins = "*")
@RestController
@Primary
public class StudentController {
	@Autowired
	StudentRepository student;

	@RequestMapping(value = "/save")
	public @ResponseBody String save(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("grade") String grade) {
		Student person = new Student();
		person.setId(id);
		person.setGender(Student.Gender.MALE);
		person.setName(name);
		person.setGrade(Integer.valueOf(grade));
		
		try {
			student.saveStudent(person);
		} catch (Exception e) {
		}
		return "SAVED!";
	}
}
