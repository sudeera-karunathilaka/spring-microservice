package au.com.sudeera.microservice.configclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/configurations")
public class ConfigMessageController {
	
	private final Logger logger = LoggerFactory.getLogger(ConfigMessageController.class);


	@Value("{$message}")
	private String message;
	
	@RequestMapping(value="")
	public String message() {
		logger.info("*********** getMessage()");
		return this.message;
	}
}
