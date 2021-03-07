package lab01.tdd;

public interface AbstractStrategyFactory {
    SelectStrategy getEqualSelectStrategy(int parameter);
    public SelectStrategy getMultipleSelectStrategy(int parameter);
    public SelectStrategy getEvenSelectStrategy();
}
