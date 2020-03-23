package edu.CSCI202.unca;

/**
 * @author	Johnny Remein
 * @version 3/31/19
 * Assignment: Project 3 - A Car Wash
 * Description: The CarWashManager class holds the main method and is responsible for creating, running and printing the
 * 				results of several different CarWash objects.
 *
 */

public class CarWashManager {

	public static void main(String[] args) {


		CarWash zeros = new CarWash(10);
		zeros.run(0,  0.00);
		zeros.printData();
		
		CarWash otherZeros = new CarWash(10);
		otherZeros.run(10,  0.00);
		otherZeros.printData();
		
		CarWash smallBayCnt = new CarWash(3);
		smallBayCnt.run(100,  0.5);
		smallBayCnt.printData();
		
		CarWash largeBayCnt = new CarWash(20);
		largeBayCnt.run(100,  0.5);
		largeBayCnt.printData();
		
		CarWash highProb = new CarWash(10);
		highProb.run(100,  0.9);
		highProb.printData();
		
		CarWash lowProb = new CarWash(10);
		lowProb.run(100,  0.1);
		lowProb.printData();
		
		CarWash alwaysNewCar = new CarWash(1);
		alwaysNewCar.run(10,  2.0);
		alwaysNewCar.printData();
		
		CarWash six = new CarWash(2);
		six.run(100,  0.2);
		six.printData();

	}

}
