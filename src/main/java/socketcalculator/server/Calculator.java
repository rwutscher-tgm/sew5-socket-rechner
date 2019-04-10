package socketcalculator.server;

import socketcalculator.server.calculationstrategies.*;
import java.util.Arrays;

public class Calculator {

    private int credits;
    
    public Calculator(){
        this.credits = 10;
    }

    public String calculate(String cmd){
        String[] values = Arrays.copyOfRange(cmd.split(" "), 1, cmd.split(" ").length);
        CalculationMethod method;
        this.credits -= 1;

        switch(cmd.split(" ")[0]){
            case "!add": {
                method = new CalculationMethod(new Add());
                break;
            }
            default: {
                this.credits += 1;
                return "The requested function is not available";
            }
        }

        if(this.credits > 0){
            return method.calculate(values);
        }else{
            return "Not enough credits";
        }
    }
}