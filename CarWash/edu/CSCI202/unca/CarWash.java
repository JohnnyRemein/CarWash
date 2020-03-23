package edu.CSCI202.unca;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

/**
 * @author	Johnny Remein
 * @version 3/31/19
 * Assignment: Project 3 - A Car Wash
 * Description: The CarWash class holds almost all of the logic for the program. This class holds several instance variables whose
 * 				purpose are apparent by their names. The Car Wash queue, wash bay's, and new car arrival are all 
 * 				created and managed within this class. 
 *
 */

public class CarWash {
	
	private final int numBays;
	private int timeStepsRun = 0;
	private double arrivalProbability = 0.0;
	private int carsInLine = 0;
	private int maxLineLength = 0;
	private int carsWashed = 0;
	private double revenueTally = 0.0;
	private static Random gen = new Random();
	
	Queue<Car> carWashLine = new ArrayDeque<Car>();
	ArrayList<Car> carWashBays = new ArrayList<Car>();
	
	public CarWash(int numBays) {
		this.numBays = numBays;
		for(int i = 0; i < numBays; i++) {
			carWashBays.add(null);
		}
	}
	
	/**
	 * @param simulationDuration - an int representing the number of time steps for the simulation
	 * @param arrivalProbability - a double representing the probability a new car will arrive every time step
	 * Description: The run() method cycles through the appropriate number of time steps, calling helper methods 
	 * 				to perform wash bay, car line, and new car arrival management as well as the counting of certain data. 
	 */
	public void run(int simulationDuration, double arrivalProbability){
		this.arrivalProbability = arrivalProbability;
		for(int time = 0; time < simulationDuration; time++) {
			
			checkNewCar();
			manageBays();
			manageLine();
			
			timeStepsRun++;
		}
		
	}
	
	/**
	 * Description: The printData() method displays all of the data accrued from the car wash to the console.
	 */
	public void printData() {
		System.out.println("\nData Printout: \n");
		System.out.println("Number of time steps run: " + timeStepsRun);
		System.out.println("Number of car wash bays: " + carWashBays.size());
		System.out.println("Car arrival probability: " + arrivalProbability);
		System.out.println("Max line length: " + maxLineLength);
		System.out.println("Number of cars left: " + carsInLine);
		System.out.println("Number of cars washed: " + carsWashed);
		System.out.println("Total revenue: $" + revenueTally);
	}
	
	/**
	 * Description: The checkNewCar() method add's a new car to the queue every time step based on the probability of arrival.
	 */
	private void checkNewCar() {
		if(gen.nextDouble() <= arrivalProbability) {
			carWashLine.add(new Car(CarWashOption.getRandomOption()));
			carsInLine++;
		}
		
		if(carsInLine > maxLineLength) maxLineLength = carsInLine;
	}
	
	/**
	 * Description: The manageBays() method keeps track of decrementing the time each car needs to be in a wash bay, incrementing
	 * 				the carsWashed variable for once each car's timeRemaining variable has reached zero, and nulls out bays who
	 * 				no longer have cars in them.
	 */
	private void manageBays() {
		for(int i = 0; i < numBays; i++) {
			if(carWashBays.get(i) != null) {
				carWashBays.get(i).timeDecrement();
				
				if(carWashBays.get(i).getTimeRemaining() == 0) {
					carsWashed++;
					carWashBays.set(i,  null);
				}
			}
		}
	}
	
	/**
	 * Description: The manageLine() method looks for empty wash bays and adds cars to them if there are any cars in the line. 
	 * 				This method also keeps track of accrued revenue and decrements the number of cars in the line when a car is
	 *				allowed into an empty wash bay spot. One can also tell that this car wash model accepts payment from customers
	 *				once they have left the queue(line) and have found an empty wash bay to use.
	 */
	private void manageLine() {
		for(int emptyBayIndex = carWashBays.indexOf(null); emptyBayIndex >= 0; emptyBayIndex = carWashBays.indexOf(null)) {
			if(!carWashLine.isEmpty()) {
				Car nextToWash = carWashLine.remove();
				revenueTally += nextToWash.getCarWashOption().getPrice();
				carWashBays.set(emptyBayIndex, nextToWash);
				carsInLine--;
			}
			else
				break;
		}
	}
	

}
