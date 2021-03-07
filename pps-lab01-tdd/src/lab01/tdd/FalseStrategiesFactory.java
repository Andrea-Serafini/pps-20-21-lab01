package lab01.tdd;

public class FalseStrategiesFactory implements AbstractStrategyFactory{

    @Override
    public SelectStrategy getEqualSelectStrategy(int parameter) {
        return new UnequalsStrategy(parameter);
    }

    @Override
    public SelectStrategy getMultipleSelectStrategy(int parameter) {
        return new NotMultipleOfStrategy(parameter);
    }

    @Override
    public SelectStrategy getEvenSelectStrategy() {
        return new OddStrategy();
    }
}
