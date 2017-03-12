package DynamicProgramming;

/**
 * Created by bhuvanabellala on 2/1/17.
 * Reimplemented from geeksforgeeks: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * Longest increasing subsequence
 */
public class LIS {

    public static int lis(int[] nums) {
        int [] lengths = new int[nums.length];
        
        
        for(int i = 0; i < nums.length; i++){
            lengths[i] = 1;
            for(int j = i-1; j >= 0; j--){
                
                if(nums[i] > nums[j]){
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
                
            }
        }
        
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = lengths[i] > max ? lengths[i] : max;
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





