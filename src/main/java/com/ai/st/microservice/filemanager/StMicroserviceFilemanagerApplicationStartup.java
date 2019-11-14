package com.ai.st.microservice.filemanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StMicroserviceFilemanagerApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = LoggerFactory.getLogger(StMicroserviceFilemanagerApplicationStartup.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		log.info("ST - Loading ... ");
	}

}
