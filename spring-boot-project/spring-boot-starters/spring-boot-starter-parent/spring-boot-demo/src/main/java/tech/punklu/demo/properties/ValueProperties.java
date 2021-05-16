package tech.punklu.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueProperties {

	@Value("${functionFlag}")
	private String functionFlag;
}
