package graph;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayDeque;

/**
 * Created by bhuvanabellala on 2/1/17.
 */
public class bst {



        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scan = new Scanner(System.in);

            int numQ = scan.nextInt();
            for(int x = 0; x < numQ ; x++){
                int vertices = scan.nextInt();
                int[][] arr = new int[vertices][vertices];

                int numE = scan.nextInt();

                for(int i = 0; i < numE; i++){
                    int source = scan.nextInt();
                    int dest = scan.nextInt();
                    arr[source - 1][dest - 1] = 1;
                    arr[dest - 1][source - 1] = 1;
                }

                int[] dist = new int[vertices];
                for(int i = 0; i < vertices; i++){
                    dist[i] = Integer.MAX_VALUE;
                }

                Queue<Integer> mapbfs = new ArrayDeque<>();
                int startNode = scan.nextInt();
                mapbfs.add(startNode - 1);
                dist[startNode - 1] = 0;

                while(!mapbfs.isEmpty()){

                    int node = mapbfs.remove();
                    int[] edgeA = arr[node];
                    //System.out.println(node);
                    for(int i = 0; i < vertices; i++){
                        if(edgeA[i] == 1 && dist[i] == Integer.MAX_VALUE){
                            dist[i] = dist[node] + 6;
                            mapbfs.add(i);
                        }
                    }

                }

                for(int i: dist){
                    if(i == Integer.MAX_VALUE){
                        System.out.print(-1 + " ");
                    }else if(i == 0){
                        System.out.print("");
                    }else{
                        System.out.print(i + " ");
                    }
                }

                System.out.println("");

            }
        }
    }

