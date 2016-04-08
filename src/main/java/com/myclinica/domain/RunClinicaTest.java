package com.myclinica.domain;

import java.util.Scanner;

public class RunClinicaTest {
	
	static Scanner scanner = new Scanner(System.in);
	static Clinica clinica = new Clinica();
	static Client client;
	static Animal animal;
	static int id = 0;

	public static void main(String[] args) {
		menu();		
	}
	
	/*@method menu шаблон меню
	 * @author demidenko
	 * @version 1.0
	 * */
	protected static void menu() {
		String exit = "no";
		while(!exit.equals("yes")) {
			System.out.println("Chose number: ");
			System.out.println("1. Add client");
			System.out.println("2. Add pet to client");
			System.out.println("3. Find client");
			System.out.println("\n ==========\n");
			System.out.print("Your choice: ");
			int number = scanner.nextInt();
			switch(number) {
			case 1: addClients();
			break;
			case 2: addAnimals();
			break;
			case 3: getClients();
			break;
			default : System.out.println("Error: number is wrong!");
			}
			System.out.print("\n Exit? (yes/no) ");
			exit = scanner.next();
			System.out.print("\n");
		}
		System.out.println("\n====Program finished=====");
		
	}
	
	/* @method addClients добавить клиента 
	 * @author demidenko
	 * @version 1.0 	
	*/
	protected static void addClients() {
		System.out.print("Enter client name: ");
		String name = scanner.next();
		clinica.addClient(id, name);
		client = clinica.getClient(id);
		System.out.println("Client " + client.getName() + ": was added.");
		id++;
	}
	
	/*@method addAnimals добавить питомца клиенту
	 * @author demidenko
	 * @version 1.0
	*/	
	protected static void addAnimals() {
		System.out.println("You want to add? (dog/cat) ");
		String pet = scanner.next();
		if(pet.equals("dog")) {
			System.out.println("Who has that animal? (name client) ");
			String nameClient = scanner.next();
			for(int i=0; i<clinica.numOfClients(); i++) {
				client = clinica.getClient(i);
				if(nameClient.equals(client.getName())) {
					System.out.println("Enter pet nickname: ");
					String nickname = scanner.next();
					client.addAnimal(new Dog(nickname));
					animal = client.getAnimal(client.getNumOfAnimals() - 1);
					System.out.println("The dog " + animal.getNickname() + ": was added.");
					System.out.println("The client is " + client.getName()
							+ " owns the dog " + animal.getNickname() + ".");
					
				}
			}
		}else if (pet.equals("cat")) {
			System.out.println("Who has that animal? (name client) ");
			String nameClient = scanner.next();
			for(int i=0; i<clinica.numOfClients(); i++) {
				client = clinica.getClient(i);
				if(nameClient.equals(client.getName())) {
					System.out.println("Enter pet nickname: ");
					String nickname = scanner.next();
					client.addAnimal(new Animal(nickname));
					animal = client.getAnimal(client.getNumOfAnimals() - 1);
					System.out.println("The cat " + animal.getNickname() + ": was added.");
					System.out.println("The client is " + client.getName()
							+ " owns the cat " + animal.getNickname() + ".");
				}
			}
			
		}else System.out.println("That animal doesn't exist in the list.");
	}
	
	/*@method getClients найти клиента по имени
	 *@author demidenko
	 *@version 1.0
	 **/
	protected static String getClients() {
		System.out.println("Enter client name: ");
		String name = scanner.next();
		for(int i=0; i<clinica.numOfClients(); i++) {
			client = clinica.getClient(i);
			if(name.equals(client.getName())) {
				System.out.println("Client " +client.getName()
						+  " was found. His id: " + client.getId()
						+ ". His animal is " + animal.getNickname());
			}else System.out.println("That name doesn't has in the list.");
		}
		return client.getName();
	}

}
