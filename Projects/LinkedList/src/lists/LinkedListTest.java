package lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest {

    private LinkedList<String> aList;

    @BeforeEach
    public void setUp(){
        aList = new LinkedList<>();
    }

    @AfterEach
    public void tearDown(){
        aList =  null;
    }

    @Test
    public void testConstructor(){
        assertTrue(aList.isEmpty());
        assertEquals(0, aList.size());
        assertNull(aList.removeFirst());
        assertNull(aList.removeLast());
    }

    @Test
    public void testAddFirst(){
        aList.addFirst("mi");
        assertFalse(aList.isEmpty());
        assertEquals(1, aList.size());
        assertEquals("mi", aList.get(0));
        aList.addFirst("re");
        assertFalse(aList.isEmpty());
        assertEquals(2, aList.size());
        assertEquals("re", aList.get(0));
        assertEquals("mi", aList.get(1));
        aList.addFirst("do");
        assertFalse(aList.isEmpty());
        assertEquals(3, aList.size());
        assertEquals("do", aList.get(0));
        assertEquals("re", aList.get(1));
        assertEquals("mi", aList.get(2));
    }

    @Test
    public void testAddLast(){
        aList.addLast("do");
        assertFalse(aList.isEmpty());
        assertEquals(1, aList.size());
        assertEquals("do", aList.get(0));
        aList.addLast("re");
        assertFalse(aList.isEmpty());
        assertEquals(2, aList.size());
        assertEquals("do", aList.get(0));
        assertEquals("re", aList.get(1));
        aList.addLast("mi");
        assertFalse(aList.isEmpty());
        assertEquals(3, aList.size());
        assertEquals("do", aList.get(0));
        assertEquals("re", aList.get(1));
        assertEquals("mi", aList.get(2));
    }

    @Test
    public void testRemoveFirst(){
        aList.addLast("do");
        aList.addLast("re");
        aList.addLast("mi");
        String item = aList.removeFirst();
        assertFalse(aList.isEmpty());
        assertEquals(2, aList.size());
        assertEquals("do", item);
        assertEquals("re", aList.get(0));
        assertEquals("mi", aList.get(1));
        item = aList.removeFirst();
        assertFalse(aList.isEmpty());
        assertEquals(1, aList.size());
        assertEquals("re", item);
        assertEquals("mi", aList.get(0));
        item = aList.removeFirst();
        assertTrue(aList.isEmpty());
        assertEquals(0, aList.size());
        assertEquals("mi", item);
    }

    @Test
    public void testRemoveLast(){
        aList.addLast("do");
        aList.addLast("re");
        aList.addLast("mi");
        String item = aList.removeLast();
        assertFalse(aList.isEmpty());
        assertEquals(2, aList.size());
        assertEquals("mi", item);
        assertEquals("do", aList.get(0));
        assertEquals("re", aList.get(1));
        item = aList.removeLast();
        assertFalse(aList.isEmpty());
        assertEquals(1, aList.size());
        assertEquals("re", item);
        assertEquals("do", aList.get(0));
        item = aList.removeLast();
        assertTrue(aList.isEmpty());
        assertEquals(0, aList.size());
        assertEquals("do", item);   
    }

    @Test
    public void testBadUsage(){
        assertNull(aList.removeFirst());
        assertNull(aList.removeLast());
        assertNull(aList.get(0));
        aList.addFirst("do");
        assertNull(aList.get(-1));
        assertNull(aList.get(3));
    }
}
