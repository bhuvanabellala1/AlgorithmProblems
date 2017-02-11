package graph;

// Java program for Kruskal's algorithm to find Minimum Spanning Tree
// of a given connected, undirected and weighted graph

import java.util.*;
import java.lang.*;
import java.io.*;

public class Kruskals {


    private class Edge implements Comparable<Edge>{

        private int _src;
        private int _dest;
        private int _cost;

        private Edge(int src, int dest, int cost){
            _src = src;
            _dest = dest;
            _cost = cost;
        }

        public int compareTo(Edge T){
            return this._cost - T._cost;

        }

    }

    /**
     * Finds the parent set of the given vertex, n. Compresses path
     * @param n - component
     * @param array - disjoint set represented by an int array
     * @return the root of component n
     */
    public static int find(int n, int[] array){

        int source = n;
        while(array[n] != -1){
            n = array[n];
        }

        //path compression
        while(array[source] != -1){
            int temp = array[source];
            array[source] = n;
            source = temp;
        }
        return n;
    }

    /**
     * Connects two disjoint sets
     * @param n1 - component 1
     * @param n2 - component 2
     * @param array - disjoint set represetnted by an int array
     */
    public static void union(int n1, int n2, int[] array){
        int p1 = find(n1, array);
        int p2 = find(n2, array);
        if(p1 != p2) {
            array[p2] = p1;
        }
    }

    private void kruskal(){

        //Hack, Creating a graph here.
        Queue<Edge> edges = new PriorityQueue<>();
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(3, 2, 4));
        int num_vertices = 4;

        //Let's so kruskals on this graph
        int[] parents = new int[num_vertices];
        for(int i = 0; i < num_vertices; i++){
            parents[i] = -1;
        }

        List<Edge> result = new ArrayList<>();

        while(!edges.isEmpty()){

            Edge e = edges.poll();
            int p_src = find(e._src, parents);
            int q_src = find(e._dest, parents);

            if(p_src != q_src){
                union( p_src, q_src, parents);
                result.add(e);
            }

        }

        for(Edge e: result){
            System.out.println(e._src + " ------> " + e._dest);
        }



    }

    // Driver Program
    public static void main(String[] args) {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        Kruskals mst = new Kruskals();
        mst.kruskal();

    }
}

//This code is contributed by Aakash Hasija}
