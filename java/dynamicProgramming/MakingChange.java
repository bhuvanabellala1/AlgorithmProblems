package DynamicProgramming;

import edu.princeton.cs.algs4.In;

/**
 * Created by bhuvanabellala on 2/13/17.
 * You are given n types of coin denominations of values v(1) < v(2) < ... < v(n) (all integers).
 * Assume v(1) = 1, so you can always make change for any amount of money C.
 * Give an algorithm which makes change for an amount of money C with as few coins as possible and
 * output which coins were used
 */
public class MakingChange {




    public static int min(int n, int m) {
        return n > m ? m : n;
    }


    public static int coinChange(int weight, int[] values, int i) {

        if (weight == 0) {
            return 0;
        }

        if(weight != 0 && i == values.length){
            return Integer.MAX_VALUE - 1;
        }

        if (values[i] > weight) {
           return  coinChange(weight, values, i + 1);
        }

        else {
            return min(coinChange(weight, values, i + 1),
                    coinChange(weight - values[i], values, i) + 1);
        }



    }


    public static void main(String[] args) {



        int val[] = new int[]{11, 10, 1};
        int W = 9;

        System.out.println("Min coin changes: " + coinChange(W, val, 0));

    }
}
