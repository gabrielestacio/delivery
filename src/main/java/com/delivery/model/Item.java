package com.delivery.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.json.JSONObject;

public class Item{
	//fazer id autogerado pelo spring
	private Integer id;
	private String name;
	private Double value;
	private Double weight;
	private Double volume;
	private Date registrationDate;
	private ItemState state;
	private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, new Locale("br", "BR"));
	private String description;
	
	public Item() {
		//id
	}
	
	public Item(String name, Double value, Double weight, Double volume, Date registrationDate, ItemState state, String description) {
		//id
		this.name = name;
		this.value = value;
		this.weight = weight;
		this.volume = volume;
		this.registrationDate = registrationDate;
		this.state = state;
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
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registration) {
		this.registrationDate = registration;
	}
	
	public ItemState getState() {
		return state;
	}

	public void setState(ItemState state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = prime * 1 + ((id == null) ? 0 : id.hashCode());

		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Item other = (Item) obj;
		if (id != other.id) {
			return false;
		}
		
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Item " + id + " [name = " + name + ", value = " + value +
				", weight = " + weight + ", volume = " + volume + ", registration = " + ", state = " + state.toString() +
				dateFormat.format(registrationDate) + ", description = " + description + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("name", name);
		temp.append("value", value);
		temp.append("weight", weight);
		temp.append("volume", volume);
		temp.append("state", state.toString());
		temp.append("registration", dateFormat.format(registrationDate));
		temp.append("description", description);
		
		return temp;
	}
}