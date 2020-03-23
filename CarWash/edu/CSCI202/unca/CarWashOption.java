package edu.CSCI202.unca;

import java.util.Random;

/**
 * @author	Johnny Remein
 * @version 3/31/19
 * Assignment: Project 3 - A Car Wash
 * Description: The CarWashOption enum is used to hold the different types of car wash options, as well as generate 
 * 				random "choices" for any instantiated cars. The class also houses two getters which are used in the 
 * 				CarWash class.
 *
 */

public enum CarWashOption {

	GREAT(5, 5.00),
	SUPER(7, 7.50),
	FANTASTIC(9, 10.00),
	SPLENDID(11, 12.50),
	MAGNIFICENT(13, 15.00);
	
	private static CarWashOption[] vals = values();
	private static Random gen = new Random();
	
	private final int time;
	private final double price;
	
	CarWashOption(int time, double price) {
		this.time = time;
		this.price = price;
	}
	
	public int getTime() { return time; }
	public double getPrice() { return price; }
	
	public static CarWashOption getRandomOption() {
		return vals[(gen.nextInt(vals.length))];
	}
		
}
