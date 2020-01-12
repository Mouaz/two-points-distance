package com.mashkoor.maps.response;

public class PlacesInfoResponse {

	private String distance;

	public PlacesInfoResponse(String distance) {

		this.distance = distance;
	}

	public PlacesInfoResponse() {
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
