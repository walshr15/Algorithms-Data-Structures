import java.util.ArrayList;

//import java.util.Arrays;

/**
 * CS2010 (Hilary Term) - Assignment 1
 *
 * Nine Digit Perfect Square
 *
 * A natural number, p, is a perfect square if for some natural number k, k^2=p.
 * For example, 16 is a perfect square, as 4^2=16. The number 20 is not a
 * perfect square as there is no natural number k such that k^2=20.
 *
 * Problem: Develop an algorithm that will find all nine-digit perfect squares
 * that use all nine digits exactly once. For example, 139,854,276 is a solution
 * (the first) as 11,826^2=139,854,276.
 *
 * 1) Fill in the implementation of the methods described in this file.
 *
 * 2) Test your implementation by developing suitable test suite in the
 * NineDigitPerfectSquareTest JUnit test case.
 *
 * @author:
 *
 */

public class NineDigitPerfectSquare {

    /**
     * A method to return an array containing all squeres between low and high
     *
     * @param low: lowest perfect square
     * @param high: largest perfect square
     *
     * @return an array containing all the perfect squares between low and high
     */
    public int[] perfectSquaresBetween(int low, int high){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int start = low;
    	int end = high;
    	int odd =1;
    	
    	
    	 while(start+2<=end)
     	{
     		odd+=2;
     		start +=odd;
     		list.add(start);
     	}
    	 int r[] = new int[list.size()];
    	 for(int i=0; i<list.size(); i++){
    		 r[i] = list.get(i);
    	 }
    	 return r;
    }


    public int countNineDigitPerfectSquares(){
    	
        return getNineDigitPerfectSquares().length;
    }

    /**
     * A method to determine if the number specified in parameter "number"
     * contains all 9 digits exactly once.
     *
     * @param number
     *            : A number to be tested
     * @return whether the number contains all 9 digits exactly once
     */
    public boolean containsAllDigitsOnce(int number) {
    	int[] digits = new int[10];
    	for(int i=0;i<digits.length; i++){
    		digits[i] = 0;
    	}
    	String numbers = Integer.toString(number);
    	for(int i=0; i<numbers.length(); i++){
    		String c = "" + numbers.charAt(i);
    		int z = Integer.parseInt(c);
    		digits[z]++; 
    	}
    	for(int k=1; k<digits.length; k++){
    		if(digits[k] != 1){
    			return false;
    		}
    	}
    	return true;
    }


    /**
     * A method to return an array containing all the squares discovered
     *
     * @return an array containing all of the perfect squares which
     * contain all digits 1..9 exactly once.
     */
    public int[] getNineDigitPerfectSquares() {
   	   	int high = 987654321;
    	int low = 1;
    	
    	int[] possibleArray = perfectSquaresBetween(low,high);
    	ArrayList<Integer> resultList = new ArrayList<Integer>();

    	
    	for(int i=0;i<possibleArray.length;i++)
    	{
    		if(containsAllDigitsOnce(possibleArray[i])==true)
    			resultList.add(possibleArray[i]);
    		
    			
    	}
    	int[] resultArray=new int[resultList.size()];
    	for(int i =0; i<resultList.size();i++)
    	{
    		resultArray[i] = resultList.get(i);
    	}
        return resultArray;

    }

}