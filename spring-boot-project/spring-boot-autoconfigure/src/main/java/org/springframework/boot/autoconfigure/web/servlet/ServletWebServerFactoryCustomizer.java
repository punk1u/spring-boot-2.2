/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.autoconfigure.web.servlet;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.core.Ordered;

/**
 * {@link WebServerFactoryCustomizer}的基于Servlet的实现类，
 * 将{@link ServerProperties}应用于servlet web服务器。
 * {@link WebServerFactoryCustomizer} to apply {@link ServerProperties} to servlet web
 * servers.
 *
 * @author Brian Clozel
 * @author Stephane Nicoll
 * @author Olivier Lamy
 * @author Yunkun Huang
 * @since 2.0.0
 */
public class ServletWebServerFactoryCustomizer
		implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, Ordered {

	private final ServerProperties serverProperties;

	public ServletWebServerFactoryCustomizer(ServerProperties serverProperties) {
		this.serverProperties = serverProperties;
	}

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		PropertyMapper map = PropertyMapper.get().alwaysApplyingWhenNonNull();
		/**
		 * 容器端口
 		 */
		map.from(this.serverProperties::getPort).to(factory::setPort);
		/**
		 * 地址
		 */
		map.from(this.serverProperties::getAddress).to(factory::setAddress);
		/**
		 * 应用程序上下文路径
		 */
		map.from(this.serverProperties.getServlet()::getContextPath).to(factory::setContextPath);
		map.from(this.serverProperties.getServlet()::getApplicationDisplayName).to(factory::setDisplayName);
		/**
		 * session配置
		 */
		map.from(this.serverProperties.getServlet()::getSession).to(factory::setSession);
		/**
		 * HTTPS 加密配置
		 */
		map.from(this.serverProperties::getSsl).to(factory::setSsl);
		/**
		 * jsp
		 */
		map.from(this.serverProperties.getServlet()::getJsp).to(factory::setJsp);
		/**
		 * 压缩配置策略实现
		 */
		map.from(this.serverProperties::getCompression).to(factory::setCompression);
		/**
		 * http2相关设置
		 */
		map.from(this.serverProperties::getHttp2).to(factory::setHttp2);
		/**
		 * web应用的Header设置
		 */
		map.from(this.serverProperties::getServerHeader).to(factory::setServerHeader);
		/**
		 * 应用上下文的参数设置
		 */
		map.from(this.serverProperties.getServlet()::getContextParameters).to(factory::setInitParameters);
	}

}
