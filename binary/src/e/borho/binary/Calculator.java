package e.borho.binary;

public class Calculator {
    public enum calcChoice{
        add, subtract,  multiplicate
    }

    public static String[] choices = {"add", "subtract", "multiplicate"};

    public float a = 0;
    public float b = 0;

    public float multiplicate(){
        return a * b;
    }

    public float add(){
        return a + b;
    }

    public float subtract(){
        return a - b;
    }

    public float divide(){
        return a / b;
    }
}
