package graph;
import java.util.*;

/**
 * Created by bhuvanabellala on 1/27/17.
 *
 * Problem from hackerranks - using union-find with path compression
 * The member states of the UN are planning to send  people to the Moon. But there is a problem.
 * In line with their principles of global unity, they want to pair astronauts of  different countries.
 * There are  trained astronauts numbered from  to . But those in charge of the mission did not receive
 * information about the citizenship of each astronaut. The only information they have is that some particular
 * pairs of astronauts belong to the same country.Your task is to compute in how many ways they can pick a pair of
 * astronauts belonging to different countries. Assume that you are provided enough pairs to let you identify the
 * groups of astronauts even though you might not know their country directly. For instance, if  are astronauts from
 * the same country; it is sufficient to mention that  and  are pairs of astronauts from the same country without
 * providing information about a third pair .
 * Input Format:
 * The first line contains two integers,  and , separated by a single space.  lines follow.
 * Each line contains integers separated by a single space  and  such that and are astronauts from the same country.
 * Constraints: Output Format
 * An integer that denotes the number of permissible ways to choose a pair of astronauts.
 */
public class JourneyToTheMoon {

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

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numPeo = scan.nextInt();
        int lines = scan.nextInt();

        int[] array = new int[numPeo];

        for(int i = 0; i < numPeo; i++){
            array[i] = -1;

        }

        //Create the disjoint set
        for(int i = 0; i < lines; i++){
            union(scan.nextInt(), scan.nextInt(), array);
            System.out.println(i);
        }

        Map<Integer, Integer> mapp = new HashMap<>();

        //Count the number of astronauts from each country and store in mapp
        for(int i = 0; i < numPeo; i++){
            int parent = find(i, array);
            if(mapp.containsKey(parent)){
                mapp.put(parent, mapp.get(parent) + 1);
            }else{
                mapp.put(parent, 1);
            }
        }



        //Calculate diffreent combinations. COde from https://github.com/havelessbemore/hackerrank/blob/master/algorithms/graph_theory/journey-to-the-moon.java
        long total = 0L;
        long numPartners = numPeo;
        for(Integer country : mapp.keySet()){
            int countrySize = mapp.get(country);
            total += countrySize * (numPartners -= countrySize);
        }


        System.out.println(total);
    }
}
