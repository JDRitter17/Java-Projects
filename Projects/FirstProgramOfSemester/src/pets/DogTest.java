package pets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DogTest {
    private Dog aDog;

    @BeforeEach
    public void setUp(){
        aDog = new Dog();
    }

    @AfterEach
    public void tearDown(){
        aDog = null;
    }

    @Test
    public void testSpeak(){
        assertEquals("Arf", aDog.speak());
    }
    
}
