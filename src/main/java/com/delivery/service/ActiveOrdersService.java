package com.delivery.service;

import com.delivery.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ActiveOrdersService{
	private List<Order> orders = new ArrayList<Order>();
	
	public String addOrder(Order order) {
		if(searchOrder(order) == -1) {
			orders.add(order);
			return "Pedido " + order.getId() + " cadastrado com sucesso.";
		}
		return "Pedido já cadastrado.";
	}
	
	public List<Order> getOrders(){
		return orders;
	}
	
	public Order getOrder(Order order) {
		int index = searchOrder(order);
		
		if(index != -1) {
			return orders.get(index);
		}
		
		return null;
	}
	
	public Order getOrderByPosition(int index) {
		return orders.get(index);
	}
	
	public Order getOrderById(int id) {
		int index = searchOrderById(id);
		
		if(index != -1) {
			return orders.get(index);
		}
		
		return null;
	}
	
	public String updateOrder(Order order) {
		int index = searchOrderById(order.getId());
		
		if(index != -1) {
			orders.set(index, order);
			return "Pedido " + order.getId() + " foi atualizado com sucesso.";
		}
		
		return "Pedido inexistente.";
	}
	
	public String deleteOrder(Order order) {
		int index = searchOrder(order);
		
		if(index != -1) {
			orders.remove(index);
			return "Pedido " + order.getId() + " removido com sucesso.";
		}
		
		return "Pedido inexistente.";
	}
	
	public String changeState(Order order) {
		OrderState state = order.getState();
		
		switch(state) {
			case REQUEST:
				state = OrderState.PREPARING;
				break;
			case PREPARING:
				state = OrderState.READY;
				break;
			case READY:
				state = OrderState.ON_THE_WAY;
				break;
			case ON_THE_WAY:
				state = OrderState.DELIVERED;
				break;
			default:
				//exception
				break;
		}
		
		order.setState(state);
		
		return "Pedido " + order.getId() + " alterado para " + state;
	}
	
	public int searchOrder(Order order) {
		for(int i  = 0; i < orders.size(); i++) {
			if(order.equals(orders.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchOrderById(int id) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getId() == id) {
				return i;
			}
		}
		
		return -1;
	}
}