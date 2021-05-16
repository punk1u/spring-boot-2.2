package tech.punklu.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueProperties {

	@Value("${functionFlag}")
	private String functionFlag;

	public String getFunctionFlag() {
		return functionFlag;
	}

	public void setFunctionFlag(String functionFlag) {
		this.functionFlag = functionFlag;
	}
}
