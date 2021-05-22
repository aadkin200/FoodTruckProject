package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FoodTruckApp fta = new FoodTruckApp();
		FoodTruck[] foodTruckArr = new FoodTruck[50];
		fta.getFoodTrucks(input, fta, foodTruckArr);
	}
	
	public void getFoodTrucks(Scanner input, FoodTruckApp fta, FoodTruck[] foodTruckArr) {
		int i = 0;
		boolean isRunning = true;
		while (isRunning) {
			String name = getFoodTruckName(input, fta, foodTruckArr);
			if(name.equalsIgnoreCase("quit")) {
				isRunning = false;
				fta.menu(input, fta, foodTruckArr);
				break;
			}
			String foodType = fta.getFoodType(input, fta, foodTruckArr);
			double rating = fta.getRating(input, fta, foodTruckArr);
			foodTruckArr[i] = new FoodTruck(name, foodType, rating);
			i++;
		}
		fta.menu(input, fta, foodTruckArr);
	}
	
	public String getFoodTruckName(Scanner input, FoodTruckApp fta, FoodTruck[] foodTruckArr) {
		System.out.println("Enter name of food truck: ");
		String name = input.nextLine();
		return name;
	}
	
	public String getFoodType(Scanner input, FoodTruckApp fta, FoodTruck[] foodTruckArr) {
		System.out.println("What kind of food do they sell?");
		String foodType = input.nextLine();
		return foodType;
	}
	
	public double getRating(Scanner input, FoodTruckApp fta, FoodTruck[] foodTruckArr) {
		System.out.println("What rating do you give them?");
		double rating = input.nextDouble();
		input.nextLine();
		return rating;
	}
	
	public void menu(Scanner input, FoodTruckApp fta, FoodTruck[] foodTruckArr) {
		boolean menu = true;
		while (menu) {
			System.out.println("++++++++Choose an option++++++++");
			System.out.println("1. List all food trucks");
			System.out.println("2. See the average rating");
			System.out.println("3. Display the highest-rated truck");
			System.out.println("4. QUIT");
			System.out.println("++++++++++++++++++++++++++++++++");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				fta.listAllFoodTrucks(foodTruckArr);
				break;
			case 2:
				fta.getAverageRating(foodTruckArr);
				break;
			case 3:
				fta.getHighestRatedTruck(foodTruckArr);
				break;
			case 4:
				menu = false;
				System.exit(0);
				break;
			}
		}
	}

	public void listAllFoodTrucks(FoodTruck[] foodTruckArr) {
		for (int i = 0; i < foodTruckArr.length; i++) {
			if (foodTruckArr[i] == null) {
				continue;
			}
			System.out.println("------------------------");
			System.out.println(foodTruckArr[i].toString());
			System.out.println("------------------------");
		}
	}

	public void getAverageRating(FoodTruck[] foodTruckArr) {
		double sum = 0;
		double average = 0;
		int j = 0;
		for (int i = 0; i < foodTruckArr.length; i++) {
			if (foodTruckArr[i] == null) {
				continue;
			}
			sum += foodTruckArr[i].getRating();
			j++;
		}
		average = sum / j;
		System.out.println("------------------------");
		System.out.println("Average rating is: " + average);
		System.out.println("------------------------");
	}
	
	public void getHighestRatedTruck(FoodTruck[] foodTruckArr) {
		double highestRated = 0;
		int j = 0;
		for(int i = 0; i < foodTruckArr.length; i++) {
			if (foodTruckArr[i] == null) {
				continue;
			} else if (foodTruckArr[i].getRating() > highestRated) {
				highestRated = foodTruckArr[i].getRating();
				j = i;
			}
		}
		System.out.println("------------------------");
		System.out.println(foodTruckArr[j].toString());
		System.out.println("------------------------");
	}
	
}
