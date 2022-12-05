package com.delivery.model;

import java.util.Date;
import org.json.JSONObject;

public class Item{
	//fazer id autogerado pelo spring
	private Integer id;
	private String name;
	private Double value;
	private Double weight;
	private Double volume;
	private Integer quantity;
	private Date registration;
	private String description;
	
	public Item() {
		//id
	}
	
	public Item(String name, Double value, Double weight, Double volume, Integer quantity, Date registration, String description) {
		//id
		this.name = name;
		this.value = value;
		this.weight = weight;
		this.volume = volume;
		this.quantity = quantity;
		this.registration = registration;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}*/
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Double getVolume() {
		return volume;
	}
	
	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Date getRegistration() {
		return registration;
	}
	
	public void setRegistration(Date registration) {
		this.registration = registration;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("name", name);
		temp.append("value", value);
		temp.append("weight", weight);
		temp.append("volume", volume);
		temp.append("quantity", quantity);
		temp.append("registration", registration);
		temp.append("description", description);
		
		return temp;
	}
	
	public String toString() {
		String temp = new String();
		
		temp += id + ", ";
		temp += name + ", ";
		temp += value + ", ";
		temp += weight + ", ";
		temp += volume + ", ";
		temp += quantity + ", ";
		temp += registration + ", ";
		temp += description + ", ";
		
		return temp;
	}
}