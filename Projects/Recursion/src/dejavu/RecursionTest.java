package dejavu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecursionTest {

    @Test
    public void testFactorial(){
        assertEquals(1, Recursion.factorial(0));
        assertEquals(120, Recursion.factorial(5));
        assertEquals(6, Recursion.factorial(3));
    }

    @Test
    public void testTriangle(){
        assertEquals(0, Recursion.triangle(0));
        assertEquals(1, Recursion.triangle(1));
        assertEquals(3, Recursion.triangle(2));
        assertEquals(6, Recursion.triangle(3));
        assertEquals(10, Recursion.triangle(4));
    }

    // This method should multiply only using repeated addition.
    // You may assume the arguments are non-negative.
    @Test
    public void testMultiply(){
        assertEquals(0, Recursion.multiply(9, 0));
        assertEquals(0, Recursion.multiply(0, 9));
        assertEquals(9, Recursion.multiply(1, 9));
        assertEquals(9, Recursion.multiply(9, 1));
        assertEquals(9, Recursion.multiply(3, 3));
    }

    // Assume first argument is positive.
    // Assume second argument is non-negative.
    // You may only use recursive multiplication.
    @Test
    public void testPower(){
        assertEquals(1, Recursion.power(2, 0));
        assertEquals(2, Recursion.power(2, 1));
        assertEquals(8, Recursion.power(2, 3));
        assertEquals(9, Recursion.power(3, 2));
    }

    @Test
    public void testFibonacci(){
        assertEquals(1, Recursion.fibonacci(0));
        assertEquals(1, Recursion.fibonacci(1));
        assertEquals(2, Recursion.fibonacci(2));
        assertEquals(3, Recursion.fibonacci(3));
        assertEquals(5, Recursion.fibonacci(4));
        assertEquals(8, Recursion.fibonacci(5));
    }

    @Test
    public void testNChooseK(){
        assertEquals(1, Recursion.nChooseK(0, 0));
        assertEquals(1, Recursion.nChooseK(3, 3));
        assertEquals(1, Recursion.nChooseK(3, 0));
        assertEquals(1, Recursion.nChooseK(7, 7));
        assertEquals(6, Recursion.nChooseK(4, 2));
    }

    @Test
    public void testReverse(){
        assertEquals("live", Recursion.reverse("evil"));
        assertEquals("", Recursion.reverse(""));
        assertEquals("I", Recursion.reverse("I"));
        assertEquals("dam", Recursion.reverse("mad"));
    }

    @Test
    public void testPalindrome(){
        assertTrue(Recursion.isPalindrome("racecar"));
        assertTrue(Recursion.isPalindrome("maam"));
        assertFalse(Recursion.isPalindrome("trait"));
        assertFalse(Recursion.isPalindrome("banana"));
    }
}