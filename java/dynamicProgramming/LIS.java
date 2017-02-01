package DynamicProgramming;

/**
 * Created by bhuvanabellala on 2/1/17.
 * Reimplemented from geeksforgeeks: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * Longest increasing subsequence
 */
public class LIS {

    /* Dynamic Programming Java implementation of LIS problem */


        /* lis() returns the length of the longest increasing
           subsequence in arr[] of size n */
        static int lis(int arr[],int n)
        {

            int[] dp = new int[n];

            //At each index of i, I need to figure out the longest increasing subsequence
            for(int i = 0; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    if(arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }

            int max = 0;
            for(int i = 0; i < n; i++){
                if(dp[i] > max){
                    max = dp[i];
                }
            }


    return max;
        }

        public static void main(String args[])
        {
            int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
            int n = arr.length;
            System.out.println("Length of lis is " + lis( arr, n ) + "\n" );
        }
    }





