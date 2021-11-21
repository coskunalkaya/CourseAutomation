package com.course.project.configuration.log;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs")
public class Logs {

	@Id
	private String id;
	private Date date;
	private String method;
	private String path;
	private String statusCode;
	private String message;

	public Logs() {

	}

	public Logs(String id, Date date, String method, String path, String statusCode, String message) {
		this.id = id;
		this.date = date;
		this.method = method;
		this.path = path;
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}