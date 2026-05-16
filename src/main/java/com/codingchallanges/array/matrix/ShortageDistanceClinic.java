package com.codingchallanges.array.matrix;

/**
 * Write a java function for the following problem: A health care provide is setting up clincs in a city.
 * The goal is to place the clinics closest to each other. Give the city as an n x x matric and the coordinates
 * of the clinics (i, j) within that matrics. Print the shortest distance from each location to nearest the clinics .
 * <p
 * Example:
 * clinics: [{0, 0}, {0, 4}, {2, 3}, {3, 3}, {4, 0}]
 * sizeOfCity = 5
 * <p>
 * Output:
 * [
 *   [0, 1, 2, 1, 0],
 *   [1, 1, 1, 1, 1],
 *   [2, 2, 1, 0, 1],
 *   [1, 1, 1, 0, 1],
 *   [0, 1, 2, 1, 0]
 * ]
 */
public class ShortageDistanceClinic {

    public int[][] shortageDistanceClinic(int[][] coordinatesOfClincs, int sizeOfCity) {
    int[][] distance = new int[sizeOfCity][sizeOfCity];
    boolean[][] visited = new boolean[sizeOfCity][sizeOfCity];
    int[] directions = {-1, 0, 1, 0, -1}; // Up, Right, Down, Left
    int clinicCount = coordinatesOfClincs.length;
    int distanceValue = 0;
    for (int i = 0; i < clinicCount; i++) {
        int x = coordinatesOfClincs[i][0];
        int y = coordinatesOfClincs[i][1];
        if (!visited[x][y]) {
            dfs(coordinatesOfClincs, sizeOfCity, x, y, distance, visited, directions, distanceValue);
        }
    }
    for (int i = 0; i < sizeOfCity; i++) {
        for (int j = 0; j < sizeOfCity; j++) {
            if (!visited[i][j]) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    return distance;

}

    private void dfs(int[][] coordinatesOfClincs, int sizeOfCity, int x, int y, int[][] distance, boolean[][] visited, int[] directions, int distanceValue) {
        if (x < 0 || x >= sizeOfCity || y < 0 || y >= sizeOfCity || visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        distance[x][y] = Math.min(distance[x][y], distanceValue);

        for (int i = 0; i < directions.length - 1; i++) {
            int newX = x + directions[i];
            int newY = y + directions[i + 1];
            dfs(coordinatesOfClincs, sizeOfCity, newX, newY, distance, visited, directions, distanceValue + 1);
        }
    }
    }
