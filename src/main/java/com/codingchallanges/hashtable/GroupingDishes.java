package com.codingchallanges.hashtable;

import java.util.*;

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

	// Incomplete
	static String[][] solution2(String[][] dishes) {

		SortedMap<String, LinkedList<String>> map = new TreeMap<>();

		for(String[] menu : dishes){

			String ingredient;
			String dish = menu[0];
			LinkedList<String> dishList;

			for(int i = 1; i < menu.length; i++){

				ingredient = menu[i];

				dishList = map.getOrDefault(ingredient, new LinkedList<>());
				dishList.add(dish);
				map.put(ingredient, dishList);
			}
		}

		for(String ingredient : map.keySet()){
			LinkedList<String> dishList = map.get(ingredient);
			Collections.sort(dishList);
			dishList.addFirst(ingredient);
		}

        return map.values().stream().map(list -> list.toArray(new String[0])).toArray(String[][]::new);
	}

	static String[][] solution(String[][] dishes) {

		SortedMap<String, List<String>> map = new TreeMap<>();

		for(String[] menu : dishes){

			String ingredient;
			String dish;
			List<String> dishList;

			for(int i = 1; i < menu.length; i++){

				dish = menu[0];
				ingredient = menu[i];

				dishList = map.getOrDefault(ingredient, new ArrayList<>());
				dishList.add(dish);
				map.put(ingredient, dishList);
			}
		}

		List<String[]> list = convertToList(map);

		return list.toArray(new String[list.size()][]);
	}


	private static List<String[]> convertToList(SortedMap<String, List<String>> map) {

		List<String[]> list = new ArrayList<>();

		for(String ingredient : map.keySet()){

			List<String> dishList = map.get(ingredient);

			Collections.sort(dishList);

			if(dishList.size() > 1){
				String[] array = new String[dishList.size()+1];
				array[0] = ingredient;
				System.arraycopy(dishList.toArray(), 0, array, 1, dishList.size());
				list.add(array);
			}
		}
		return list;
	}


	public static void main(String[] args) {

		String[][] dishes_1 = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
				{"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
				{"Quesadilla", "Chicken", "Cheese", "Sauce"},
				{"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};


//		System.out.println(Utility.printArray(solution(dishes_1)));
		System.out.println(Arrays.deepToString(solution(dishes_1)));

		String[][] dishes_2 = {{"Pasta", "Tomato Sauce", "Onions", "Garlic"},
				{"Chicken Curry", "Chicken", "Curry Sauce"},
				{"Fried Rice", "Rice", "Onions", "Nuts"},
				{"Salad", "Spinach", "Nuts"},
				{"Sandwich", "Cheese", "Bread"},
				{"Quesadilla", "Chicken", "Cheese"}};

//		System.out.println(Utility.printArray(solution(dishes_2)));
		System.out.println(Arrays.deepToString(solution(dishes_2)));

	}

}
