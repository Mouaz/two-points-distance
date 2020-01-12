package com.mashkor.maps.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mashkor.maps.services.IGoogleApiBuilder;
import com.mashkor.models.GeoPoint;
import com.mashkor.models.GoogleDistanceResponse;

@Service
public class GoogleMapsClient implements IGoogleMapsClient {

	@Value("${google.api.embed.key}")
	private String embedMapkey;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IGoogleApiBuilder googleApiBuilder;

	@Override
	public String getDistanceBetweenTwoPoints(GeoPoint origin,
			GeoPoint destination) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String uri = googleApiBuilder.getDistanceBetweenTwoPoints(origin,
				destination);

		GoogleDistanceResponse resp = restTemplate.exchange(uri, HttpMethod.GET,
				entity, GoogleDistanceResponse.class).getBody();
		return resp.getDistance();
	}

	@Override
	public String getDistanceBetweenTwoPlaces(String originPlaceId,
			String destinationPlaceId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String uri = googleApiBuilder.getDistanceBetweenTwoPlaces(originPlaceId,
				destinationPlaceId);

		GoogleDistanceResponse resp = restTemplate.exchange(uri, HttpMethod.GET,
				entity, GoogleDistanceResponse.class).getBody();
		return resp.getDistance();
	}

	@Override
	public String getEmbedKey() {
		return embedMapkey;
	}

}
