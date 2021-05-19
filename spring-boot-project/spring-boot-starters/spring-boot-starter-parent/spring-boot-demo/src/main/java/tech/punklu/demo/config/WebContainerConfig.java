package tech.punklu.demo.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 自定义Spring Boot容器的两种方式
 */
@Component
public class WebContainerConfig {

	/**
	 * 自定义Spring Boot使用的Tomcat
	 * @return
	 */
	@Bean
	public TomcatServletWebServerFactory servletWebServerFactory(){
		TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
		tomcatServletWebServerFactory.setPort(80);
		return tomcatServletWebServerFactory;
	}

	/**
	 * 定制Spring Boot中当前正在使用的容器
	 * @return
	 */
	@Bean
	public WebServerFactoryCustomizer customizer(){
		WebServerFactoryCustomizer  webServerFactoryCustomizer = new WebServerFactoryCustomizer() {
			/**
			 * 定制当前正在使用的web容器
			 * @param factory the web server factory to customize
			 */
			@Override
			public void customize(WebServerFactory factory) {
				TomcatServletWebServerFactory factory1 = (TomcatServletWebServerFactory) factory;
				factory1.setPort(80);
			}
		};
		return webServerFactoryCustomizer;
	}
}
