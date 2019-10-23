import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 12/10/15 20:43:36
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    @Test
    public void testPop()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(0);
    	
    	testDLL.push(1);
    	testDLL.push(3);
    	
    	testDLL.pop();
    	
    	
    	assertEquals("testing pop","1,0", testDLL.toString());
    	
    	testDLL.pop();
    	testDLL.pop();
    	assertNull("Testing null", testDLL.pop());
    	
    	
    	
    	
    	
    	
    }
    @Test
    public void testPush()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.push(0);
    	testDLL.push(1);
    	testDLL.push(3);
    	
    	
    	assertEquals("Checking push to a list containing 3 elements", "3,1,0", testDLL.toString());
    
    	
    	
    }
    
    @Test 
    public void testGet()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertNull("Testing empty", testDLL.get(1));
    	testDLL.push(7);
    	assertNull("testing pos>size", testDLL.get(10));
    	testDLL.push(0);
    	assertNull("Testing pos<size", testDLL.get(-10));
    	testDLL.push(1);
    	testDLL.push(3);
    	
    	
    	assertEquals("Checking testGet", "0", testDLL.get(2).toString());
    	assertNull("Testing null", testDLL.get(-10));
    	
    	
    	
    	
    }
    
    @Test 
    public void testDelete()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertFalse("Checking empty", testDLL.deleteAt(2));
    	testDLL.push(0);
    	
    	assertFalse("checking size equal to one", testDLL.deleteAt(-5));
    	testDLL.push(3);
    	assertEquals("deleteing at 1", "3,0", testDLL.toString());
    	testDLL.deleteAt(1);
    	assertTrue("Size=1", testDLL.deleteAt(0));
    	testDLL.push(7);
    	testDLL.push(8);
    	testDLL.push(9);
    	testDLL.deleteAt(1);
    	assertEquals("Size = 2", "9,7", testDLL.toString());
    	
    	testDLL.push(0);
    	testDLL.push(8);
    	assertEquals("checking delete", "8,0,9,7", testDLL.toString());
    	testDLL.pop();
    	assertFalse("checking minus values", testDLL.deleteAt(-2));
    	assertFalse("checking greater than size", testDLL.deleteAt(100));
    	
    }
    
    @Test
    public void testEnqueue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.enqueue(1);
    	testDLL.enqueue(2);
    	
    	
    	assertEquals("Checking item enqued is the expected item", "1,2", testDLL.toString() );
    }
    @Test
    public void testDequeue()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertNull("Testing null", testDLL.dequeue());
    	testDLL.enqueue(1);
    	
    	assertEquals("Checking the item deqeued is the number expected", (Integer)1, testDLL.dequeue() );
    	
    	testDLL.enqueue(4);
    	testDLL.enqueue(11);
    	
    	
    	assertEquals("Checking it queued right", "4,11", testDLL.toString());
    	
    	testDLL.dequeue();
    	testDLL.dequeue();
    	testDLL.dequeue();
    	testDLL.dequeue();
    	assertNull("checking when size one", testDLL.dequeue());
    	
    	
    	
    	
    }
}
