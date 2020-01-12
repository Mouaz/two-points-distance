package com.mashkor.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"text", "value"})
class Distance {

	@JsonProperty("text")
	private String text;
	@JsonProperty("value")
	private Integer value;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("value")
	public Integer getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(Integer value) {
		this.value = value;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"text", "value"})
class Duration {

	@JsonProperty("text")
	private String text;
	@JsonProperty("value")
	private Integer value;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("text")
	public void setText(String text) {
		this.text = text;
	}

	@JsonProperty("value")
	public Integer getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(Integer value) {
		this.value = value;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"distance", "duration", "status"})
class Element {

	@JsonProperty("distance")
	private Distance distance;
	@JsonProperty("duration")
	private Duration duration;
	@JsonProperty("status")
	private String status;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("distance")
	public Distance getDistance() {
		return distance;
	}

	@JsonProperty("distance")
	public void setDistance(Distance distance) {
		this.distance = distance;
	}

	@JsonProperty("duration")
	public Duration getDuration() {
		return duration;
	}

	@JsonProperty("duration")
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"destination_addresses", "origin_addresses", "rows",
		"status"})
public class GoogleDistanceResponse {

	@JsonProperty("destination_addresses")
	private List<String> destinationAddresses = null;
	@JsonProperty("origin_addresses")
	private List<String> originAddresses = null;
	@JsonProperty("rows")
	private List<Row> rows = null;
	@JsonProperty("status")
	private String status;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("destination_addresses")
	public List<String> getDestinationAddresses() {
		return destinationAddresses;
	}

	@JsonProperty("destination_addresses")
	public void setDestinationAddresses(List<String> destinationAddresses) {
		this.destinationAddresses = destinationAddresses;
	}

	@JsonProperty("origin_addresses")
	public List<String> getOriginAddresses() {
		return originAddresses;
	}

	@JsonProperty("origin_addresses")
	public void setOriginAddresses(List<String> originAddresses) {
		this.originAddresses = originAddresses;
	}

	@JsonProperty("rows")
	public List<Row> getRows() {
		return rows;
	}

	@JsonProperty("rows")
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public String getDistance() {
		Element info = this.rows.get(0).getElements().get(0);
		return info.getStatus().equals("ZERO_RESULTS")
				|| info.getStatus().equals("NOT_FOUND")
						? null
						: info.getDistance().getText();
	}
}

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"elements"})
class Row {

	@JsonProperty("elements")
	private List<Element> elements = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("elements")
	public List<Element> getElements() {
		return elements;
	}

	@JsonProperty("elements")
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}