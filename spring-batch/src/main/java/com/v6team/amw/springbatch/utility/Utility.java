package com.v6team.amw.springbatch.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.datasource")
public class Utility {
	private static Map<String, String> propmap = new HashMap<String, String>();
	
	public static Resource loadEmployees() {
	    return new ClassPathResource("resources");
	}
	

	    

	    // setter and getter for propmap omitted

	    public Set<String> returnAllKeys() {
	        return propmap.keySet();
	    }
}
