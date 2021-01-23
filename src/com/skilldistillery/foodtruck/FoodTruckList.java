package com.skilldistillery.foodtruck;

public class FoodTruckList {
	private FoodTruck[] foodTrucks;
	private final static int MAX_TRUCKS = 5;

	public FoodTruckList() {
		foodTrucks = new FoodTruck[MAX_TRUCKS];
	}

	public void addFoodTruck(FoodTruck ft) {
		for (int i = 0; i < MAX_TRUCKS; i++) {
			if (foodTrucks[i] == null) {
				foodTrucks[i] = ft;
				break;
			}
		}
	}

	public FoodTruck[] getFoodTrucks() {
		FoodTruck[] copyFoodTrucks = new FoodTruck[MAX_TRUCKS];
		for (int i = 0; i < foodTrucks.length; i++) {
			copyFoodTrucks[i] = foodTrucks[i];
		}
		return copyFoodTrucks;
	}

}
