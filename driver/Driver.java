//---------------------------------------------------------
//Assignment 1
//Question: 1
//Written by: (Nicolas Sorescu 40312759)
//---------------------------------------------------------
package driver;
import vehicle.*;
import client.*;
import java.util.Scanner;

public class Driver {
	private static Scanner input = new Scanner(System.in);
	private static int option;
	private static Vehicles[] rentalVehicles = new Vehicles[0];
	private static Client[] clientList = new Client[0];
	
	private static DieselTrucks[] dieselTrucks = new DieselTrucks[0];
	private static ElectricTrucks[] electricTrucks = new ElectricTrucks[0];
	private static GasolineCars[] gasolineCars = new GasolineCars[0];
	private static ElectricCars[] electricCars = new ElectricCars[0];
	
	
	public static void main(String[] args) 
	{
		//varible that keeps the loop running
		boolean runProgram = true;
		int option;
		if(!predefinedScenario()) runProgram = false;
		//switch statment for all cases
		while(runProgram)
		{
			makeSmallArrays();
			mainMenu();
			
			option = validInputLoop(0, 4);
				
			switch(option)
			{
			case 1:
			vehicleManagementOptions();
				break;
			case 2:
			clientManagementOptions();
				break;
			case 3:
			leasingManagementOptions();
				break;
			case 4:
			additionalOperationsOptions();
				break;
			case 0:
			System.out.println("Thank you for using RoyalRentals!");
			runProgram = false;
				break;
			default:
				invalidInputCheck(0, option, 4);
			}
		}
		
		input.close();
		
	}
	
	//All of the main menues
	public static void mainMenu()
	{
		System.out.print("""
				
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| Welcome to RoyalRentals                                                               |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| What would you like to do?                                                            |
			| 1 -> Vehicle Management                                                               |
			| 2 -> Client Management                                                                |
			| 3 -> Leasing Operations                                                               |
			| 4 -> Additional Operations                                                            |
			| 0 -> To quit                                                                          |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			Please enter your choice and press (enter):
				""");
	}
	public static void vehicleManagementMenu()
	{
		System.out.print("""
				
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| Welcome to Vehicle Management                                                         |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| What would you like to do?                                                            |
			| 1 -> Add a vehicle                                                                    |
			| 2 -> Delete a vehicle                                                                 |
			| 3 -> Update vehicle information                                                       |
			| 4 -> List all vehicles by category (electric trucks, diesel trucks, etc.)             |
			| 0 -> To go back                                                                       |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			Please enter your choice and press (enter):
				""");
	}
	public static void clientManagementMenu()
	{
		System.out.print("""
				
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| Welcome to RoyalRentals                                                               |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| What would you like to do?                                                            |
			| 1 -> Add a client                                                                     |
			| 2 -> Edit a client                                                                    |
			| 3 -> Delete a client                                                                  |
			| 0 -> To quit                                                                          |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			Please enter your choice and press (enter):
				""");
	}
	public static void leasingOperationsMenu()
	{
		System.out.print("""
				
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| Welcome to RoyalRentals                                                               |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| What would you like to do?                                                            |
			| 1 -> Lease a vehicle to a client                                                      |
			| 2 -> Return a vehicle from a client                                                   |
			| 3 -> Show all vehicles leased by a client                                             |
			| 4 -> Show all leased vehicles (by all clients)                                        |
			| 0 -> To quit                                                                          |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			Please enter your choice and press (enter):
				""");
	}
	public static void additionalOperationsMenu()
	{
		System.out.print("""
				
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| Welcome to RoyalRentals                                                               |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			| What would you like to do?                                                            |
			| 1 -> Display the truck with the largest capacity                                      |
			| 2 -> Create a copy of the electric trucks array (see below)                           |
			| 0 -> To quit                                                                          |
			+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
			Please enter your choice and press (enter):
				""");
	}
	//This is just a method to check for valid inputs
	public static Boolean invalidInputCheck(int lowBound, int userInput, int highBound)
	{
		if(lowBound > userInput || userInput > highBound)
		{
			System.out.println("Sorry this is not a valid input. Try again (Valid numbers are from " + lowBound + " to " + highBound + ")");
			return true;
		}
		return false;
	}
	public static int inputHandel()
	{
		int numberInput = 0;
		try 
		{
			numberInput = input.nextInt();
			return numberInput;
		}
		catch (Exception q)
		{
			input.nextLine();
		}
		return 10000;
	}
	public static int validInputLoop(int lowBound, int highBound)

