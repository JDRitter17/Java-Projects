package chessset;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class PositionTest {

    private Position a1;
    private Position b2;

    @BeforeEach
    public void setUp(){
        a1 = new Position(0, 0);
        b2 = new Position('b', 2);
    }

    @AfterEach
    public void tearDown(){
        a1 = null;
        b2 = null;
    }

    @Test
    public void testConstructor(){
        assertEquals('a', a1.getFile());
        assertEquals(1, a1.getRank());
        assertEquals(0, a1.fileIndex);
        assertEquals(0, a1.rankIndex);
        assertEquals("a1", a1.toString());
        assertEquals('b', b2.getFile());
        assertEquals(2, b2.getRank());
        assertEquals(1, b2.fileIndex);
        assertEquals(1, b2.rankIndex);
        assertEquals("b2", b2.toString());
    }

    @Test
    public void testEquals(){
        Position a1Alt = new Position(0, 0);
        assertFalse(a1.equals("ocarinaOfTime"));
        assertTrue(a1.equals(a1Alt));
        assertFalse(a1 == a1Alt);
    }
}
