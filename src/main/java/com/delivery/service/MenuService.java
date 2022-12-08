package com.delivery.service;

import com.delivery.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MenuService{
	private List<Item> catalog = new ArrayList<Item>();
	
	public String addItem(Item item) {
		if(searchItem(item) == -1) {
			catalog.add(item);
			return "Item " + item.getName() + " cadastrado com sucesso.";
		}
		return "Item " + item.getName() + " já foi cadastrado no catálogo.";
	}
	
	public List<Item> getItens(){
		return catalog;
	}
	
	public Item getItem(Item item) {
		int index = searchItem(item);
		
		if(index != -1) {
			return catalog.get(index);
		}
		
		return null;
	}
	
	public Item getItemByPosition(int index) {
		if(index < catalog.size()) {
			return catalog.get(index);
		}
		return null;
	}
	
	public Item getItemByName(String name) {
		int index = searchItemByName(name);
		
		if(index != -1) {
			return catalog.get(index);
		}
		
		return null;
	}
	
	public Item getItemById(int id) {
		int index = searchItemById(id);
		
		if(index != -1) {
			return catalog.get(index);
		}
		
		return null;
	}
	
	public String updateItem(Item item) {
		int index = searchItemById(item.getId());
		
		if(index != -1) {
			catalog.set(index, item);
			return "Item " + item.getName() + " foi atualizado com sucesso.";
		}
		
		return "Item " + item.getName() + " não existe no catálogo.";
	}
	
	public String deleteItem(Item item) {
		int index = searchItem(item);
		
		if(index != -1) {
			catalog.remove(index);
			return "Item " + item.getName() + " removido com sucesso.";
		}
		
		return "Item " + item.getName() + " não existe no catálogo.";
	}
	
	public String changeState(Item item) {
		ItemState state = item.getState();
		
		switch(state) {
			case AVAILABLE:
				state = ItemState.UNAVAILABLE;
				break;
			case UNAVAILABLE:
				state = ItemState.AVAILABLE;
				break;
			default:
				//exceção
				break;
		}
		
		item.setState(state);
		
		return "Estado do item " + item.getName() + " alterado com sucesso.";
	}
	
	public int searchItem(Item item) {
		for(int i = 0; i < catalog.size(); i++) {
			if(item.equals(catalog.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public int searchItemByName(String name) {
		for(int i = 0; i < catalog.size(); i++) {
			if(catalog.get(i).getName() == name) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchItemById(int id) {
		for(int i = 0; i < catalog.size(); i++) {
			if(catalog.get(i).getId() == id) {
				return i;
			}
		}
		
		return -1;
	}
}