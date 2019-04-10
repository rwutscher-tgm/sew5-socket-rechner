package socketcalculator.server.calculationstrategies;

public class Add implements CalculationStrategy{

    public String calculate(String[] values){
        double result = 0;

        for(String value: values){
            result += Integer.parseInt(value);
        }

        return result+"";
    }
}