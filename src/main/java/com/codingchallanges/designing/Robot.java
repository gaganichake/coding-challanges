package com.codingchallanges.designing;

import java.util.ArrayList;
import java.util.List;

/*
 * Credit Karma - Coding challenge 3
 * Nov 17, 2021
 * 
 * Write a robot simulator, where robots can be placed on an infinite 2D grid, with cardinal directions of North, South, East and West.
 * 
 * Robots will always be facing in one of the cardinal directions and also have coordinates on the grid (e.g. {x: 3, y: 8})
 * 
 * Movement in any direction on the grid is a change of 1 unit
 * 
 * Robots can perform a variety of actions which update their coordinates and orientation on the board as described below
 * 
 * // Robot properties
 * bearing - direction the robot is facing
 * coordinates - x,y position on the grid
 * 
 * // Robot methods
 * orient('north') - sets the robot's bearing by the passed cardinal direction
 * 
 * turnRight() - updates the robot's bearing
 * 
 * turnLeft()  - updates the robot's bearing
 * 
 * at(1,2) - sets the robots coordinates by the arguments (i.e. x = 1, y = 2)
 * 
 * advance(1) - updates the robot's coordinates (based on its current bearing) by the argument (i.e. advance by 1)
 * 
 * instructions('ALA') - converts an encoded instructions string to a list of methods
 * 
 * place({x: 2, y: -7, bearing: 'east'}) - sets both the robot's coordinates and bearing
 * 
 * evaluate('ALA') - will execute the passed instructions on the robot
 * 
 * // Expectations
 * 
 * expect(robot.instructions('RAAL')).toEqual(['turnRight', 'advance', 'advance', 'turnLeft']);
 * 
 * robot.place({x: 2, y: -7, direction: 'east'});
 * 
 * robot.evaluate('RRAAAAALA');
 * 
 * expect(robot.coordinates).toEqual([-3, -8]);
 * 
 * expect(robot.x).toEqual(-3);
 * 
 * expect(robot.y).toEqual(-8);
 * 
 * expect(robot.bearing).toEqual('south');
 */
public class Robot {

	public enum Directions {

		NORTH, SOUTH, WEST, EAST
	}

	public enum Operations {

		ADVANCE, TURNRIGHT, TURNLEFT
	}

	String bearing;
	int x, y;

	public void orient(String direction) {
		this.bearing = direction;
	}

	public void turnRight() {

		if (Directions.NORTH.toString().equals(bearing)) {

			bearing = Directions.EAST.toString();
			return;
		}

		if (Directions.EAST.toString().equals(bearing)) {

			bearing = Directions.SOUTH.toString();
			return;
		}

		if (Directions.SOUTH.toString().equals(bearing)) {

			bearing = Directions.WEST.toString();
			return;
		}

		if (Directions.WEST.toString().equals(bearing)) {

			bearing = Directions.NORTH.toString();
		}
	}

	public void turnLeft() {

		if (Directions.NORTH.toString().equals(bearing)) {

			bearing = Directions.WEST.toString();
			return;
		}

		if (Directions.EAST.toString().equals(bearing)) {

			bearing = Directions.NORTH.toString();
			return;
		}

		if (Directions.SOUTH.toString().equals(bearing)) {

			bearing = Directions.EAST.toString();
			return;
		}

		if (Directions.WEST.toString().equals(bearing)) {

			bearing = Directions.SOUTH.toString();
		}
	}

	public void at(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void advance(int n) {

		if (Directions.NORTH.toString().equals(bearing)) {
			this.y += n;
			return;
		}

		if (Directions.EAST.toString().equals(bearing)) {
			this.x += n;
			return;
		}

		if (Directions.SOUTH.toString().equals(bearing)) {
			this.y += n;
			return;
		}

		if (Directions.WEST.toString().equals(bearing)) {
			this.y += n;
		}
	}

	public List<String> instructions(String str) {

		List<String> list = new ArrayList<>();
		char[] cArr = str.toCharArray();

		for (char c : cArr) {

			if (c == 'L') {
				list.add(Operations.TURNLEFT.toString());
				continue;
			}

			if (c == 'R') {
				list.add(Operations.TURNRIGHT.toString());
				continue;
			}

			if (c == 'A') {
				list.add(Operations.ADVANCE.toString());
			}

		}

		return list;
	}

	public void place(int x, int y, String bearing) {

		this.x = x;
		this.y = y;
		this.bearing = bearing;
	}

	public void evaluate(String str) {

		char[] cArr = str.toCharArray();

		for (char c : cArr) {

			if (c == 'L') {
				turnLeft();
				continue;
			}

			if (c == 'R') {
				turnRight();
				continue;
			}

			if (c == 'A') {
				advance(1);
			}

		}
	}

	public static void main(String[] args) {

		Robot robot = new Robot();
		robot.place(3, 9, "NORTH");
		robot.turnLeft();
		robot.advance(1);
		List<String> instructions = robot.instructions("LRAAL");
		System.out.println(instructions);

		robot.evaluate("LRAAL");

		System.out.println(robot.bearing);
		System.out.println(robot.x);

	}

}
