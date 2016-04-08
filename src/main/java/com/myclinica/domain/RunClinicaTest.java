package com.myclinica.domain;

import java.util.Scanner;


public class RunClinicaTest {
	
	static Scanner scanner = new Scanner(System.in);
	static Clinica clinica = new Clinica();
	static Client client;
	static Animal animal;
	static int id = 0;

	public static void main(String[] args) throws MyException {
		menu();		
	}
	
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
			case 1: {
					while(!exit.equals("yes")) {
						addClients();
						System.out.println("\n Do you want to add more client? (yes/no)");
						String answer = scanner.next();
						if(answer.equals("no")) exit = "yes";
						else if (answer.equals("yes")) exit = "no";
						else {
							System.out.println("\n You enter wrong answer. ");
							exit = "yes";
						}
					}
			}
			break;
			case 2: {
				while(!exit.equals("yes")) {
					try {
						addAnimals();
						System.out.println("\n Do you want to add more pet? (yes/no)");
						String answer = scanner.next();
						if(answer.equals("no")) exit = "yes";
						else if (answer.equals("yes")) exit = "no";
						else {
							System.out.println("\n You enter wrong answer. ");
							exit = "yes";
						}
					} catch (MyException e) {
						System.out.println(e.getMessage());
					}
				}
			}
			break;
			case 3: {
				while(!exit.equals("yes")) {
					getClients();
					System.out.println("\n Do you want to get more client? (yes/no)");
					String answer = scanner.next();
					if(answer.equals("no")) exit = "yes";
					else if (answer.equals("yes")) exit = "no";
					else {
						System.out.println("\n You enter wrong answer. ");
						exit = "yes";
					}
				}
			}
			break;
			default : System.out.println("Error: number is wrong!");
			}
			System.out.print("\n Exit? (yes/no) ");
			exit = scanner.next();
			System.out.print("\n");
		}
		System.out.println("\n====Program finished=====");
		
	}
	
	
	protected static void addClients() {
		System.out.print("Enter client name: ");
		String name = scanner.next();
		clinica.addClient(id, name);
		client = clinica.getClient(id);
		System.out.println("\n Client " + client.getName() + ": was added.");
		id++;
	}
		
	protected static void addAnimals() throws MyException {
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
					animal.setSex("dog");
					System.out.println("The " +animal.getSex() 
							+ " "+ animal.getNickname() + ": was added.");
					System.out.println("The client is " + client.getName()
							+ " owns the dog " + animal.getNickname() + ".");
					break;
				}
				else if(i == (clinica.numOfClients()-1)) {
					throw new MyException("\n Error! Client is " + nameClient.toString() + " not found.\n");
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
					client.addAnimal(new Cat(nickname));
					animal = client.getAnimal(client.getNumOfAnimals() - 1);
					animal.setSex("cat");
					System.out.println("The " + animal.getSex() 
							+ " "+ animal.getNickname() + ": was added.");
					System.out.println("The client is " + client.getName()
							+ " owns the cat " + animal.getNickname() + ".");
					break;
				}
				else if(i == (clinica.numOfClients()-1)) {
					throw new MyException("\n Error! Client is " + nameClient.toString() + " not found.\n");
				}
			}
			
		}else System.out.println("That animal doesn't exist in the list.");
	}
	
	protected static String getClients() {
		System.out.println("Enter client name: ");
		String name = scanner.next();
		for(int i=0; i<clinica.numOfClients(); i++) {
			client = clinica.getClient(i);
			if(name.equals(client.getName())) {
				System.out.println("Client " +client.getName()	+  " was found");
				System.out.println("Id: " + client.getId());
				System.out.println( "The " + animal.getSex() + " is " + animal.getNickname());
			}
		}
		return client.getName();
	}

}
