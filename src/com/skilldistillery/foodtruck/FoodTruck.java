package com.skilldistillery.foodtruck;

public class FoodTruck {
	// Make FoodTruck class with fields for a unique numeric id, a name
	// ("TacoRific", "Mediterranean Medic", etc.), food type ("Tacos", "Falafel",
	// etc.), and a numeric rating.

	private String name;
	private String foodType;
	private double rating;
	private int truckID;
	private static int numID = 1;

	// The truck id is assigned automatically in the FoodTruck constructor from a
	// static field that is incremented as each truck is created.

	// Constructor
	public FoodTruck() {
		this.truckID = numID;
		numID++;
	}

	public FoodTruck(String name, String foodType, double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.truckID = numID;
		numID++;

	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	// toString Method
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodTruck - id: ").append(truckID).append(", name: ").append(name).append(", serving: ")
				.append(foodType).append(", rating: ").append(rating).append(".");
		return builder.toString();
	}

	// display Method
	public void displayFoodTruck() {
		String foodTruckData = this.toString();
		System.out.println(foodTruckData);
	}

}
