package com.codingchallanges.array.matrix;

import java.util.Arrays;

/**
 * <a href="https://www.codewars.com/kata/5a3f1c0e8f27f2d9b00000b4/train/java">analyze_brick</a>
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 * where n is the number of bricks in the wall
 *
 * @author Ashish Kumar
 * @since 30th Dec, 2024
 * <p>
Dec, 2024 - Paypal
Given a wall and a position, write a function to return how many neighbors the brick at that position has.

The position within the wall is given from the top-left. This position may fall anywhere within a brick (not necessarily at the start) and identifies the brick where it points to. Additionally, dependning on the brick width, there can be multiple positions to identify the same brick.

For example, in the wall below (positions are noted by dots • in the schema below):
- the brick at (0, 2) has four neighbors.
- the brick at (2, 5) has seven neighbors.
- the brick at (4, 2) has six neighbors.
- the brick at (5, 6) has three neighbors.
- the brick at (5, 7) has two neighbors.

     +---+---+---+---+---+---+---+---+---+
     |         •  (7)            | 1 | 1 |
     +---+---+---+---+---+---+---+---+---+
     |         5         | 1 | 1 |   2   |
     +---+---+---+---+---+---+---+---+---+
     |     3     |      (4)•     | 1 | 1 |
     +---+---+---+---+---+---+---+---+---+
     | 1 | 1 | 1 | 1 |     3     |   2   |
     +---+---+---+---+---+---+---+---+---+
     | 1 |  (2)• | 1 |     3     |   2   |
     +---+---+---+---+---+---+---+---+---+
     | 1 | 1 | 1 | 1 |    (3)  • | •(2)  |
     +---+---+---+---+---+---+---+---+---+

brick_wall_7 = [
 [7,1,1],
 [5,1,1,2],
 [3,4,1,1], col = j (2, 5)-->  i=2, j=0 -> j++, col + 3 -> (i=2, j=1), col=3, (2, 1), col=7 {{(2, 5) -> (2, 1)}}
 [1,1,1,1,3,2],
 [1,2,1,3,2],
 [1,1,1,1,3,2]
]

brick_wall_8 = [
 [1,1,1,1,1,1,1,1],
 [1,1,1,1,1,1,1,1],
 [1,1,1,1,1,1,1,1]
]

brick_wall_9 = [
 [1,5,1]
]

brick_wall_10 = [
 [3],
 [3]
]

analyze_brick(brick_wall_7, 0, 2) => 4
analyze_brick(brick_wall_7, 2, 5) => 7
analyze_brick(brick_wall_7, 4, 2) => 6
analyze_brick(brick_wall_7, 5, 6) => 3
analyze_brick(brick_wall_7, 5, 7) => 2
analyze_brick(brick_wall_8, 1, 1) => 4
analyze_brick(brick_wall_9, 0, 4) => 2
analyze_brick(brick_wall_10, 0, 2)=> 1

Complexity analysis variables:

n: number of bricks in the wall
w: wall width
h: wall height (in layers)
*/

public class Wall {

        public static void main(String[] argv) {
            int[][] brick_wall_7 = {
                    {7, 1, 1},
                    {5, 1, 1, 2},
                    {3, 4, 1, 1},
                    {1, 1, 1, 1, 3, 2},
                    {1, 2, 1, 3, 2},
                    {1, 1, 1, 1, 3, 2}
            };

            int[][] brick_wall_8 = {
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1}
            };

            int[][] brick_wall_9 = {
                    {1, 5, 1}
            };

            int[][] brick_wall_10 = {
                    {3},
                    {3}
            };

            System.out.println(analyze_brick(brick_wall_7, 0, 2));
            System.out.println(analyze_brick(brick_wall_7, 2, 5));
            System.out.println(analyze_brick(brick_wall_7, 4, 2));
            System.out.println(analyze_brick(brick_wall_7, 5, 6));
            System.out.println(analyze_brick(brick_wall_7, 5, 7));

            // System.out.println(analyze_brick(brick_wall_8, 1, 1));
            // System.out.println(analyze_brick(brick_wall_9, 0, 4));
            // System.out.println(analyze_brick(brick_wall_10, 0, 2));

        }

        //TODO - Incomplete
        private static int analyze_brick(int[][] wall, int i, int j){

            int width = Arrays.stream(wall[0]).sum();

            System.out.println("width = " + width + ", height = " + wall.length);

            return 0;
        }

}
