package com.delivery.service;

//garantir que clientes de nome iguais sejam salvos com ids diferentes

import com.delivery.model.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClientService{
	private List<Client> clients = new ArrayList<Client>();
	
	public String addClient(Client client) {
		int index = searchClient(client);
		
		if(index == -1) {
			clients.add(client);
			return "Cliente " + client.getName() + ", de ID " + client.getId() + ", cadastrado com sucesso.";
		}
		
		return "Cliente já cadastrado.";
	}
	
	public List<Client> getClients(){
		return clients;
	}
	
	public Client getClient(Client client) {
		int index = searchClient(client);
		
		if(index != -1) {
			return clients.get(index);
		}
		
		return null;
	}
	
	public Client getClientByPosition(int index) {
		return clients.get(index);
	}
	
	public Client getClientByName(String name) {
		int index = searchClientByName(name);
		
		if(index != -1) {
			return clients.get(index);
		}
		
		return null;
	}
	
	public Client getClientById(int id) {
		int index = searchClientById(id);
		
		if(index != -1) {
			return clients.get(index);
		}
		
		return null;
	}
	
	public String updateClient(Client client) {
		int index = searchClientById(client.getId());
		
		if(index != -1) {
			clients.set(index, client);
			return "Cliente " + client.getName() + ", de ID " + client.getId() + ", atualizado com sucesso.";
		}
		
		return "Cliente não encontrado.";
	}
	
	public String deleteClient(Client client) {
		int index = searchClient(client);
		
		if(index != -1) {
			clients.remove(index);
			return "Cliente " + client.getName() + ", de ID " + client.getId() + ", removido com sucesso.";
		}
		
		return "Cliente não encontrado.";
	}
	
	public int searchClient(Client client) {
		for(int i = 0; i < clients.size(); i++) {
			if(client.equals(clients.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchClientByName(String name) {
		for(int i = 0; i < clients.size(); i++) {
			if(name == clients.get(i).getName()) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int searchClientById(int id) {
		for(int i = 0; i < clients.size(); i++) {
			if(id == clients.get(i).getId()) {
				return i;
			}
		}
		
		return -1;
	}
}