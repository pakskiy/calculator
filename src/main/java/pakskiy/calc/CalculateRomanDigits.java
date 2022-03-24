package pakskiy.calc;

import pakskiy.validate.Validator;

public class CalculateRomanDigits extends CalculateAbstract {
    public CalculateRomanDigits(String expression) {
        print(encode(parse(expression)));
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
            return plus(Validator.validDigit(decode(val.split("\\+")[0].trim())), Validator.validDigit(decode(val.split("\\+")[1].trim())));
        }
        if(val.contains("-")){
            return minus(Validator.validDigit(decode(val.split("-")[0].trim())), Validator.validDigit(decode(val.split("-")[1].trim())));
        }
        if(val.contains("/")){
            return divide(Validator.validDigit(decode(val.split("/")[0].trim())), Validator.validDigit(decode(val.split("/")[1].trim())));
        }
        if(val.contains("*")){
            return multiply(Validator.validDigit(decode(val.split("\\*")[0].trim())), Validator.validDigit(decode(val.split("\\*")[1].trim())));
        }
        throw new IllegalArgumentException();
    }

    private int decode(String val){
        switch (val){
            case "I":   return 1;
            case "II":  return 2;
            case "III": return 3;
            case "IV":  return 4;
            case "V":   return 5;
            case "VI":  return 6;
            case "VII": return 7;
            case "VIII":return 8;
            case "IX":  return 9;
            case "X":   return 10;
            default:    throw new NumberFormatException();
        }
    }

    private String encode(int val) {
        if(val<=0){
            throw new NumberFormatException();
        }

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(val >= values[i]) {
                val -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}