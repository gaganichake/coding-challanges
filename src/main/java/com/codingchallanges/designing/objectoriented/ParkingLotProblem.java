package com.codingchallanges.designing.objectoriented;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ParkingLotProblem {

	private final SortedSet<Integer> availableLots = new TreeSet<>();
//	private final List<Integer> busySlots = new ArrayList<>();
	
	public ParkingLotProblem() {
		for(int i = 0; i < 5; i++) {
			availableLots.add(i);
		}
	}
	
	public int getParkinglot() {
		
		int lotNumber = availableLots.first();
//		busySlots.add(lotNumber);
		availableLots.remove(lotNumber);
		
		return lotNumber;
	}
	
	public void exitParkingLot(Integer lotNumber) {
		
//		busySlots.remove(lotNumber);
		availableLots.add(lotNumber);
	}
	
	public static void main(String[] args) {
		
		ParkingLotProblem parkingLotProblem = new ParkingLotProblem(); 
		
		System.out.print("Available Lots: ");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.print("Get parking ticket: ");
		System.out.println(parkingLotProblem.getParkinglot());
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.print("Get parking ticket: ");
		System.out.println(parkingLotProblem.getParkinglot());
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.println("Exit parking lot: 1");
		parkingLotProblem.exitParkingLot(1);
		System.out.println("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.print("Get parking ticket: ");
		System.out.println(parkingLotProblem.getParkinglot());
		System.out.println("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.print("Get parking ticket: ");
		System.out.println(parkingLotProblem.getParkinglot());
		System.out.println("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.print("Get parking ticket: ");
		System.out.println(parkingLotProblem.getParkinglot());
		System.out.println("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.print("Get parking ticket: ");
		System.out.println(parkingLotProblem.getParkinglot());
		System.out.println("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.println("Exit parking lot: 4");
		parkingLotProblem.exitParkingLot(4);
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.println("Exit parking lot: 2");
		parkingLotProblem.exitParkingLot(2);
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.println("Exit parking lot: 0");
		parkingLotProblem.exitParkingLot(0);
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.println("Exit parking lot: 1");
		parkingLotProblem.exitParkingLot(1);
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
		System.out.println("Exit parking lot: 3");
		parkingLotProblem.exitParkingLot(3);
		System.out.print("Available Lots:");
		System.out.println(parkingLotProblem.availableLots);
		System.out.println("------------------------------/n");
		
	}

}
