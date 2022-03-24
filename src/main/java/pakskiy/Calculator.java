package pakskiy;

import pakskiy.calc.CalculateArabDigits;
import pakskiy.calc.CalculateRomanDigits;
import pakskiy.validate.Validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Calculator {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isOnline = true;

        while (isOnline){
            try {
                System.out.println("Input:");
                String s = reader.readLine();

                if(s.equals("EXIT")){
                    isOnline = false;
                } else {
                    if(!Validator.validString(s)){
                        isOnline = false;
                        throw new IllegalArgumentException("WRONG FORMAT");
                    }
                    if(Pattern.compile("[IVX\\+\\-\\/\\*]+").matcher(s).matches()) {
                        try {
                            new CalculateRomanDigits(s);
                        }catch (Exception e){
                            isOnline = false;
                            System.out.println("Exception " + e);
                        }
                    }else if (Pattern.compile("[0-9\\+\\-\\/\\*]+").matcher(s).matches()){
                        try {
                            new CalculateArabDigits(s);
                        }catch (Exception e){
                            isOnline = false;
                            System.out.println("Exception " + e);
                        }
                    } else {
                        isOnline = false;
                        throw new IllegalArgumentException("WRONG FORMAT");
                    }
                }
            }catch (Exception e){
                System.out.println("Exception " + e);
            }
        }
        System.out.println("Calculator stop work");
    }
}