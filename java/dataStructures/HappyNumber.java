package leetcode;
import java.util.Set;
import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares
 * of its digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for which
 * this process ends in 1 are happy numbers.
 * Created by bhuvanabellala on 1/16/17.
 */


public class HappyNumber {


        public static boolean isHappy(int n) {

            Set<Integer> values = new HashSet<>();

            int sum = 0;

            while(n != 1 && !values.contains(n)){
                values.add(n);
                sum = 0;
                while(n/10 != 0){
                    sum = sum + ((n % 10) * (n % 10));
                    n = n/10;
                }
                sum = sum + (n * n);
                n = sum;

            }

            if(n == 1){
                return true;
            }else{
                return false;
            }

    }

    public static void main(String[] args){
        System.out.println(isHappy(200));
        System.out.println("ee" + 6);
        String j, k = "string";
    }
}

