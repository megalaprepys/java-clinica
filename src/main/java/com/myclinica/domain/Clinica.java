package com.myclinica.domain;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
	
	private List<Client> clients = new ArrayList<Client>();
	private int numOfClient;
	
	protected Clinica() { }
	
	protected void addClient(int id, String name) {
		this.numOfClient = id;
		this.clients.add(new Client(id,name));		
	}
	
	protected Client getClient(int id) {
		return this.clients.get(id);
	}
	
	protected List<Client> getListOfClients() {
		return clients;
	}
	
	protected int numOfClients() {
		return clients.size();
	}
	
	
}
