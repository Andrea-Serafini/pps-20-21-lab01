package lab01.tdd;
/**
 * Strategy returning true if the element is even
 */
public class EvenStrategy implements SelectStrategy{

    @Override
    public boolean apply(int element) {
        if(element % 2 == 0){
            return true;
        } else {
            return false;
        }
    }
}
