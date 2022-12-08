package com.delivery.service;

//garantir que lojas de nome iguais sejam salvos com ids diferentes

import com.delivery.model.*;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class BusinessService{
	private List<Business> businessList = new ArrayList<Business>();
	
	public String addBusinnes(Business business) {
		int index = searchBusiness(business);
		
		if(index == -1) {
			businessList.add(business);
			
			return "Loja " + business.getName() + " adicionada com sucesso.";
		}
		
		return "Loja " + business.getName() + "já foi cadastrada.";
	}
	
	public List<Business> getBusiness(){
		return businessList;
	}
	
	public Business getBusiness(Business business) {
		int index = searchBusiness(business);
		
		if(index != -1) {
			return businessList.get(index);
		}
		
		return null;
	}
	
	public Business getBusinessByPosition(int index) {
		return businessList.get(index);
	}
	
	public Business getBusinessByName(String name) {
		int index = searchBusinessByName(name);
		
		if(index != -1) {
			return businessList.get(index);
		}
		
		return null;
	}
	
	public Business getBusinessById(int id) {
		int index = searchBusinessById(id);
		
		if(index != -1) {
			return businessList.get(index);
		}
		
		return null;
	}
	
	public String updateBusiness(Business business) {
		int index = searchBusinessById(business.getId());
		
		if(index != -1) {
			businessList.set(index, business);
			return "Loja " + business.getName() + " atualizada com sucesso.";
		}
		
		return "Loja não cadastrada.";
	}
	
	public String deleteBusiness(Business business) {
		int index = searchBusiness(business);
		
		if(index != -1) {
			businessList.remove(index);
			return "Loja " + business.getName() + " removida com sucesso.";
		}
		
		return "Loja não cadastrada.";
	}
	
	public String changeState(Business business) {
		BusinessState state = business.getState();
		
		switch(state) {
			case OPEN:
				state = BusinessState.CLOSED;
				break;
			case CLOSED:
				state = BusinessState.OPEN;
				break;
			default:
				//exception
				break;
		}
		
		business.setState(state);
		
		return "Loja " + business.getName() + " teve seu estado alterado para " + state;
	}
	
	public int searchBusiness(Business business) {
		for(int i = 0; i < businessList.size(); i++) {
			if(business.equals(businessList.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchBusinessByName(String name) {
		for(int i = 0; i < businessList.size(); i++) {
			if(name == businessList.get(i).getName()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchBusinessById(int id) {
		for(int i = 0; i < businessList.size(); i++) {
			if(id == businessList.get(i).getId()) {
				return i;
			}
		}
		
		return -1;
	}
}