package lab01.tdd;

public class StrategiesFactoryProducer {
    public static AbstractStrategyFactory getFactoryType(String factoryType){
        switch(factoryType)
        {
            case "TRUE": return new TrueStrategiesFactory();
            case "FALSE": return new FalseStrategiesFactory();
        }
        return null;
    }

}
