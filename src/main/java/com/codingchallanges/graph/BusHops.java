package com.codingchallanges.graph;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Uber remote technical interview Sep/16/2021
 *
 * A bunch of bus routes.
 * Every route has a certain number of stops.
 * The routes are represented as 2D array as below [[1, 2, 7], [3, 6, 7]]
 * where route[i] shows the route that the ith bus takes.
 * For e.g 1st bus route would be 1 -> 2 -> 7 -> 1 -> 2 -> 7 -> 1 -> 2 -> 7... and so on.
 * 
 * Find the minimum number of bus changes needed given a source and a destination stop.
 * 
 * Example 1: Input: bus routes: [[1, 2, 7], [3, 6, 7], [4, 5]] ,
 * 
 * Source: 1, Destination: 7 Output: 0 (get into the first bus on stop 1 and get down at stop 7, no hops needed)
 * Source: 1, Destination: 6 Output: 1
 * Source: 1, Destination: 4, Output: -1
 * 
 */

public class BusHops {

	// Breadth first search
	private static int getHops(int[][] routes, int source, int destination) {

		Map<Integer, List<Integer>> routeToStop = new HashMap<>();

		for(int route = 0; route < routes.length; route++){

//			List<Integer> stopList = new ArrayList<>();
//
//			for(int i = 0; i < routes[route].length; i++) {
//
//				stopList.add(routes[route][i]);
//			}
			//Java 8
			routeToStop.put(route, Arrays.stream(routes[route]).boxed().collect(Collectors.toList()));
		}

		Map<Integer, List<Integer>> stopToRoute = new HashMap<>();

		for(int route = 0; route < routes.length; route++){

			List<Integer> routeList;

			for(int i = 0; i < routes[route].length; i++) {

				if(!stopToRoute.containsKey(routes[route][i])) {
					stopToRoute.put(routes[route][i], new ArrayList<>());
				}
				routeList = stopToRoute.get(routes[route][i]);
				routeList.add(route);
			}
		}

//		System.out.println("routeToStop " + routeToStop);
//		System.out.println("stopToRoute " + stopToRoute);

		int hops = -1;

		if(stopToRoute.containsKey(source)) {

			List<Integer> routeList = stopToRoute.get(source);

			Queue<Integer> q = new LinkedList<>(routeList);

			List<Integer> visitedRoute = new ArrayList<>();

			while(!q.isEmpty()) {

				Integer route = q.poll();

				if(visitedRoute.contains(route)) continue;

				visitedRoute.add(route);

				hops++;

				List<Integer> stopList = routeToStop.get(route);

				for(int stop : stopList) {

					if(stop == destination) {
						return hops;
					}

					q.addAll(stopToRoute.get(stop));
				}
			}
		}

		return -1;
	}

    public static void main(String[] args) {

		int source = 1;
        int[][] routes = {{1, 2, 7}, {3, 6, 7}, {4, 5}};

        System.out.println(getHops(routes, source, 7));
        System.out.println(getHops(routes, source, 6));
        System.out.println(getHops(routes, source, 4));
    }

}
