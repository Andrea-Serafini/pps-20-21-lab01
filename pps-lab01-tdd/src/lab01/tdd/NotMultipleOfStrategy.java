package lab01.tdd;
/**
 * Strategy returning true if the element is multiple of a given number
 */
public class NotMultipleOfStrategy implements SelectStrategy{

    private int parameter;

    public NotMultipleOfStrategy(int parameter) {

        this.parameter = parameter;
    }

    @Override
    public boolean apply(int element) {
        if (element % parameter != 0){
            return true;
        } else {
            return false;
        }
    }
}
