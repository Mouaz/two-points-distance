package com.mashkoor.maps.response;

public class ConfigResponse {

	private String embededMapKey;

	public ConfigResponse() {

	}

	public ConfigResponse(String embedKey) {
		this.embededMapKey = embedKey;
	}

	public String getEmbededMapKey() {
		return embededMapKey;
	}

	public void setEmbededMapKey(String embededMapKey) {
		this.embededMapKey = embededMapKey;
	}
}
