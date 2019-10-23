import java.util.ArrayList;
import java.util.List;

/**
 * CS2010 (Hilary Term) - Assignment 3
 * 
**/

public class SelfDivisibleNumbers {
	
	ArrayList<Integer> myList = new ArrayList<>();
	int p[] = new int[9];
	boolean[] used = new boolean[9];
	int numberOfSelfD = 0;
	public SelfDivisibleNumbers() {
		// TODO: Implement
		all_perms(0);
//		numberOfSelfD=getSelfDivisibleNumbers().size();
	}
	
	/**
	 * Method to produce a number corresponding to first k digits of the digits array
	 * @param digits
	 * @param k number of digits to construct the result from
	 * @return number
	 */
	public int getFirstKDigitNumber(int[] digits, int k) {
		// TODO: Implement
		int temp = 0;
		int result = 0;
		for(int i=0;i<k; i++){
			temp = digits[i];
			result*=10;
			result += temp;
		}
		return result;
	}
	
	/**
	 * Method to check if the specified number is divisible by the divisor
	 * @param number
	 * @param divisor
	 * @return true if number is divisible by the divisor
	 */
	public boolean isDivisible(int number, int divisor) {
		// TODO: Implement
		if(number%divisor == 0){
			return true;
		}
			return false;
	}
	
	/**
	 * Method to return a list containing all self divisible numbers found
	 * @return 9-digit self divisible numbers
	 */
	public List<Integer> getSelfDivisibleNumbers() {
		// TODO: Implement
		//all_perms(0);
		return myList;
	}
	
	/**
	 * Method to return the number of self divisible numbers found
	 * @return number of 9-digit self divisible numbers
	 */
	public int getNumberOfSelfDivisibleNumbers() {
		// TODO: Implement 
		return myList.size();
	}
	
	void all_perms(int k){   
		if ( k == p.length ){
			myList.add(getFirstKDigitNumber(p, k));
		}else 
			for (int j = 0; j < p.length; j = j+1){
				if (!used[j])
				{
					p[k] = j+1;
                    used[j] = true;
                    System.out.println(getFirstKDigitNumber(p,k+1));
                    if(isDivisible(getFirstKDigitNumber(p,k+1),k+1)){
                    	all_perms(k+1);
                    }
                    used[j] = false;
                }
            }
    }
}
