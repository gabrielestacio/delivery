package com.delivery.service;

//garantir que entregadores de nome iguais sejam salvos com ids diferentes

import com.delivery.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DeliverymanService{
	private List<Deliveryman> deliverymans = new ArrayList<Deliveryman>();
	
	public String addDeliveryman(Deliveryman dm) {
		int index = searchDeliveryman(dm);
		
		if(index == -1) {
			deliverymans.add(dm);
			return "Entregador " + dm.getName() + " adicionado com sucesso.";
		}
		
		return "Entregador já cadastrado.";
	}
	
	public List<Deliveryman> getDeliverymans(){
		return deliverymans;
	}
	
	public Deliveryman getDeliveryman(Deliveryman dm) {
		int index = searchDeliveryman(dm);
		
		if(index != -1) {
			return deliverymans.get(index);
		}
		
		return null;
	}
	
	public Deliveryman getDeliverymanByPosition(int index) {
		return deliverymans.get(index);
	}
	
	public Deliveryman getDeliverymanByName(String name) {
		int index = searchDeliverymanByName(name);
		
		if(index != -1) {
			return deliverymans.get(index);
		}
		
		return null;
	}
	
	public Deliveryman getDeliverymanById(int id) {
		int index = searchDeliverymanById(id);
		
		if(index != -1) {
			return deliverymans.get(index);
		}
		
		return null;
	}
	
	public String updateDeliveryman(Deliveryman dm) {
		int index = searchDeliverymanById(dm.getId());
		
		if(index != -1) {
			deliverymans.set(index, dm);
			return "Entregador " + dm.getName() + ", de ID " + dm.getId() + ", atualizado com sucesso.";
		}
		
		return "Entregador não encontrado.";
	}
	
	public String deleteDeliveryman(Deliveryman dm) {
		int index = searchDeliveryman(dm);
		
		if(index != -1) {
			deliverymans.remove(index);
			return "Entregador " + dm.getName() + ", de ID " + dm.getId() + ", removido com sucesso.";
		}
		
		return "Entregador não encontrado.";
	}
	
	public int searchDeliveryman(Deliveryman dm) {
		for(int i = 0; i < deliverymans.size(); i++) {
			if(dm.equals(deliverymans.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchDeliverymanByName(String name) {
		for(int i = 0; i < deliverymans.size(); i++) {
			if(name == deliverymans.get(i).getName()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchDeliverymanById(int id) {
		for(int i = 0; i < deliverymans.size(); i++) {
			if(id == deliverymans.get(i).getId()) {
				return i;
			}
		}
		
		return -1;
	}
}