package com.raziem.registry;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistryApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("standalone")
public class RegistryApplicationTests {

	@LocalServerPort
	private int port;

	@Before
	public void setup() {
		RestAssured.port = this.port;
	}

	@Test
	public void shouldRetrieveHomePage() {
		RestAssured.given().accept(ContentType.JSON).when().get("/").then().statusCode(HttpStatus.SC_OK)
				.contentType(ContentType.HTML);
	}
}