	{
		option = inputHandel();
		while(invalidInputCheck(lowBound, option, highBound))
		{
			option = inputHandel();
		}
		return option;
	}
	//inputHandel
	public static void vehicleManagementOptions()
	{
		boolean runProgram = true;
		//switch statment for all cases
		while(runProgram)
		{
			vehicleManagementMenu();
			option = validInputLoop(0, 4);
				
			switch(option)
			{
			case 1:
			addVehicle();
				break;
			case 2:
			deleteVehicle();
				break;
			case 3:
			updateVehicle();
				break;
			case 4:
			listVehicle();
				break;
			case 0:
			runProgram = false;
				break;
			default:
				invalidInputCheck(0, option, 4);
			}
		}
	}
	public static void addVehicle()
		{
			System.out.println("What kind of vehicle would you like to add?\n((1) Diesel truck, (2) Electric truck, (3) Gasoline car, (4) Electric car), (0) Exit)");
			option = validInputLoop(0, 4);
			
			String make;
			String model;
			int yearOfProduction;
			
			int maximumCapacity;
			int tankCapacity;
			int autonomyRange;
			int maximumPassengers;
			
			Vehicles[] rentalVehiclesClone = new Vehicles[rentalVehicles.length + 1];
			
			switch(option)
			{
			case 1:
			System.out.println("Diesel truck\nWhat is the car brand?");
			make = input.next();
			System.out.println("What is the car model?");
			model = input.next();
			System.out.println("What is the car's year of production?");
			yearOfProduction = input.nextInt();
			
			System.out.println("What is the car's maximum capacity?");
			maximumCapacity = input.nextInt();
			System.out.println("What is the car's tank capacity?");
			tankCapacity = input.nextInt();
			
			DieselTrucks dieselTruck  = new DieselTrucks(make, model, yearOfProduction, maximumCapacity, tankCapacity);

			for (int i = 0; i < rentalVehicles.length; i++)
			{
				rentalVehiclesClone[i] = rentalVehicles[i];
			}
			rentalVehiclesClone[rentalVehicles.length] = dieselTruck;
			rentalVehicles = rentalVehiclesClone;
			System.out.println("Vehicle has been added");
				break;
			
			case 2:
			System.out.println("Electric truck\nWhat is the car brand?");
			make = input.next();
			System.out.println("What is the car model?");
			model = input.next();
			System.out.println("What is the car's year of production?");
			yearOfProduction = input.nextInt();
			
			System.out.println("What is the car's maximum capacity?");
			maximumCapacity = input.nextInt();
			System.out.println("What is the car's autonomy range?");
			autonomyRange = input.nextInt();
				
			ElectricTrucks electricTruck  = new ElectricTrucks(make, model, yearOfProduction, maximumCapacity, autonomyRange);
			
			for (int i = 0; i < rentalVehicles.length; i++)
			{
				rentalVehiclesClone[i] = rentalVehicles[i];
			}
			rentalVehiclesClone[rentalVehicles.length] = electricTruck;
			rentalVehicles = rentalVehiclesClone;
			System.out.println("Vehicle has been added");
				break;
				
			case 3:
			System.out.println("Gasoline cars\nWhat is the car brand?");
			make = input.next();
			System.out.println("What is the car model?");
			model = input.next();
			System.out.println("What is the car's year of production?");
			yearOfProduction = input.nextInt();
				
			System.out.println("What is the car's maximum passengers?");
			maximumPassengers = input.nextInt();
					
			GasolineCars gasolineCar  = new GasolineCars(make, model, yearOfProduction, maximumPassengers);
			
			for (int i = 0; i < rentalVehicles.length; i++)
			{
				rentalVehiclesClone[i] = rentalVehicles[i];
			}
			rentalVehiclesClone[rentalVehicles.length] = gasolineCar;
			rentalVehicles = rentalVehiclesClone;
			System.out.println("Vehicle has been added");
				break;
				
			case 4:
			System.out.println("Gasoline cars\nWhat is the car brand?");
			make = input.next();
			System.out.println("What is the car model?");
			model = input.next();
			System.out.println("What is the car's year of production?");
			yearOfProduction = input.nextInt();
					
			System.out.println("What is the car's maximum passengers?");
			maximumPassengers = input.nextInt();
			System.out.println("What is the car's autonomy range?");
			autonomyRange = input.nextInt();
						
			ElectricCars electricCar  = new ElectricCars(make, model, yearOfProduction, maximumPassengers, autonomyRange);
			
			for (int i = 0; i < rentalVehicles.length; i++)
			{
				rentalVehiclesClone[i] = rentalVehicles[i];
			}
			rentalVehiclesClone[rentalVehicles.length] = electricCar;
			rentalVehicles = rentalVehiclesClone;
			System.out.println("Vehicle has been added");
				break;
				
			case 0:
				break;
			}
		}
	public static void deleteVehicle() 
		{
			int toDelete;
			Vehicles[] rentalVehiclesClone = new Vehicles[rentalVehicles.length - 1];
			
			if(rentalVehicles.length < 1)
			{
				System.out.println("No rental vehicle to delete");
			}
			else
			{
				for(int i = 0; i < rentalVehicles.length; i++)
				{
					System.out.println("Vehicle number " + i + "\n");
					System.out.println(rentalVehicles[i].toString());
				}
				System.out.println("What vehicle to delete? Pick from 0 to " + (rentalVehicles.length - 1));
				toDelete = validInputLoop(0, rentalVehicles.length - 1);
				
				if(rentalVehicles[toDelete].getIsLeased())
				{
					System.out.println("Cannot Delete a vehicle while leased!");
				}
				else
				{
					for(int i = 0, k = 0; i < rentalVehicles.length; i++)
					{
						if (i != toDelete)
						{
							rentalVehiclesClone[k] = rentalVehicles[i];
							k++;
						}
					}
					rentalVehicles = rentalVehiclesClone;
					System.out.println("Vehicle has been deleted");
				}
			}
		}
	public static void updateVehicle() 
		{
			int vehicleToUpdate;
			int toUpdate;
			
			if(rentalVehicles.length < 1)
			{
				System.out.println("No rental vehicle to update");
			}
			else
			{
				System.out.println("What vehicle to update? Pick from 0 to " + (rentalVehicles.length - 1));
				vehicleToUpdate = validInputLoop(0, rentalVehicles.length - 1);
				
				if(rentalVehicles[vehicleToUpdate].getIsLeased())
				{
					System.out.println("Cannot update a vehicle while leased!");
				}
				else
				{
					if(rentalVehicles[vehicleToUpdate] instanceof DieselTrucks)
					{
						System.out.println(rentalVehicles[vehicleToUpdate].toString());
						System.out.println("What do you want to update?\n (1) brand, (2) model, (3) year of production, (4) maximum capacity, (5) tank capacity, (0) Exit");
						toUpdate = validInputLoop(0, 5);
						switch(toUpdate)
						{
						case 1:
							System.out.println("What is the new brand");
							String newMake = input.next();
							rentalVehicles[vehicleToUpdate].setMake(newMake);
							System.out.println("Vehicle has been edited");
							break;
						case 2:
							System.out.println("What is the new model");
							String newModel = input.next();
							rentalVehicles[vehicleToUpdate].setModel(newModel);
							System.out.println("Vehicle has been edited");
							break;
						case 3:
							System.out.println("What is the new year of production");
							int newYearOfProduction = input.nextInt();
							rentalVehicles[vehicleToUpdate].setYearOfProduction(newYearOfProduction);
							System.out.println("Vehicle has been edited");
							break;
							
						case 4:
							System.out.println("What is the new maximum capacity");
							int maximumCapacity = input.nextInt();
							((DieselTrucks) rentalVehicles[vehicleToUpdate]).setMaximumCapacity(maximumCapacity);
							System.out.println("Vehicle has been edited");
							break;
						case 5:
							System.out.println("What is the new tank capacity");
							int tankCapacity = input.nextInt();
							((DieselTrucks) rentalVehicles[vehicleToUpdate]).setTankCapacity(tankCapacity);
							System.out.println("Vehicle has been edited");
							break;
						case 0:
							break;
						}
						
					}
					if(rentalVehicles[vehicleToUpdate] instanceof ElectricTrucks)
					{
						System.out.println("What do you want to update?\n (1) brand, (2) model, (3) year of production, (4) maximum capacity, (5) autonomy range, (0) Exit");
						toUpdate = validInputLoop(0, 5);
						switch(toUpdate)
						{
						case 1:
							System.out.println("What is the new brand");
							String newMake = input.next();
							rentalVehicles[vehicleToUpdate].setMake(newMake);
							System.out.println("Vehicle has been edited");
							break;
						case 2:
							System.out.println("What is the new model");
							String newModel = input.next();
							rentalVehicles[vehicleToUpdate].setModel(newModel);
							System.out.println("Vehicle has been edited");
							break;
						case 3:
							System.out.println("What is the new year of production");
							int newYearOfProduction = input.nextInt();
							rentalVehicles[vehicleToUpdate].setYearOfProduction(newYearOfProduction);
							System.out.println("Vehicle has been edited");
							break;
							
						case 4:
							System.out.println("What is the new maximum capacity");
							int maximumCapacity = input.nextInt();
							((ElectricTrucks) rentalVehicles[vehicleToUpdate]).setMaximumCapacity(maximumCapacity);
							System.out.println("Vehicle has been edited");
							break;
						case 5:
							System.out.println("What is the new autonomy range");
							int autonomyRange = input.nextInt();
							((ElectricTrucks) rentalVehicles[vehicleToUpdate]).setAutonomyRange(autonomyRange);
							System.out.println("Vehicle has been edited");
							break;
						case 0:
							break;
						}
					}
					if(rentalVehicles[vehicleToUpdate] instanceof GasolineCars)
					{
						System.out.println("What do you want to update?\n (1) brand, (2) model, (3) year of production, (4) maximum passengers, (0) Exit");
						toUpdate = validInputLoop(0, 4);
						switch(toUpdate)
						{
						case 1:
							System.out.println("What is the new brand");
							String newMake = input.next();
							rentalVehicles[vehicleToUpdate].setMake(newMake);
							System.out.println("Vehicle has been edited");
							break;
						case 2:
							System.out.println("What is the new model");
							String newModel = input.next();
							rentalVehicles[vehicleToUpdate].setModel(newModel);
							System.out.println("Vehicle has been edited");
							break;
						case 3:
							System.out.println("What is the new year of production");
							int newYearOfProduction = input.nextInt();
							rentalVehicles[vehicleToUpdate].setYearOfProduction(newYearOfProduction);
							System.out.println("Vehicle has been edited");
							break;
							
						case 4:
							System.out.println("What is the new maximum passengers");
							int maximumPassengers = input.nextInt();
							((GasolineCars) rentalVehicles[vehicleToUpdate]).setMaximumPassengers(maximumPassengers);
							System.out.println("Vehicle has been edited");
							break;
						case 0:
							break;
						}
					}
					if(rentalVehicles[vehicleToUpdate] instanceof ElectricCars)
					{
						System.out.println("What do you want to update?\n (1) brand, (2) model, (3) year of production, (4) maximum passengers, (5) autonomy range, (0) Exit");
						toUpdate = validInputLoop(0, 5);
						switch(toUpdate)
						{
						case 1:
							System.out.println("What is the new brand");
							String newMake = input.next();
							rentalVehicles[vehicleToUpdate].setMake(newMake);
							System.out.println("Vehicle has been edited");
							break;
						case 2:
							System.out.println("What is the new model");
							String newModel = input.next();
							rentalVehicles[vehicleToUpdate].setModel(newModel);
							System.out.println("Vehicle has been edited");
							break;
						case 3:
							System.out.println("What is the new year of production");
							int newYearOfProduction = input.nextInt();
							rentalVehicles[vehicleToUpdate].setYearOfProduction(newYearOfProduction);
							System.out.println("Vehicle has been edited");
							break;
							
						case 4:
							System.out.println("What is the new maximum passengers");
							int maximumPassengers = input.nextInt();
							((ElectricCars) rentalVehicles[vehicleToUpdate]).setMaximumPassengers(maximumPassengers);
							System.out.println("Vehicle has been edited");
							break;
						case 5:
							System.out.println("What is the new autonomy range");
							int autonomyRange = input.nextInt();
							((ElectricCars) rentalVehicles[vehicleToUpdate]).setAutonomyRange(autonomyRange);
							System.out.println("Vehicle has been edited");
							break;
						case 0:
							break;
						}
					}
				}
			}
		}
	public static void listVehicle() 
		{
			if(rentalVehicles.length < 1)
			{
				System.out.println("No rental vehicle");
			}
			else 
			{
				System.out.println("Diesel Trucks:\n");
				for(int i = 0; i < rentalVehicles.length; i++)
				{
					if(rentalVehicles[i] instanceof DieselTrucks)
					{
						System.out.println(rentalVehicles[i].toString());
					}
				}
				System.out.println("\nElectric Trucks:\n");
				for(int i = 0; i < rentalVehicles.length; i++)
				{
					if(rentalVehicles[i] instanceof ElectricTrucks)
					{
						System.out.println(rentalVehicles[i].toString());
					}
				}
				System.out.println("\nElectric Cars:\n");
				for(int i = 0; i < rentalVehicles.length; i++)
				{
					if(rentalVehicles[i] instanceof ElectricCars)
					{
						System.out.println(rentalVehicles[i].toString());
					}
				}
				System.out.println("\nGasoline Cars:\n");
				for(int i = 0; i < rentalVehicles.length; i++)
				{
					if(rentalVehicles[i] instanceof GasolineCars)
					{
						System.out.println(rentalVehicles[i].toString());
					}
				}
			}
		}
	//vehicleManagement
	public static void clientManagementOptions()
	{
		boolean runProgram = true;
		//switch statment for all cases
		while(runProgram)
		{
			clientManagementMenu();
			option = validInputLoop(0, 3);
				
			switch(option)
			{
			case 1:
			addClient();
				break;
			case 2:
			editClient();
				break;
			case 3:
			deleteClient();
				break;
			case 0:
			runProgram = false;
				break;
			default:
				invalidInputCheck(0, option, 4);
			}
		}
	}
	public static void addClient()
	{
		System.out.println("What is the name of the new client");
		String name = input.next();
		System.out.println("What is the age of the new client (Between 18 and 130)");
		int age = validInputLoop(18, 130);
		Client clientNew  = new Client(name, age);
		Client[] clientListClone = new Client[clientList.length + 1];
		
		for (int i = 0; i < clientList.length; i++)
		{
			clientListClone[i] = clientList[i];
		}
		clientListClone[clientList.length] = clientNew;
		clientList = clientListClone;
		System.out.println("Client has been added");
	}
	public static void editClient()
	{
		int option;
		String name;
		int age;
		if(clientList.length < 1)
		{
			System.out.println("No clients to edit");
		}
		else 
		{
			System.out.println("Which client to edit?");
			
			for (int i = 0; i < clientList.length; i++)
			{
				System.out.println("\nClient " + i);
				System.out.println(clientList[i].toString());
			}
			int clientToEdit = validInputLoop(0, clientList.length - 1);
			
			System.out.println("What to edit?\n(1) Name, (2) age, (0) Exit");
			option = validInputLoop(0, 2);
			switch(option)
			{
			case 1:
				System.out.println("What is the new name");
				name = input.next();
				clientList[clientToEdit].setName(name);
				System.out.println("Client has been edited");
				break;
			case 2:
				System.out.println("What is the new age (Between 18 and 130)");
				age = validInputLoop(18, 130);
				clientList[clientToEdit].setAge(age);
				System.out.println("Client has been edited");
				break;
			case 0:
				break;
			}
		}
			
	}
	public static void deleteClient()
	{
		if(clientList.length < 1)
		{
			System.out.println("No clients to delete");
		}
		else
		{
			System.out.println("What client do you want to delete?");
			for (int i = 0; i < clientList.length; i++)
			{
				System.out.println("\nClient " + i);
				System.out.println(clientList[i].toString());
			}
			int clientToDelete = validInputLoop(0, clientList.length - 1);
			
			if(clientList[clientToDelete].getLeasedVehicle().length > 0)
			{
				System.out.println("Cannot delete a client that has a lease!");
			}
			else
			{
				Client[] clientListClone = new Client[clientList.length - 1];
				
				for (int i = 0, k = 0; i < clientList.length; i++)
				{
					if (i != clientToDelete)
					{
						clientListClone[k] = clientList[i];
						k++;
					}
				}
				clientList = clientListClone;
				System.out.println("Client has been remove");
			}
		}
	}
	//All client Options
	public static void leasingManagementOptions()
	{
		boolean runProgram = true;
		//switch statment for all cases
		while(runProgram)
		{
			leasingOperationsMenu();
			option = validInputLoop(0, 4);
				
			switch(option)
			{
			case 1:
			leaseVehicle();
				break;
			case 2:
			returnVehicle();
				break;
			case 3:
			showAllByAClient();
				break;
			case 4:
			showAllLeased();
				break;
			case 0:
			runProgram = false;
				break;
			default:
				invalidInputCheck(0, option, 4);
			}
		}
	}
	public static void leaseVehicle()
	{
		if(clientList.length < 1) System.out.println("No clients to lease to");
		else if(rentalVehicles.length < 1) System.out.println("No vehicles to lease");
		else
		{
			System.out.println("Which client do you want to lease to?");
			for (int i = 0; i < clientList.length; i++)
			{
				System.out.println("\nClient " + i);
				System.out.println(clientList[i].toString());
			}
			int clientToLeaseTo = validInputLoop(0, clientList.length - 1);
			
			System.out.println("Which vehicle do you want to lease");
			for (int i = 0; i < rentalVehicles.length; i++)
			{
				System.out.println("Vehicle number " + i + "\n");
				System.out.println(rentalVehicles[i].toString());
			}
			int vehicleToLease = validInputLoop(0, rentalVehicles.length - 1);
			
			if(!rentalVehicles[vehicleToLease].getIsLeased())
			{
				clientList[clientToLeaseTo].addLeasedCar(rentalVehicles[vehicleToLease]);
				rentalVehicles[vehicleToLease].setIsLeased(true);
				System.out.println("Vehicle has been added");
			}
			else
			{
				System.out.println("Vehicle is already leased try again!");
			}
		}
	}
	public static void returnVehicle()
	{
		if(clientList.length < 1) System.out.println("No clients to return a vehicle");
		else if(rentalVehicles.length < 1) System.out.println("No vehicles to return");
		else
		{
			System.out.println("Which client do you want to return a vehicle from?");
			for (int i = 0; i < clientList.length; i++)
			{
				System.out.println("\nClient " + i);
				System.out.println(clientList[i].toString());
			}
			int clientToRemoveFrom = validInputLoop(0, clientList.length);
			
			Vehicles[] clientVehicles = clientList[clientToRemoveFrom].getLeasedVehicle();
			if(clientList[clientToRemoveFrom].getLeasedVehicle().length < 1)
			{
				System.out.println("No vehicle to return!");
			}
			else
			{
				System.out.println("Which vehicle do you want to remove");
				for (int i = 0; i < clientVehicles.length; i++)
				{
					System.out.println("\nClient vehicle number " + i);
					System.out.println(clientVehicles[i].toString());
				}
				int vehicleToRemove = validInputLoop(0, clientVehicles.length - 1);
				
				for(int i = 0; i < rentalVehicles.length; i++)
				{
					if(clientVehicles[vehicleToRemove].equals(rentalVehicles[i]))
					{
						rentalVehicles[i].setIsLeased(false);
					}
				}
				clientList[clientToRemoveFrom].removeLeasedVehicle(vehicleToRemove);
				System.out.println("Vehicle has been remove");
			}
		}
	}
	public static void showAllByAClient()
	{
		if(clientList.length < 1) System.out.println("No clients to see");
		else
		{
			System.out.println("By name (0) or by client number (1)?");
			int option = validInputLoop(0, 1);
			if(option == 0)
			{
				System.out.println("What is the client's name?");
				String clinetByName = input.next();
				int found = 0;
				for(int i = 0; i < clientList.length; i++)
				{
					if(clientList[i].getName().toLowerCase().equals(clinetByName.toLowerCase()))
					{
						System.out.println("Client number " + i);
						System.out.println(clientList[i].toString());
						found++;
					}
				}
				if(found < 1) System.out.println("Nobody has that name!");
			}
			else
			{
				System.out.println("What is the client's number?\nFrom 0 to " + (clientList.length - 1));
				int clinetByNumber = validInputLoop(0, clientList.length - 1);
				System.out.println(clientList[clinetByNumber].toString());
			}
		}
	}
	public static void showAllLeased()
	{
		int countOfLeases = 0;
		for(int i = 0; i < rentalVehicles.length; i++)
		{
			if(rentalVehicles[i].getIsLeased())
			{
				System.out.println("Vehicle number " + i + "\n");
				System.out.println(rentalVehicles[i].toString());
				countOfLeases++;
			}
		}
		if(countOfLeases < 1)
		{
			System.out.println("No leased vehicles!");
		}
	}
	//All leasing Options
	public static void additionalOperationsOptions()
	{
		boolean runProgram = true;
		//switch statment for all cases
		while(runProgram)
		{
			additionalOperationsMenu();
			option = validInputLoop(0, 2);
				
			switch(option)
			{
			case 1:
			System.out.println(getLargestTruck(dieselTrucks).toString());
				break;
			case 2:
			for(int i = 0; i < copyVehicles(electricTrucks).length; i++)
			{
				System.out.println(copyVehicles(electricTrucks)[i].toString());
			}
				break;
			case 0:
			runProgram = false;
				break;
			default:
				invalidInputCheck(0, option, 2);
			}
		}
	}
	public static DieselTrucks getLargestTruck(DieselTrucks[] dieselTruckArray)
	{
		DieselTrucks largestCapacityTruck = new DieselTrucks();
		
		for(int i = 0; i < dieselTruckArray.length; i++)
		{
			if(largestCapacityTruck.getTankCapacity() < dieselTruckArray[i].getTankCapacity())
			{
				largestCapacityTruck = dieselTruckArray[i];
			}
		}
		return largestCapacityTruck;
	}
	public static ElectricTrucks[] copyVehicles(ElectricTrucks[] electricTrucksToCopy)
	{
		ElectricTrucks[] electricTrucksCopy = new ElectricTrucks[electricTrucksToCopy.length];
		
		for(int i = 0; i < electricTrucksToCopy.length; i++)
		{
			electricTrucksCopy[i] = electricTrucksToCopy[i].clone();
		}
		return electricTrucksCopy;
	}
	//All Extra Options
	public static boolean predefinedScenario()
	{
		System.out.println("Would you like to run the predefined scenario?\n(1) Yes || (0) No");
		option = validInputLoop(0, 1);
		if(option == 1)
		{
			//Create at least 3 objects of each type of vehicle and 3 clients.
			DieselTrucks truck1 = new DieselTrucks("Ford", "F-150", 2020, 2000, 80);
			DieselTrucks truck2 = new DieselTrucks("Chevrolet", "Silverado", 2021, 2500, 90);
			DieselTrucks truck3 = new DieselTrucks("Ram", "1500", 2022, 2200, 85);
			
			DieselTrucks[] dieselTrucksPreMade = {truck1, truck2, truck3};
			dieselTrucks = dieselTrucksPreMade;
			
			ElectricTrucks electricTruck1 = new ElectricTrucks("Tesla", "Semi", 2023, 2000, 500);
			ElectricTrucks electricTruck2 = new ElectricTrucks("Rivian", "R1T", 2022, 3000, 400);
			ElectricTrucks electricTruck3 = new ElectricTrucks("Ford", "F-150 Lightning", 2022, 2500, 300);
			
			ElectricTrucks[] electricTrucksPreMade = {electricTruck1, electricTruck2, electricTruck3};
			electricTrucks = electricTrucksPreMade;
			
			
			GasolineCars gasolineCar1 = new GasolineCars("Toyota", "Corolla", 2021, 5);
			GasolineCars gasolineCar2 = new GasolineCars("Honda", "Civic", 2020, 5);
			GasolineCars gasolineCar3 = new GasolineCars("Ford", "Mustang", 2022, 4);
			
			GasolineCars[] gasolineCarsPreMade = {gasolineCar1, gasolineCar2, gasolineCar3};
			gasolineCars = gasolineCarsPreMade;
			
			ElectricCars electricCar1 = new ElectricCars("Tesla", "Model S", 2023, 5, 370);
			ElectricCars electricCar2 = new ElectricCars("Tesla", "Model S", 2023, 5, 370);
			ElectricCars electricCar3 = new ElectricCars("BMW", "i4", 2022, 5, 300);
			
			ElectricCars[] electricCarsPreMade = {electricCar1, electricCar2, electricCar3};
			electricCars = electricCarsPreMade;			
			
			Client client1 = new Client("John", 30);
			Client client2 = new Client("Jane", 25);
			Client client3 = new Client("Michael", 40);
			
			Client[] clientListPreMade = {client1, client2, client3};
			clientList = clientListPreMade;
			//Create arrays for each type of vehicle
			
			//Display the information of these objects using the toString() method.
			for(int i = 0; i < 3; i++)
			{
				System.out.println(dieselTrucks[i].toString());
				System.out.println(electricTrucks[i].toString());
				System.out.println(gasolineCars[i].toString());
				System.out.println(electricCars[i].toString());
				System.out.println(clientList[i].toString());;
			}
			
			System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
			
			System.out.println(electricCar1.equals(gasolineCar1));
			System.out.println(truck1.equals(truck2));
			System.out.println(electricCar1.equals(electricCar2));
			
			System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
			
			//Create array for all vehicles
			Vehicles[] rentalVehiclesPreMade = {truck1, truck2, truck3, electricTruck1, electricTruck2, electricTruck3,
					gasolineCar1, gasolineCar2, gasolineCar3, electricCar1, electricCar2, electricCar3};
			rentalVehicles = rentalVehiclesPreMade;
			
			System.out.println(getLargestTruck(dieselTrucks).toString());
			
			System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
			
			for(int i = 0; i < copyVehicles(electricTrucks).length; i++)
			{
				System.out.println(copyVehicles(electricTrucks)[i].toString());
			}
			
			return true;
		}
		else return false;
	}
	public static void makeSmallArrays()
	{
		int countDieselTrucks = 0;
		int countElectricTrucks = 0;
		int countElectricCars = 0;
		int countGasolineCars = 0;
		
		for(int i = 0; i < rentalVehicles.length; i++)
		{
			if(rentalVehicles[i] instanceof DieselTrucks)
			{
				countDieselTrucks++;
			}
			if(rentalVehicles[i] instanceof ElectricTrucks)
			{
				countElectricTrucks++;
			}
			if(rentalVehicles[i] instanceof ElectricCars)
			{
				countElectricCars++;
			}
			if(rentalVehicles[i] instanceof GasolineCars)
			{
				countGasolineCars++;
			}
		}
		
		DieselTrucks[] dieselTrucksForNow = new DieselTrucks[countDieselTrucks];
		ElectricTrucks[] electricTrucksForNow = new ElectricTrucks[countElectricTrucks];
		ElectricCars[] electricCarsForNow = new ElectricCars[countElectricCars];
		GasolineCars[] gasolineCarsForNow = new GasolineCars[countGasolineCars];
		
		
		for(int i = 0, k = 0, m = 0, j = 0, l = 0; i < rentalVehicles.length; i++)
		{
			if(rentalVehicles[i] instanceof DieselTrucks)
			{
				dieselTrucksForNow[k] = (DieselTrucks) rentalVehicles[i];
				k++;
			}
			else if(rentalVehicles[i] instanceof ElectricTrucks)
			{
				electricTrucksForNow[m] = (ElectricTrucks) rentalVehicles[i];
				m++;
			}
			else if(rentalVehicles[i] instanceof ElectricCars)
			{
				electricCarsForNow[j] = (ElectricCars) rentalVehicles[i];
				j++;
			}
			else if(rentalVehicles[i] instanceof GasolineCars)
			{
				gasolineCarsForNow[l] = (GasolineCars) rentalVehicles[i];
				l++;
			}
		}
		dieselTrucks = dieselTrucksForNow;
		electricTrucks = electricTrucksForNow;
		electricCars = electricCarsForNow;		
		gasolineCars = gasolineCarsForNow;
	}
	
	
}
