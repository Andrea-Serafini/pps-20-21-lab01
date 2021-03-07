package lab01.tdd;
/**
 * Strategy returning true if the element is equal to a given number
 */
public class EqualsStrategy implements SelectStrategy{

    private int parameter;

    public EqualsStrategy(int parameter) {

        this.parameter = parameter;
    }

    @Override
    public boolean apply(int element) {
        return false;
    }
}
