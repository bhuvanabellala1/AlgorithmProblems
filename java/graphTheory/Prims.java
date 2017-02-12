package graph;
import edu.princeton.cs.algs4.In;

import java.util.Map;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by bhuvanabellala on 2/11/17.
 * Implemented from http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 */
public class Prims<T> {



    private static void prims(int[][] graph){


        int num_vertices = graph.length;
        boolean[] inMst = new boolean[num_vertices];
        int[] parent = new int[num_vertices];
        int[] cost = new int[num_vertices];

        for(int i = 0; i < num_vertices; i++){
            cost[i] = Integer.MAX_VALUE;
        }

        cost[0] = 0;
        parent[0] = -1;

       for(int i = 0; i < num_vertices - 1; i++){

           int min_Vertex = -1;
           int min_cost = Integer.MAX_VALUE;

           for(int j = 0 ; j < num_vertices; j++){
               if(!inMst[j] && cost[j] < min_cost ){
                   min_Vertex = j;
                   min_cost = cost[i];
               }
           }

           if(min_Vertex != -1){
               inMst[min_Vertex] = true;

               //update cost of all adjacent nodes
               for(int adj = 0; adj < num_vertices; adj++){
                   if(!inMst[adj] && graph[min_Vertex][adj] != 0
                           && cost[adj] > graph[min_Vertex][adj]){
                       parent[adj] = min_Vertex;
                       cost[adj] = graph[min_Vertex][adj];
                   }
               }
           }


       }

        printMst(parent, graph);

    }

    private static void printMst(int[] parent, int[][] graph){

        System.out.println("Edge   Weight");
        for (int i = 1; i < graph.length; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                    graph[i][parent[i]]);

    }

    // Driver Program
    public static void main(String[] args) {


         /* Let us create the following graph
          2    3
      (0)--(1)--(2)
       |   / \   |
      6| 8/   \5 |7
       | /     \ |
      (3)-------(4)
            9          */
        int graph[][] = {{0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0},
        };

        prims(graph);

    }
}
