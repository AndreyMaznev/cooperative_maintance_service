package com.manv.cooperative_maintenance_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CooperativeMaintenanceServiceApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	@LocalServerPort
	private int localServerPort;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllPersonList() throws Exception {
		ResponseEntity<String> getResponse = testRestTemplate.withBasicAuth("user", "")
				.getForEntity(
						"http://localhost:" + localServerPort + "/person/allPersonList",
						String.class
				);
		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
	}
}
