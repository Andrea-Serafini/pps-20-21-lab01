package lab01.tdd;
/**
 * Strategy returning true if the element is equal to a given number
 */
public class UnequalsStrategy implements SelectStrategy{

    private int parameter;

    public UnequalsStrategy(int parameter) {

        this.parameter = parameter;
    }

    @Override
    public boolean apply(int element) {
        if (element != parameter){
            return true;
        } else {
            return false;
        }
    }
}
