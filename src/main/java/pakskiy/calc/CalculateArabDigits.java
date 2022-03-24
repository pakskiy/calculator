package pakskiy.calc;

import pakskiy.validate.Validator;

public class CalculateArabDigits extends CalculateAbstract {
    public CalculateArabDigits(String expression) {
        print(parse(expression));
    }

    @Override
    int plus(int a, int b) {
        return super.plus(a, b);
    }

    @Override
    int minus(int a, int b) {
        return super.minus(a, b);
    }

    @Override
    int divide(int a, int b) {
        return super.divide(a, b);
    }

    @Override
    int multiply(int a, int b) {
        return super.multiply(a, b);
    }

    private int parse(String val){
        if(val.contains("+")){
            return plus(Validator.validDigit(Integer.parseInt(val.split("\\+")[0].trim())), Validator.validDigit(Integer.parseInt(val.split("\\+")[1].trim())));
        }
        if(val.contains("-")){
            return minus(Validator.validDigit(Integer.parseInt(val.split("-")[0].trim())), Validator.validDigit(Integer.parseInt(val.split("-")[1].trim())));
        }
        if(val.contains("/")){
            return divide(Validator.validDigit(Integer.parseInt(val.split("/")[0].trim())), Validator.validDigit(Integer.parseInt(val.split("/")[1].trim())));
        }
        if(val.contains("*")){
            return multiply(Validator.validDigit(Integer.parseInt(val.split("\\*")[0].trim())), Validator.validDigit(Integer.parseInt(val.split("\\*")[1].trim())));
        }
        throw new IllegalArgumentException();
    }
}