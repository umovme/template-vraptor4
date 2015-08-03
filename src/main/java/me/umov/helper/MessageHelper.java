package me.umov.helper;

import static java.lang.String.format;

import java.io.IOException;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@RequestScoped
public class MessageHelper {

	private static final Log LOGGER = LogFactory.getLog(MessageHelper.class);
	
	public Properties getPropertieMessages() {
		return getPropertyFrom("messages.properties");
	}
	
	public Properties getPropertieMessages(String resource) {
		return getPropertyFrom(resource);
	}

	private Properties getPropertyFrom(String resource) {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(resource));
		} catch (IOException e) {
			LOGGER.error(format("Problem reading file: %s", e.getMessage()));
		}
		return properties;
	}
	
	public String getMessage(String key) {
		Properties properties = getPropertieMessages();
		return properties.getProperty(key);
	}
	
}