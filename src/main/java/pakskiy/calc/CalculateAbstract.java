package pakskiy.calc;

abstract class CalculateAbstract {
    int plus(int a, int b){
        return a + b;
    }

    int minus(int a, int b){
        return a - b;
    }

    int divide(int a, int b){
        if(b==0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    }

    int multiply(int a, int b){
        return a * b;
    }

    void print(Object result){
        System.out.println(result);
    }
}