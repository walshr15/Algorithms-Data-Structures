import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;


public class SelfDivisibleNumbersTest {


	
//	@Test
//	public void constructorTest() {
//		
//	}
//	
	@Test
	public void testIsDivisible(){
		SelfDivisibleNumbers sdn = new SelfDivisibleNumbers();
		boolean divisible = sdn.isDivisible(200,100);
		assertTrue(divisible);
	}
	
	
	@Test
	public void testTest(){

		SelfDivisibleNumbers sdn = new SelfDivisibleNumbers();
		java.util.List<Integer> arrayList = new ArrayList<>();
		assertNotNull("Checking the constructor",sdn);
		arrayList = sdn.getSelfDivisibleNumbers();
		int[] expected = { 381654729 };
		int[] actual = new int[arrayList.size()];
	    for (int i=0; i < actual.length; i++)
	    {
	        actual[i] = arrayList.get(i).intValue();
	    }

		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void getFirstKDigitNumber(){
		SelfDivisibleNumbers sdn = new SelfDivisibleNumbers();
		int testDigits[] = {1,2,3,4,5,6,7,8,9};
		int actual = sdn.getFirstKDigitNumber(testDigits, 3);
		int expected = 123;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testNumberOfSelfDivisibles(){
		SelfDivisibleNumbers sdn = new SelfDivisibleNumbers();
		int expected = 1;
		int actual = sdn.getNumberOfSelfDivisibleNumbers();
		assertEquals(expected, actual);
	}

}
