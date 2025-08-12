package lists;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class LinkTest {
    private Link<String> aLink;
    private Link<String> anotherLink;

    @BeforeEach
    public void setUp(){
        aLink = new Link<>("ocarina");
        anotherLink = new Link<>("sword");
    }

    @AfterEach
    public void tearDown(){
        aLink = null;
        anotherLink = null;
    }
    
    @Test
    public void testConstructor(){
        assertEquals("ocarina", aLink.getItem());
        assertEquals("sword", anotherLink.getItem());
        assertNull(aLink.getNext());
        assertNull(aLink.getPrev());
    }

    @Test
    public void testAttachLink(){
        aLink.setNext(anotherLink);
        anotherLink.setPrev(aLink);
        assertEquals(anotherLink, aLink.getNext());
        assertNull(aLink.getPrev());
        assertEquals(aLink, anotherLink.getPrev());
        assertNull(anotherLink.getNext());
        assertEquals("ocarina", aLink.getItem());
        assertEquals("sword", anotherLink.getItem());
    }
}
