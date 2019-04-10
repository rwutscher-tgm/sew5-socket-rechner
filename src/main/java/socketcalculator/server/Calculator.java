package socketcalculator.server;

import java.util.Arrays;

public class Calculator {

    public Calculator(){

    }

    public String calculate(String cmd){
        String[] values = Arrays.copyOfRange(cmd.split(" "), 1, cmd.split(" ").length);
        switch(cmd.split(" ")[0]){
            case "!add": {
                return add(values);
            }
            default: {
                return "The requested function is not available";
            }
        }
    }

    private String add(String[] values){
        double result = 0;

        for(String value: values){
            result += Integer.parseInt(value);
        }

        return result+"";
    }
}