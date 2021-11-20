package com.iset.bp.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;


@Configuration
public class MyConfig {
	
		@Bean
		public SimpleJaxWsServiceExporter geJaxWsServiceExporter() {
			
			SimpleJaxWsServiceExporter export = new SimpleJaxWsServiceExporter();
			export.setBaseAddress("http://0.0.0.0:8686/Banque");
			return export;
		}
}
