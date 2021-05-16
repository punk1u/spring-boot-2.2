package tech.punklu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.punklu.demo.properties.Student;

@RestController
public class DemoController {

	@Autowired
	private Student student;

	@GetMapping("test")
	public String test(){
		System.out.println(student.toString());
		return "test";
	}
}
