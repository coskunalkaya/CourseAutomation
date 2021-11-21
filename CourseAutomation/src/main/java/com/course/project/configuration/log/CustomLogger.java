package com.course.project.configuration.log;

import java.util.Date;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomLogger {

	private final MongoTemplate mongoTemplate;

	public CustomLogger(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void info(String method,String path, String statusCode,String message) {
		Logs logs = new Logs();
		logs.setMethod(method);
		logs.setPath(path);
		logs.setStatusCode(statusCode);
		logs.setMessage(message);
		logs.setDate(new Date());
		mongoTemplate.insert(logs);
	}
}