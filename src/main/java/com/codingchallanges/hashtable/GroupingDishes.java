package com.codingchallanges.hashtable;

import java.util.*;

import static java.lang.System.arraycopy;

/*
 * groupingDishes
 *
 * https://app.codesignal.com/interview-practice/task/xrFgR63cw7Nch4vXo/description
 *
 * You are given a list dishes, where each element consists of a list of strings beginning
 * with the name of the dish, followed by all the ingredients used in preparing it. You want
 * to group the dishes by ingredients, so that for each ingredient you'll be able to find
 * all the dishes that contain it (if there are at least 2 such dishes).
 *
 * Return an array where each element is a list beginning with the ingredient name,
 * followed by the names of all the dishes that contain this ingredient. The dishes inside
 * each list should be sorted lexicographically, and the result array should be sorted
 * lexicographically by the names of the ingredients
 *
 * Example:
 *
 * Input:
 * For
 * dishes:
 * [["First","a","b","c","d","e","f","g","h","i"],
 * ["Second","i","h","g","f","e","x","c","b","a"]]
 *
 * Expected Output:
 *
 * [["a","First","Second"],
 * ["b","First","Second"],
 * ["c","First","Second"],
 * ["e","First","Second"],
 * ["f","First","Second"],
 * ["g","First","Second"],
 * ["h","First","Second"],
 * ["i","First","Second"]]
 *
 *
 * For
 * dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
 *
 * the output should be
 * solution(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]


 *
 * For
 * dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
 *
 *
 * the output should be
 * solution(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
 *
 * */
public class GroupingDishes {

	String[][] solution(String[][] dishes) {

		SortedMap<String, List<String>> map = new TreeMap<>();

		for(String[] menu : dishes){

			String ingredient;
			String dish;
			List<String> dishList;

			for(int i = 1; i < menu.length; i++){

				dish = menu[0];
				ingredient = menu[i];

				if(!map.containsKey(ingredient)){
					map.put(ingredient, new ArrayList<>());
				}

				dishList =  map.get(ingredient);
				dishList.add(dish);
			}
		}

		LinkedList<String[]> linkedList = convertToLinkedList(map);

		return linkedList.toArray(new String[linkedList.size()][]);
	}

	private LinkedList<String[]> convertToLinkedList(SortedMap<String, List<String>> map) {

		LinkedList<String[]> linkedList = new LinkedList<>();

		for(String ingredient : map.keySet()){

			List<String> dishList = map.get(ingredient);

			Collections.sort(dishList);

			if(dishList.size() > 1){
				String[] array = new String[dishList.size()+1];
				array[0] = ingredient;
				arraycopy(dishList.toArray(new String[0]), 0, array, 1, dishList.size());
				linkedList.add(array);
			}
		}
		return linkedList;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
