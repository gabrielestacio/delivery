package com.delivery.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Client{
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String address;
	private String telephone;
	private List<Order> activeOrders;
	
	public Client() {
		activeOrders = new ArrayList<Order>();
	}
	
	public Client(String username, String password, String name, String address, String telephone, ArrayList<Order> activeOrders) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.activeOrders = activeOrders;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
		
		Client other = (Client) obj;
		if (id != other.id) {
			return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		return "Client " + id + " [username = " + username + ", password = " + password + ", name = " + name +
				", address = " + address + ", telephone = " + telephone + ", active orders = " + activeOrders.toString() + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("username", username);
		temp.append("password", password);
		temp.append("name", name);
		temp.append("address", address);
		temp.append("telephone", telephone);
		temp.append("activeOrders", activeOrders.toString());
		
		return temp;
	}
}