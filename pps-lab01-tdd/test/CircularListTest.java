import lab01.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList list;
    private static SelectStrategy even;
    private static SelectStrategy odd;
    private static SelectStrategy equal;
    private static SelectStrategy unequal;
    private static SelectStrategy multiple;
    private static SelectStrategy notMultiple;
    private static final int STRATEGY_TEST_PARAMETER = 3;

    @BeforeAll
    static void beforeAll(){
        even = StrategiesFactoryProducer.getFactoryType("TRUE").getEvenSelectStrategy();
        odd = StrategiesFactoryProducer.getFactoryType("FALSE").getEvenSelectStrategy();
        equal = StrategiesFactoryProducer.getFactoryType("TRUE").getEqualSelectStrategy(STRATEGY_TEST_PARAMETER);
        unequal = StrategiesFactoryProducer.getFactoryType("FALSE").getEqualSelectStrategy(STRATEGY_TEST_PARAMETER);
        multiple = StrategiesFactoryProducer.getFactoryType("TRUE").getMultipleSelectStrategy(STRATEGY_TEST_PARAMETER);
        notMultiple = StrategiesFactoryProducer.getFactoryType("FALSE").getMultipleSelectStrategy(STRATEGY_TEST_PARAMETER);
    }
    
    @BeforeEach
    void beforeEach(){
        list = new CircularListImpl();
    }

    @Test
    public void testAddSize(){
        addElements(0);

        Assertions.assertEquals(1,list.size());
    }

    @Test
    public void testIsEmpty(){
        Assertions.assertTrue(list.isEmpty());

        addElements(0);

        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    public void testNextOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next());
    }

    @Test
    public void testNextOnFirst(){
        addElements(0);

        Assertions.assertEquals(Optional.of(0),list.next());

    }

    @Test
    public void testNextOnLast(){
        addElements(0, 1);

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
        addElements(0, 1);

        Assertions.assertEquals(Optional.of(1),list.previous());
    }

    @Test
    public void testPreviousOnOneValue(){
        addElements(0);

        Assertions.assertEquals(Optional.of(0),list.previous());
    }

    @Test
    public void testBothDirectionListIteration(){
        addElements(0, 1, 2, 3);

        Assertions.assertEquals(Optional.of(0),list.next());
        Assertions.assertEquals(Optional.of(3),list.previous());
        Assertions.assertEquals(Optional.of(2),list.previous());
        Assertions.assertEquals(Optional.of(1),list.previous());
        Assertions.assertEquals(Optional.of(2),list.next());
    }

    @Test
    public void testReset(){
        addElements(0, 1);

        Assertions.assertEquals(Optional.of(0),list.next());

        list.reset();

        Assertions.assertEquals(Optional.of(0),list.next());
    }

    @Test
    public void testEvenStrategyOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next(even));
    }

    @Test
    public void testMultipleOfStrategyOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next(multiple));
    }

    @Test
    public void testEqualsStrategyOnEmpty(){
        Assertions.assertEquals(Optional.empty(),list.next(equal));
    }

    @Test
    public void testEvenStrategy(){
        addElements(1, 1, 2, 4, 1);

        Assertions.assertEquals(Optional.of(2),list.next(even));
        Assertions.assertEquals(Optional.of(4),list.next(even));
        Assertions.assertEquals(Optional.of(2),list.next(even));
    }

    @Test
    public void testEvenStrategyNoMatch(){
        addElements(1, 3, 5, 5, 5);

        Assertions.assertEquals(Optional.empty(),list.next(even));
        Assertions.assertEquals(Optional.of(1),list.next());
        Assertions.assertEquals(Optional.empty(),list.next(even));
        Assertions.assertEquals(Optional.of(3),list.next());
    }

    @Test
    public void testMultipleOfStrategy(){
        addElements(1, 1, 3, 1, 9);

        Assertions.assertEquals(Optional.of(3),list.next(multiple));
        Assertions.assertEquals(Optional.of(9),list.next(multiple));
        Assertions.assertEquals(Optional.of(3),list.next(multiple));
    }

    @Test
    public void testMultipleOfStrategyNoMatch(){
        addElements(1, 5, 2);

        Assertions.assertEquals(Optional.of(1),list.next());
        Assertions.assertEquals(Optional.empty(),list.next(multiple));
        Assertions.assertEquals(Optional.of(5),list.next());
    }

    @Test
    public void testEqualsStrategy(){
        addElements(1, 1, 3, 5, 3);

        Assertions.assertEquals(Optional.of(3),list.next(equal));
        Assertions.assertEquals(Optional.of(3),list.next(equal));
        Assertions.assertEquals(Optional.of(3),list.next(equal));
    }

    @Test
    public void testEqualsStrategyNoMatch(){
        addElements(1, 5, 2);

        Assertions.assertEquals(Optional.of(1),list.next());
        Assertions.assertEquals(Optional.empty(),list.next(equal));
        Assertions.assertEquals(Optional.of(5),list.next());
    }

    @Test
    public void testOddStrategy(){
        addElements(1, 3, 2, 4, 5);

        Assertions.assertEquals(Optional.of(1),list.next(odd));
        Assertions.assertEquals(Optional.of(3),list.next(odd));
        Assertions.assertEquals(Optional.of(5),list.next(odd));
    }

    @Test
    public void testNotMultipleOfStrategy(){
        addElements(1, 4, 3, 6, 9);

        Assertions.assertEquals(Optional.of(1),list.next(notMultiple));
        Assertions.assertEquals(Optional.of(4),list.next(notMultiple));
        Assertions.assertEquals(Optional.of(1),list.next(notMultiple));
    }

    @Test
    public void testUnequalsStrategy(){
        addElements(1, 1, 3, 5, 3);

        Assertions.assertEquals(Optional.of(1),list.next(unequal));
        Assertions.assertEquals(Optional.of(1),list.next(unequal));
        Assertions.assertEquals(Optional.of(5),list.next(unequal));
    }

    private void addElements(int ... values){
        for (int i = 0; i < values.length; i++){
            list.add(values[i]);
        }
    }
}
