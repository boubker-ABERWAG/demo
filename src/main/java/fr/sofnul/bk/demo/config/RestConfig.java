package fr.sofnul.bk.demo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationPath("rest")
public class RestConfig extends ResourceConfig{
	
	private static final Logger LOG = LoggerFactory.getLogger(RestConfig.class);
	
	public RestConfig(){
		//packages("fr.sofnul.bk.demo.rest");
		LOG.info("RestConfig =========================> {}" ,this.getClass().getSimpleName());
		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
	}
}
