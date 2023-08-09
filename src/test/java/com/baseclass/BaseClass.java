package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
//	public static WebDriver driver;
	public static RequestSpecification request;
	public static Response res;

	public static void addBody(Object o) {

		request = request.body(o);

	}

	public static void baseURI(String uri) {

		RestAssured.baseURI = "https://petstore.swagger.io/v2/" + uri;
	}

	public static Response requestType(String type) {
		switch (type.toUpperCase()) {

		case "DELETE":
			res = request.contentType(ContentType.JSON).when().get().then().extract().response();
			break;

		case "POST":
			res = request.contentType(ContentType.JSON).when().post().then().extract().response();
			break;

		case "GET":
			res = request.contentType(ContentType.JSON).when().get().then().extract().response();
			break;

		case "PUT":
			res = request.contentType(ContentType.JSON).when().get().then().extract().response();
			break;

		default:
			break;
		}

		return res;

	}

	
	public static String getProperty(String key, String dataType) throws Throwable, IOException {

		Properties p = new Properties();
		if (dataType.equals("System")) {
			p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//config/System.property")));
		} else {
			p.load(new FileInputStream(new File(System.getProperty("user.dir") + "//TestData/Data.property")));

		}
		return p.getProperty(key);

	}

	public static String currentDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setTimeZone(TimeZone.getTimeZone("EST"));

		return s.format(d);

	}
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		return value;

	}
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}	

}
