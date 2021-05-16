package tech.punklu.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
/**
 * PropertySource用于指定要使用的配置文件的文件路径
 */
@PropertySource("classpath:test.yml")
public class TestYmlProperties {

	/**
	 * 使用自定义的配置文件时，
	 * 也可以选择使用@Value注解或在类上使用@ConfigurationProperties注解
	 */
	@Value("${name}")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
