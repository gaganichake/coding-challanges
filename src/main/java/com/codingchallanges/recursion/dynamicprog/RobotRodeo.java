package com.codingchallanges.recursion.dynamicprog;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class RobotRodeo {

	public static List<String> isCircularMove(List<String> commands){
	
		List<String> result = new ArrayList<>();
		
		
		for(String command :  commands) {
			
			result.add(isCircularMove(command));
		}
		
		
		return result;
	}

	private static String isCircularMove(String command) {
		
		if(command == null || command.isEmpty()) {
			return "YES";
		}
		
		if(command.length() == 1 && command.charAt(0) ==  'G') {
			return "NO";
		}
		
		if(command.length() == 1 && (command.charAt(0) ==  'L' || command.charAt(0) ==  'R')) {
			return "YES";
		}
		
		if(command.length() > 1 && (command.charAt(command.length()-1) ==  'L' || command.charAt(command.length()-1) ==  'R')) {
			return "YES";
		}
		
		int left = 0, right = 0;
		
		for(int i = 0; i < command.length(); i++) {
		

//			if(i+2 < command.length() && command.substring(i, i + 2) == "LG") {
//				left++;
//				i++;
//			}
//			F
//			if(i+2 < command.length() && command.substring(i, i + 2) == "RG") {
//				right++;
//				i++;
//			}
			
//			if(command.charAt(0) ==  'G') {
//				left+=-1;
//				right+=-1;
//			}
			
			if(command.charAt(0) ==  'L') {
				left+=1;
			}
			
			if(command.charAt(0) ==  'R') {
				right+=1;
			}
			
		}
		
		left =  left%4;
		right = right%4;

		if(left == 0 && right == 0) {
			return "YES";
		}
		
		return "NO";
	}
	
	public static void main(String[] arg) {
		
		List<String> commands = new ArrayList<>();
		
		commands.add("G");//NO
		commands.add("L");//YES
		commands.add("R");//YES
		commands.add("GL");//YES
		commands.add("GR");//YES
		commands.add("LG");//NO
		commands.add("RG");//NO
		commands.add("LGLGLGLG");//YES
		commands.add("RGRGRGRG");//YES
		commands.add("GLGLGLGLG");//YES
		commands.add("GRGRGRGRG");//YES
		commands.add("LGLGLGLGL");//YES
		commands.add("RGRGRGRGR");//YES
		commands.add("GLGLGLGLGR");//NO
		commands.add("GRGRGRGRGL");//NO
		commands.add("GLGLGLGLGRG");//YES
		commands.add("GRGRGRGRGLG");//YES
		
		System.out.println(isCircularMove(commands));
	}
}
