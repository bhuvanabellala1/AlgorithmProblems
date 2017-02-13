package DynamicProgramming;

/**
 * Created by bhuvanabellala on 2/13/17.
 * Knapsack problem
 */
public class KnapSack {

    public static int[][] max_weights;


    public static int max(int n, int m) {
        return n > m ? n : m;
    }

    /**
     * With no repetitions
     */
    public static int knapSackNoRep(int weight, int[] weights, int[] values, int i) {

        if (i == weights.length || weight == 0) {
            return 0;
        }

        if (weights[i] > weight) {
            return knapSackNoRep(weight, weights, values, i + 1);
        }

        return max(knapSackNoRep(weight, weights, values, i + 1),
                knapSackNoRep(weight - weights[i], weights, values, i + 1) + values[i]);

    }

    /**
     * With no repetitions - bottom up
     */
    public static int knapSackRep(int weight, int[] weights, int[] values, int i) {

        int max_w;
        if (i == weights.length || weight == 0) {
            return 0;
        }

        if (weights[i] > weight) {
            max_w =  knapSackRep(weight, weights, values, i + 1);
        }

        else {
            max_w = max(knapSackRep(weight, weights, values, i + 1),
                    knapSackRep(weight - weights[i], weights, values, i) + values[i]);
        }

        max_weights[i][weight] = max_w;
        return max_w;


    }


    public static void main(String[] args) {



        int val[] = new int[]{60, 200, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 40;
        max_weights = new int[3][W+1];
        System.out.println("No Repetitions: " + knapSackNoRep(W, wt, val, 0));
        System.out.println("With Repetitions: " + knapSackRep(W, wt, val, 0));

        for(int[] i: max_weights){
            for(int j: i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
