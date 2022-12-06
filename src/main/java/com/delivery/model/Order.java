package com.delivery.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class Order{
	private Integer id;
	private Business seller;
	private Client buyer;
	private String address;
	private Deliveryman deliveryman;
	private List<Object[]> itens;
	private Double totalValue;
	private Double totalWeight;
	private Double totalArea;
	private Integer totalQuantity;
	private LocalDateTime dateTime;
	private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private String details;
	private OrderState state;
	
	public Order() {
		itens = new ArrayList<Object[]>();
	}
	
	public Order(Business seller, Client buyer, String address, Deliveryman deliveryman,
			     ArrayList<Object[]> itens, Double totalValue, Double totalWeight, Double totalArea,
			     Integer totalQuantity, LocalDateTime dateTime, String details) {
		this.seller = seller;
		this.buyer = buyer;
		this.address = address;
		this.deliveryman = deliveryman;
		this.itens = itens;
		this.totalValue = totalValue;
		this.totalWeight = totalWeight;
		this.totalArea = totalArea;
		this.totalQuantity = totalQuantity;
		this.dateTime = dateTime;
		this.details = details;
	}
	
	public Integer getId() {
		return id;
	}

	/*public void setId(Integer id) {
		this.id = id;
	}*/
	
	public Business getSeller() {
		return seller;
	}

	public void setSeller(Business seller) {
		this.seller = seller;
	}

	public Client getBuyer() {
		return buyer;
	}

	public void setBuyer(Client buyer) {
		this.buyer = buyer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Deliveryman getDeliveryman() {
		return deliveryman;
	}

	public void setDeliveryman(Deliveryman deliveryman) {
		this.deliveryman = deliveryman;
	}

	public List<Object[]> getItens() {
		return itens;
	}

	public void setItens(List<Object[]> itens) {
		this.itens = itens;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Double getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Double totalArea) {
		this.totalArea = totalArea;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
		
		Order other = (Order) obj;
		if (id != other.id) {
			return false;
		}

		return true;
	}
	
	@Override
	public String toString() {
		return "Order " + id + " [seller = " + seller/*.getName()*/ + ", buyer = " + buyer/*.getName()*/ +
				", address = " + address + ", deliveryman = " + deliveryman/*.getName()*/ + ", itens = " +
				itens.toString() + ", total value = " + totalValue + ", total weight = " + totalWeight +
				", total area = " + totalArea + ", total quantity = " + totalQuantity + ". date time = " +
				dateTime.format(dateTimeFormat) + ", details = " + details + ", state = " + state + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("seller", seller/*.getName()*/);
		temp.append("buyer", buyer/*.getName()*/);
		temp.append("address", address);
		temp.append("deçiveryman", deliveryman/*.getName()*/);
		temp.append("itens", itens.toString());
		temp.append("totalValue", totalValue);
		temp.append("totalWeight", totalWeight);
		temp.append("totalArea", totalArea);
		temp.append("totalQuantity", totalQuantity);
		temp.append("dateTime", dateTime.format(dateTimeFormat));
		temp.append("details", details);
		temp.append("state", state);
		
		return temp;
	}
}