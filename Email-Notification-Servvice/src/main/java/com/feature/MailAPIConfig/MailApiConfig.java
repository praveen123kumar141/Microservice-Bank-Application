package com.feature.MailAPIConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
@Configuration
public class MailApiConfig {
	
	@Bean
	@Primary
	public FreeMarkerConfigurationFactoryBean factoryBean() {
		FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
		bean.setTemplateLoaderPath("classpath:/templates");
		return bean;
	}

}
