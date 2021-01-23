package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	// Goal: Users will input and rate a list of food trucks, then view the average
	// rating and the highest-rated truck.

	public static void main(String[] args) {
		// Create a separate class with a main method that starts the program. The main
		// method of this class is the only static method in the entire project.
		FoodTruckApp fta = new FoodTruckApp();
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Food Truck App!");

		// Create an array to store up to five FoodTruck objects.
		FoodTruckList foodTruckList = new FoodTruckList();

		// Create and call user food truck input
		fta.populateFoodTruck(sc, fta, foodTruckList);
		FoodTruck[] allTrucks = foodTruckList.getFoodTrucks();
		// Create a while loop so the Menu keeps printing and user can interact
		boolean flag = true;
		while (flag) {
			fta.printMenu();
			flag = fta.userMenuSelection(sc, fta, allTrucks);
		}

		sc.close();
	}

	public void populateFoodTruck(Scanner sc, FoodTruckApp fta, FoodTruckList foodTruckList) {
		// For each set of inputs, a FoodTruck object is created and fields assigned
		for (int i = 0; i < foodTruckList.getFoodTrucks().length; i++) {
			FoodTruck ft = new FoodTruck();
			ft = fta.getUserInput(sc, i, ft);

			// If user inputs quit for the food truck name program continues
			boolean flag = checkQuit(ft);
			if (flag) {
				break;
			}

			// Add Food truck to the array.
			foodTruckList.addFoodTruck(ft);
			;
		}

		// Handle a null input so user must enter at least 1 food truck

	}

	public FoodTruck getUserInput(Scanner sc, int num, FoodTruck ft) {
		// The user is prompted to input the name, food type, and rating for up to five
		// food trucks.

		String name = getUserInput(sc, num, "name");
		ft.setName(name);

		// If user inputs quit for the food truck name, input ends
		boolean flag = checkQuit(ft);
		if (flag) {
			return ft;
		}

		String foodType = getUserInput(sc, num, "food type");
		ft.setFoodType(foodType);

		int rating = Integer.parseInt(getUserInput(sc, num, "rating"));
		ft.setRating(rating);

		return ft;
	}

	public String getUserInput(Scanner sc, int num, String field) {
		// The user is prompted to input the name, food type, and rating for up to five
		// food trucks.
		System.out.print("Please enter the " + field + " for Food Truck " + (num + 1) + ": ");
		field = sc.nextLine();

		return field;
	}

	public boolean checkQuit(FoodTruck ft) {
		boolean flag = false;
		if (ft.getName().toUpperCase().equals("QUIT")) {
			flag = true;
			return flag;
		}
		return flag;
	}

	public void printMenu() {
		// After input is complete, the user sees a menu from which they can choose to:
		// List all existing food trucks, see the average rating of food trucks, display
		// the highest-rated food truck, quit the program.
		System.out.println("________________________________________");
		System.out.println("|                  MENU                 |");
		System.out.println("|_______________________________________|");
		System.out.println("|                                       |");
		System.out.println("| 1) List all food trucks               |");
		System.out.println("| 2) List average rating of food trucks |");
		System.out.println("| 3) List highest rated food truck      |");
		System.out.println("| 4) Quit                               |");
		System.out.println("|_______________________________________|");

	}

	public boolean userMenuSelection(Scanner sc, FoodTruckApp fta, FoodTruck[] allT) {
		// Select relevant method based on user selection from menu
		boolean flag = true;

		System.out.println("What you like to do? (type 1-4)");
		int selection = sc.nextInt();
		sc.nextLine();

		switch (selection) {
		case 1:
			fta.listAllFoodTrucks(allT);
			break;

		case 2:
			fta.listAverageRating(allT);
			break;

		case 3:
			fta.listHighestRating(allT);
			break;

		case 4:
			flag = false;
			System.out.println("Thanks for using our app! Goodbye!");
			break;
		}

		return flag;
	}

	public void listAllFoodTrucks(FoodTruck[] allT) {
		// List all Food Trucks
		for (FoodTruck ft : allT) {
			if (ft != null) {
				ft.displayFoodTruck();
			}
		}

	}

	public void listAverageRating(FoodTruck[] allT) {
		// Get average of the food trucks based on the number of Food Trucks entered
		double sum = 0, average = 0;
		int i = 0;
		for (FoodTruck ft : allT) {
			if (ft != null) {
				sum += ft.getRating();
				i++;
			}
		}
		average = sum / i;
		System.out.println("The average Food Truck rating for " + i + " trucks is " + average);
	}

	public void listHighestRating(FoodTruck[] allT) {
		// List highest rated food truck and all fields
		System.out.println("The highest rated food truck(s) is: ");
		int max = 0;
		for (FoodTruck ft : allT) {
			if (ft != null) {
				if (ft.getRating() > max) {
					max = ft.getRating();
				}
			}
		}
		for (FoodTruck ft : allT) {
			if (ft.getRating() == max) {
				ft.displayFoodTruck();
			}
		}

	}

}
