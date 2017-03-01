/*
 * Implement pow(x, n).
 */

public class Power {
    
    public double myPow(double x, int n) {
        
        if(n == 0){
            return 1.0;
        }
        
        if(n < 0){
            n *= -1;
            x = 1/x;
        }
       
	double result = 1;
	if(n % 2 == 0){
            result  = myPow(x, n/2);
	    result = result * result;
	}else{
	    result  = myPow(x, n/2);
	    result =  result * result * x;
	}
       
	if(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY){
	    return 0.0;
	}else{
	    return result;
	}
        
    }
}