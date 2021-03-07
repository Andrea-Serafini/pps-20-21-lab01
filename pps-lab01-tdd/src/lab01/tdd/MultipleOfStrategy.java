package lab01.tdd;
/**
 * Strategy returning true if the element is multiple of a given number
 */
public class MultipleOfStrategy implements SelectStrategy{

    private int parameter;

    public MultipleOfStrategy(int parameter) {

        this.parameter = parameter;
    }

    @Override
    public boolean apply(int element) {
        return false;
    }
}
