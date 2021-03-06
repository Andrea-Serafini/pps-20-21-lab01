import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test
    public void testAddSize(){
        list.add(0);
        Assertions.assertEquals(1,list.size());
    }

    @Test
    public void testIsEmpty(){
        Assertions.assertTrue(list.isEmpty());
        list.add(0);
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testNextOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next());
    }

}
