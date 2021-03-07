package lab01.tdd;

public class TrueStrategiesFactory implements AbstractStrategyFactory{

    @Override
    public SelectStrategy getEqualSelectStrategy(int parameter) {
        return new EqualsStrategy(parameter);
    }

    @Override
    public SelectStrategy getMultipleSelectStrategy(int parameter) {
        return new MultipleOfStrategy(parameter);
    }

    @Override
    public SelectStrategy getEvenSelectStrategy() {
        return new EvenStrategy();
    }
}
