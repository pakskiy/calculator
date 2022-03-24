package pakskiy.validate;

public class Validator {
    public static boolean validString(String expression){
        if(!checkStart(expression) || !checkEnd(expression) || !checkEntry(expression)){
            return false;
        }
        return true;
    }

    public static int validDigit(int expression){
        try {
            int val = Integer.valueOf(expression);
            if(val>10 || val<1){
                throw new NumberFormatException();
            } else {
                return val;
            }
        } catch (Exception e){
            throw new NumberFormatException();
        }
    }

    private static boolean checkStart(String expression){
        if (expression.startsWith("+")) {return false;}
        if (expression.startsWith("-")) {return false;}
        if (expression.startsWith("*")) {return false;}
        if (expression.startsWith("/")) {return false;}
        return true;
    }

    private static boolean checkEnd(String expression){
        if (expression.endsWith("+")) {return false;}
        if (expression.endsWith("-")) {return false;}
        if (expression.endsWith("*")) {return false;}
        if (expression.endsWith("/")) {return false;}
        return true;
    }

    private static boolean checkEntry(String expression){
        if (expression.chars().filter(ch -> ch == '+').count()>1) {return false;}
        if (expression.chars().filter(ch -> ch == '-').count()>1) {return false;}
        if (expression.chars().filter(ch -> ch == '*').count()>1) {return false;}
        if (expression.chars().filter(ch -> ch == '/').count()>1) {return false;}
        return true;
    }
}