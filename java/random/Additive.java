/**
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. 
 * Except for the first two numbers, each subsequent number in the sequence 
 * must be the sum of the preceding two.
 */

public class Additive {
    public boolean isAdditiveNumber(String num) {
        if(num.length() <= 2){
            return false;
        }else{
            return helper(num, (long) Character.getNumericValue(num.charAt(0)), 
			  (long) Character.getNumericValue(num.charAt(1)), 2);
        }
    }
    
    public boolean helper(String num, long left, long right, int index){
        
        if( index >= num.length()){
            return false;
        }
        
        String sum = String.valueOf(left + right);
        boolean s = false;
        for(int i = 0; i+index < num.length() && i < sum.length(); i++){
            if(!(num.charAt(i+index) == sum.charAt(i))){
                break;   
            }
            else{
                if(i+index == num.length() - 1 && i == sum.length() - 1){
                    return true;
                }
                if(i == sum.length() - 1){
		    s = helper(num, right, Long.parseLong(sum), i+index + 1);
                }
            }
        }
        
        boolean leftSum = false;
        boolean rightSum = false;
        
        if(right != 0){
            leftSum = helper(num, left, right*10 + (long) Character.getNumericValue(num.charAt(index)), index + 1);
        }
        
        if(left != 0){
            rightSum = helper(num, left*10 + right, (long) Character.getNumericValue(num.charAt(index)), index + 1);
        }
        return leftSum || rightSum || s;
    }
}
