package com.mashkor.maps.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mashkoor.maps.response.ConfigResponse;
import com.mashkoor.maps.response.PlacesInfoResponse;
import com.mashkor.maps.client.IGoogleMapsClient;
import com.mashkor.maps.request.PlacesDistanceRequest;
import com.mashkor.maps.request.PointsDistanceRequest;

@RestController
public class MapsController {

	@Autowired
	private IGoogleMapsClient googleMapsClient;

	@PostMapping("/places")
	@ResponseBody
	public ResponseEntity<PlacesInfoResponse> getDistanceBetweenTwoPlaces(
			@RequestBody PlacesDistanceRequest req) {
		return Optional
				.ofNullable(googleMapsClient.getDistanceBetweenTwoPlaces(
						req.getOriginPlaceId(), req.getDestinationPlaceId()))
				.map(distance -> ResponseEntity.ok()
						.body(new PlacesInfoResponse(distance)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/points")
	@ResponseBody
	public ResponseEntity<PlacesInfoResponse> getDistanceBetweenTwoPoints(
			@RequestBody PointsDistanceRequest req) {

		return Optional
				.ofNullable(googleMapsClient.getDistanceBetweenTwoPoints(
						req.getOrigin(), req.getDestination()))
				.map(distance -> ResponseEntity.ok()
						.body(new PlacesInfoResponse(distance)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/config")
	@ResponseBody
	public ConfigResponse getConfig() {
		return new ConfigResponse(googleMapsClient.getEmbedKey());
	}
}
