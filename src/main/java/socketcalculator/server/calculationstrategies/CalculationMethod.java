package socketcalculator.server.calculationstrategies;

public class CalculationMethod{

    private CalculationStrategy strategy;

    public CalculationMethod(CalculationStrategy strategy){
        this.strategy = strategy;
    }

    public String calculate(String[] values){
        return this.strategy.calculate(values);
    }

}