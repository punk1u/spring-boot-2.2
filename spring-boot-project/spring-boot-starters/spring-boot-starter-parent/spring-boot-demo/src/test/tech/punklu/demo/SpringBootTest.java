package tech.punklu.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import tech.punklu.demo.properties.Student;
import tech.punklu.demo.properties.ValueProperties;

@RunWith(SpringRunner.class)
@org.springframework.boot.test.context.SpringBootTest(classes = App.class)
public class SpringBootTest {

	@Autowired
	private Student student;

	@Autowired
	private ValueProperties valueProperties;

	@Test
	public void test(){
		System.out.println(student.toString());
		System.out.println(valueProperties.getFunctionFlag());
	}
}
