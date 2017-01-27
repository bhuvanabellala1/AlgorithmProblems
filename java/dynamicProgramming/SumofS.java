package DynamicProgramming;
import java.util.*;

/**
 * Created by bhuvanabellala on 1/27/17.
 * Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
 * Find the minimum number of coins the sum of which is S
 * (we can use as many coins of one type as we want), or
 * report that it’s not possible to select coins in such a way that they sum up to S.
 * Implementation taken from: https://www.topcoder.com/community/data-science/data-science-tutorials/dynamic-programming-from-novice-to-advanced/
 */
public class SumofS {

    public static void main(String[] args) {

        int S = 30;
        int[] coins = {3,5, 6,8};
        int[] min = new int[S+1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        for(int val: coins){
        for(int i = 1; i <= S; i++){

                if(val <= i && min[i-val] != Integer.MAX_VALUE && min[i-val]+1 < min[i]){
                    min[i] = min[i-val]+1;
                }
            }
        }

        System.out.println(min[S]);

    }
}
