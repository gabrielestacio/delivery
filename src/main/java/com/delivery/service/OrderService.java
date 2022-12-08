package com.delivery.service;

import com.delivery.model.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
	private List<Object[]> itens = new ArrayList<Object[]>();
	private Double totalValue = 0.0;
	private Double totalWeight = 0.0;
	private Double totalVolume = 0.0;
	//private LocalDateTime dateTime;
	//private DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	
	
	public String addItem(Item item) {
		int i = searchItem(item);
		
		if(i == -1) {
			Object[] product = {1, item};
			itens.add(product);
			updateInfos(item);
			
			return "Item " + item.getName() + " adicionado com sucesso.";
		}
		else {
			Object[] obj = itens.get(i);
			int quantity = (int)obj[0] + 1;
			Object[] product = {quantity, obj[1]};
			itens.set(i, product);
			updateInfos(item);
			
			return "Item " + item.getName() + " já havia sido adicionado. Mais 1 unidade foi adicionada ao seu pedido.";
		}
	}
	
	public String addItemByQuantity(Item item, int qtt) {
		int i = searchItem(item);
		
		if(i == -1) {
			Object[] product = {qtt, item};
			itens.add(product);
			updateInfos(item);
			
			return "Item " + item.getName() + " adicionado com sucesso.";
		}
		else {
			Object[] obj = itens.get(i);
			int quantity = (int)obj[0] + qtt;
			Object[] product = {quantity, obj[1]};
			itens.set(i, product);
			updateInfos(item);
			
			return "Item " + item.getName() + " já havia sido adicionado. Mais " + quantity + " unidades foram adicionada ao seu pedido.";
		}
	}
	
	public List<Object[]> getItens(){
		return itens;
	}
	
	public Item getItem(Item item) {
		int index = searchItem(item);

		if(index != -1) {
			Object[] obj = itens.get(index);
			return (Item)obj[1];
		}
		
		return null;
	}
	
	public Item getItemByPosition(int index) {
		Object[] obj = itens.get(index);
		
		return (Item)obj[1];
	}
	
	public Item getItemByName(String name) {
		int index = searchItemByName(name);
		
		if(index != -1) {
			Object[] obj = itens.get(index);
			return (Item)obj[1];
		}
		
		return null;
	}
	
	public Item getItemById(int id) {
		int index = searchItemById(id);
		
		if(index != -1) {
			Object[] obj = itens.get(index);
			return (Item)obj[1];
		}
		
		return null;
	}
	
	public String updateItem(Item item) {
		int index = searchItemById(item.getId());
		
		if(index != -1) {
			Object[] obj = itens.get(index);
			int quantity = (int)obj[0];
			Object[] product = {quantity, item};
			itens.set(index, product);
			
			return "Item " + item.getName() + " atualizado com sucesso.";
		}
		
		return "Não foi possível achar este item neste pedido.";
	}
	
	public String updateQuantity(Item item, int quantity) {
		int index = searchItemById(item.getId());
		
		if(index != -1) {
			Object[] obj = itens.get(index);
			Object[] product = {quantity, (Item)obj[1]};
			itens.set(index, product);
			
			return "Quantidade do item " + item.getName() + " atualizada com sucesso.";
		}
		
		return "Não foi possível achar este item neste pedido.";
	}
	
	public String deleteItem(Item item) {
		int index = searchItem(item);
		
		if(index != -1) {
			itens.remove(index);
			
			return "Item " + item.getName() + " removido com sucesso.";
		}
		
		return "Não foi possível achar este item neste pedido.";
	}
	
	public int searchItem(Item item) {
		for(int i = 0; i < itens.size(); i++) {
			Object[] obj = itens.get(i);

			if(item.equals((Item)obj[1])) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchItemByName(String name) {
		Item temp;
		
		for(int i = 0; i < itens.size(); i++) {
			Object[] obj = itens.get(i);
			temp = (Item)obj[1];
			
			if(temp.getName() == name) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchItemById(int id) {
		Item temp;
		
		for(int i = 0; i < itens.size(); i++) {
			Object[] obj = itens.get(i);
			temp = (Item)obj[1];
			
			if(temp.getId() == id) {
				return i;
			}
		}
		
		return -1;
	}
	
	public void updateInfos(Item item) {
		this.totalValue += item.getValue();
		this.totalVolume += item.getVolume();
		this.totalWeight += item.getWeight();
		//this.dateTime = LocalDateTime.now(); //quando for salvar no bd, usar o formatter
	}
	
}