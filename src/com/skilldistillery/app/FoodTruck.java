package com.skilldistillery.app;

public class FoodTruck {
	private static int ID;
	private int uniqueID;
	private String name;
	private String foodType;
	private double rating;

	public FoodTruck(String name, String foodType, double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.uniqueID = ID +1;
		ID++;
	}
	
	public static int getID() {
		return ID;
	}

	public static void setID(int iD) {
		ID = iD;
	}

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
	
	public String toString() {
		String output = "Name: " + this.name + "\nFood Type: " + foodType + "\nRating: "
						+ rating + "\nID: " + uniqueID;
		return output;
	}
	
	public void listFoodTrucks() {
		
	}

}
