package com.delivery.model;

import java.util.List;
import java.util.ArrayList;

import org.json.JSONObject;

public class Deliveryman{
	private Integer id;
	private String name;
	private String telephone;
	private Vehicle vehicleType;
	private List<Order> activeDeliveries;
	private Integer quantity;
	
	public Deliveryman() {}
	
	public Deliveryman(String name, String telephone, Vehicle vehicleType, ArrayList<Order> activeDeliveries, Integer quantity) {
		this.name = name;
		this.telephone = telephone;
		this.vehicleType = vehicleType;
		this.activeDeliveries = activeDeliveries;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Vehicle getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Vehicle vehicleType) {
		this.vehicleType = vehicleType;
	}

	public List<Order> getActiveDeliveries() {
		return activeDeliveries;
	}

	public void setActiveDeliveries(List<Order> activeDeliveries) {
		this.activeDeliveries = activeDeliveries;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		
		Deliveryman other = (Deliveryman) obj;
		if (id != other.id) {
			return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		return "Client " + id + " [name = " + name + ", telephone = " + telephone +
				"vehicle type = " + vehicleType + ", active deliveries = " + activeDeliveries.toString() +
				", quantity = " + quantity + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("name", name);
		temp.append("telephone", telephone);
		temp.append("vehicleType", vehicleType);
		temp.append("activeDeliveries", activeDeliveries.toString());
		temp.append("quantity", quantity);
		
		return temp;
	}
}