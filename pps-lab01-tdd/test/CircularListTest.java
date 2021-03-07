import lab01.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;
    private final int STRATEGY_TEST_PARAMETER = 3;

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

    @Test
    public void testNextOnFirst(){
        list.add(0);
        Assertions.assertEquals(Optional.of(0),list.next());

    }

    @Test
    public void testNextOnLast(){
        list.add(0);
        list.add(1);
        Assertions.assertEquals(Optional.of(0),list.next());
        Assertions.assertEquals(Optional.of(1),list.next());
        Assertions.assertEquals(Optional.of(0),list.next());
    }

    @Test
    public void testPreviousOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.previous());
    }

    @Test
    public void testPreviousOnFirst(){
        list.add(0);
        list.add(1);
        Assertions.assertEquals(Optional.of(1),list.previous());
    }

    @Test
    public void testPreviousOnOneValue(){
        list.add(0);
        Assertions.assertEquals(Optional.of(0),list.previous());
    }

    @Test
    public void testBothDirectionListIteration(){
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);

        Assertions.assertEquals(Optional.of(0),list.next());
        Assertions.assertEquals(Optional.of(3),list.previous());
        Assertions.assertEquals(Optional.of(2),list.previous());
        Assertions.assertEquals(Optional.of(1),list.previous());
        Assertions.assertEquals(Optional.of(2),list.next());
    }

    @Test
    public void testReset(){
        list.add(0);
        list.add(1);
        Assertions.assertEquals(Optional.of(0),list.next());
        list.reset();
        Assertions.assertEquals(Optional.of(0),list.next());
    }

    @Test
    public void testEvenStrategyOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next(new EvenStrategy()));
    }

    @Test
    public void testMultipleOfStrategyOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next(new MultipleOfStrategy(STRATEGY_TEST_PARAMETER)));
    }

    @Test
    public void testEqualsStrategyOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next(new EqualsStrategy(STRATEGY_TEST_PARAMETER)));
    }

    @Test
    public void testEvenStrategy(){
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(1);

        Assertions.assertEquals(Optional.of(2),list.next(new EvenStrategy()));
        Assertions.assertEquals(Optional.of(4),list.next(new EvenStrategy()));
        Assertions.assertEquals(Optional.of(2),list.next(new EvenStrategy()));
    }

    @Test
    public void testEvenStrategyNoMatch(){
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(5);

        Assertions.assertEquals(Optional.empty(),list.next(new EvenStrategy()));
        Assertions.assertEquals(Optional.of(1),list.next());
        Assertions.assertEquals(Optional.empty(),list.next(new EvenStrategy()));
        Assertions.assertEquals(Optional.of(3),list.next());
    }

    @Test
    public void testMultipleOfStrategy(){
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(1);
        list.add(9);

        Assertions.assertEquals(Optional.of(3),list.next(new MultipleOfStrategy(STRATEGY_TEST_PARAMETER)));
        Assertions.assertEquals(Optional.of(9),list.next(new MultipleOfStrategy(STRATEGY_TEST_PARAMETER)));
        Assertions.assertEquals(Optional.of(3),list.next(new MultipleOfStrategy(STRATEGY_TEST_PARAMETER)));
    }

    @Test
    public void testMultipleOfStrategyNoMatch(){
        list.add(1);
        list.add(5);
        list.add(2);

        Assertions.assertEquals(Optional.of(1),list.next());
        Assertions.assertEquals(Optional.empty(),list.next(new MultipleOfStrategy(STRATEGY_TEST_PARAMETER)));
        Assertions.assertEquals(Optional.of(5),list.next());
    }

    @Test
    public void testEqualsStrategy(){
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(3);

        Assertions.assertEquals(Optional.of(3),list.next(new EqualsStrategy(STRATEGY_TEST_PARAMETER)));
        Assertions.assertEquals(Optional.of(3),list.next(new EqualsStrategy(STRATEGY_TEST_PARAMETER)));
        Assertions.assertEquals(Optional.of(3),list.next(new EqualsStrategy(STRATEGY_TEST_PARAMETER)));
    }

}
