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
	private Deliveryman deliveryman;
	private List<Object[]> itens;
	private Double totalValue;
	private Double totalWeight;
	private Double totalVolume;
	private LocalDateTime dateTime;
	private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	private OrderState state;
	
	public Order() {
		itens = new ArrayList<Object[]>();
	}
	
	public Order(Business seller, Client buyer, String address, Deliveryman deliveryman,
			     ArrayList<Object[]> itens, Double totalValue, Double totalWeight, Double totalVolume,
			     LocalDateTime dateTime, String details) {
		this.seller = seller;
		this.buyer = buyer;
		this.deliveryman = deliveryman;
		this.itens = itens;
		this.totalValue = totalValue;
		this.totalWeight = totalWeight;
		this.totalVolume = totalVolume;
		this.dateTime = dateTime;
		this.state = OrderState.REQUEST;
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

	public Double getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Double totalVolume) {
		this.totalVolume = totalVolume;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
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
				", address = " + buyer.getAddress() + ", deliveryman = " + deliveryman/*.getName()*/ + ", itens = " +
				itens.toString() + ", total value = " + totalValue + ", total weight = " + totalWeight +
				", total area = " + totalVolume + ". date time = " + dateTime.format(dateTimeFormat) + "]";
	}
	
	public JSONObject toJSON() {
		JSONObject temp = new JSONObject();
		
		temp.append("id", id);
		temp.append("seller", seller/*.getName()*/);
		temp.append("buyer", buyer/*.getName()*/);
		temp.append("address", buyer.getAddress());
		temp.append("deçiveryman", deliveryman/*.getName()*/);
		temp.append("itens", itens.toString());
		temp.append("totalValue", totalValue);
		temp.append("totalWeight", totalWeight);
		temp.append("totalArea", totalVolume);
		temp.append("dateTime", dateTime.format(dateTimeFormat));
		temp.append("state", state);
		
		return temp;
	}
}