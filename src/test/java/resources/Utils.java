package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqSpec;
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqSpec==null) {
		PrintStream log= new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		return reqSpec;
		}
		return reqSpec;
	}
	public static String getGlobalValues(String property) throws IOException {
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("D:\\eclipse\\RestAssuredApiFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(property);
	}
	
	public String getJsonKeyValue(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		return js.get(key).toString();
	}

}
