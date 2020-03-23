package edu.CSCI202.unca;

/**
 * @author	Johnny Remein
 * @version 3/31/19
 * Assignment: Project 3 - A Car Wash
 * Description: The Car class is used to represent a car object both in line for a car wash and in a car wash bay. 
 * 				Car objects have two instance variables, a CarWashOption variable which holds that individual car's
 * 				"chosen" wash cycle and a timeRemaining integer variable responsible for keeping track of the car's
 * 				progress through it's wash cycle. The Car class also contains a method that decrements the timeRemaining
 * 				variable, ensuring proper time in the wash cycle.
 *
 */

public class Car {
	
	private final CarWashOption wash;
	private int timeRemaining;
	
	public Car(CarWashOption wash) {
		this.wash = wash;
		this.timeRemaining = wash.getTime();
	}
	
	public void timeDecrement() {
		timeRemaining--;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}
	
	public CarWashOption getCarWashOption() {
		return wash;
	}
	
}
