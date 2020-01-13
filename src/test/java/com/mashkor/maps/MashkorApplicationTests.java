package com.mashkor.maps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashkoor.maps.response.PlacesInfoResponse;
import com.mashkor.maps.request.PlacesDistanceRequest;
import com.mashkor.maps.request.PointsDistanceRequest;
import com.mashkor.models.GeoPoint;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class MashkorApplicationTests {

	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void getDistanceBetweenTwoPointsValid() throws Exception {

		PointsDistanceRequest body = new PointsDistanceRequest();
		body.setOrigin(new GeoPoint(40.6655101, -73.89188969999998));
		body.setDestination(new GeoPoint(43.6655101, -73.89188969999998));
		MvcResult mvcResult = mvc.perform(
				post("/points").accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapToJson(body)))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		PlacesInfoResponse response = mapFromJson(content,
				PlacesInfoResponse.class);
		assertTrue(response.getDistance().equals("404 km"));
	}

	@Test
	public void getDistanceBetweenTwoPointsInvalid() throws Exception {

		PointsDistanceRequest body = new PointsDistanceRequest();
		body.setOrigin(new GeoPoint(40.6655101, -73.89188969999998));
		body.setDestination(new GeoPoint(-43.6655101, -73.89188969999998));
		MvcResult mvcResult = mvc.perform(
				post("/points").accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapToJson(body)))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
	}

	@Test
	public void getDistanceBetweenTwoPlacesValid() throws Exception {

		PlacesDistanceRequest body = new PlacesDistanceRequest();
		body.setOriginPlaceId("ChIJ674hC6Y_WBQRujtC6Jay33k");
		body.setDestinationPlaceId("ChIJ53DS_M8iWBQR2J-Ih9Zziwk");
		MvcResult mvcResult = mvc.perform(
				post("/places").accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapToJson(body)))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		PlacesInfoResponse response = mapFromJson(content,
				PlacesInfoResponse.class);
		assertTrue(response.getDistance().equals("34.1 km"));
	}

	@Test
	public void getDistanceBetweenTwoPlacesInvalid() throws Exception {

		PlacesDistanceRequest body = new PlacesDistanceRequest();
		body.setOriginPlaceId("ChIJ53DS_M8iWBQR2J-Ih9Zziwk");
		body.setDestinationPlaceId("ChIJpTvG15DL1IkRd8S0KlBVNTI");
		MvcResult mvcResult = mvc.perform(
				post("/places").accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapToJson(body)))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
	}
}
