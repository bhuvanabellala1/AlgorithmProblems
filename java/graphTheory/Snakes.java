package graph;

import java.util.*;

/**
 * Question from: https://www.hackerrank.com/challenges/the-quickest-way-up
 * Markov takes out his Snakes and Ladders game and stares at the board, and wonders:
 * If he had absolute control on the die (singular), and could get it to generate any number
 * (in the range ) he desired, what would be the least number of rolls of the die in which he'd
 * be able to reach the destination square (Square Number ) after having started at the base
 * square (Square Number )?
 * Rules
 * 1) Markov has total control over the die and the face which shows up every time he tosses it.
 * You need to help him figure out the minimum number of moves in which he can reach the target
 * square (100) after starting at the base (Square 1).
 * 2)A die roll which would cause the player to land up at a square greater than 100, goes wasted,
 * and the player remains at his original square. Such as a case when the player is at Square
 * Number 99, rolls the die, and ends up with a 5.
 * 3)If a person reaches a square which is the base of a ladder, (s)he has to climb up that ladder, and he cannot come down on it. If a person reaches a square which has the mouth of the snake, (s)he has to go down the snake and come out through the tail - there is no way to climb down a ladder or to go up through a snake.
 */

public class Snakes {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        for (int cas = 0; cas < testCases; cas++) {

            int[] numMoves = new int[101];

            for (int i = 0; i < 101; i++) {
                numMoves[i] = Integer.MAX_VALUE;
            }

            int numLadders = scan.nextInt();
            Map<Integer, Integer> ladder = new HashMap<>();
            for (int i = 0; i < numLadders; i++) {
                ladder.put(scan.nextInt(), scan.nextInt());
            }

            int numSnakes = scan.nextInt();
            Map<Integer, Integer> snakes = new HashMap<>();
            for (int i = 0; i < numSnakes; i++) {
                snakes.put(scan.nextInt(), scan.nextInt());
            }

            //bfs is fine because distance every node is 1 unit away
            numMoves[1] = 0;
            Deque<Integer> que = new ArrayDeque<>();
            que.add(1);
            boolean dest = false;

            while (!que.isEmpty() && !dest) {
                int node = que.remove();

                //Check all adjacent nodes
                for (int i = 1; i < 7 && node + i <= 100; i++) {

                    int addNode = node + i;

                    //If node hasn't already been visited
                    if (numMoves[addNode] == Integer.MAX_VALUE) {

                        //In the ladder or snakes, add the to node
                        if (ladder.containsKey(addNode)) {

                            numMoves[addNode] = numMoves[node] + 1;
                            numMoves[ladder.get(addNode)] = numMoves[node] + 1;
                            addNode = ladder.get(node + i);

                        } else if (snakes.containsKey(node + i) &&
                                numMoves[snakes.get(node + i)] == Integer.MAX_VALUE) {

                            numMoves[node + i] = numMoves[node] + 1;
                            numMoves[snakes.get(node + i)] = numMoves[node] + 1;
                            addNode = snakes.get(node + i);

                        } else {
                            numMoves[node + i] = numMoves[node] + 1;
                        }

                        que.add(addNode);
                        if (addNode == 100) {
                            dest = true;
                        }

                    }
                }
            }
            if (numMoves[100] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(numMoves[100]);
            }
        }
    }
}