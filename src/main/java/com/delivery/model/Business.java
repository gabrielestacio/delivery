package com.delivery.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Business{
	private Integer id;
	private String name;
	private String address;
	private String telephone;
	private List<Item> menu;
	private List<Order> activeOrders;
	
	public Business() {
		menu = new ArrayList<Item>();
		activeOrders = new ArrayList<Order>();
	}
	
	public Business(String name, String address, String telephone, ArrayList<Item> menu, ArrayList<Order> activeOrders) {
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.menu = menu;
		this.activeOrders = activeOrders;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Item> getMenu() {
		return menu;
	}

	public void setMenu(List<Item> menu) {
		this.menu = menu;
	}

	public List<Order> getActiveOrders() {
		return activeOrders;
	}

	public void setActiveOrders(List<Order> activeOrders) {
		this.activeOrders = activeOrders;
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
		
		Business other = (Business) obj;
		if (id != other.id) {
			return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		return "Business " + id + " [name = " + name + ", address = " + address + ", telephone = " + telephone +
				", menu = " + menu.toString() + ", active orders = " + activeOrders.toString() + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("name", name);
		temp.append("address", address);
		temp.append("telephone", telephone);
		temp.append("menu", menu.toString());
		temp.append("activeOrders", activeOrders.toString());
		
		return temp;
	}
}