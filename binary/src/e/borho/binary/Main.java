package e.borho.binary;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static StringFrame stringFrame = new StringFrame();

    private static Calculator.calcChoice choice;
    private static char[] basis;
    private static long result;

    private static int[] combination = new int[2];

    public static void main(String[] args) {
        stringFrame.setTextFieldActionListener(actionEvent -> {
            basis = stringFrame.getTextFieldText().toCharArray();
            System.out.println("basis: " + String.valueOf(basis));

            chooseClaculation();
        });
        stringFrame.show();
    }

    private static void calculateResult(){
        Calculator calculator = new Calculator();
        calculator.a = combination[0];
        calculator.b = combination[1];

        if(choice == Calculator.calcChoice.add){
            result = (int) calculator.add();
        }
        if(choice == Calculator.calcChoice.subtract){
            result = (int) calculator.subtract();
        }
        if(choice == Calculator.calcChoice.multiplicate){
            result = (int) calculator.multiplicate();
        }

        stringFrame.setTextFieldVisible(false);
        System.out.println("result: " + result);
        System.out.println(longToBinary(result));
        stringFrame.setBasisFieldText("result: " + longToBinary(result));
    }

    private static void getCombinations(int index) {
        stringFrame.exit();
        stringFrame = null;
        stringFrame = new StringFrame();
        stringFrame.setBasisFieldText(index + ". combination");

        stringFrame.setTextFieldActionListener(actionEvent -> {
            combination[index - 1] = binaryToInt(stringFrame.getTextFieldText());

            if(index < 2){
                getCombinations(2);
            }

            if(index == 2){
                calculateResult();
            }
        });
        stringFrame.show();
    }

    private static void chooseClaculation(){
        final ChoiceFrame choiceFrame = new ChoiceFrame();
        choiceFrame.setActionListener(actionEvent -> {
            choiceFrame.exit();
            JButton button = (JButton) actionEvent.getSource();
            choice = choiceFrame.getChoice(button.getText());

            getCombinations(1);
        });
        choiceFrame.show();
    }

    private static int binaryToInt(String binary){
        System.out.println("bin: " + binary);
        long[] singleNumbers = new long[binary.length()];
        int thisResult = 0;
        int x = 0;

        System.out.print("numbers: ");
        for(int i = binary.length() - 1; i >= 0; i--){
            singleNumbers[i] = getPlaceNumber(x) * charToInt(binary.charAt(i));
            System.out.print(singleNumbers[i] + "(" + binary.charAt(i) + ": " + charToInt(binary.charAt(i)) + "),");
            x++;
        }
        System.out.println("\b");

        for(long number : singleNumbers){
            thisResult += number;
        }

        System.out.println("comb: " + thisResult);

        return thisResult;
    }

    private static String longToBinary(long result){
        ArrayList<Character> binar = new ArrayList<>();
        int maxCharIndex;
        int currentNumber = 0;

        int i = 0;
        while(getPlaceNumber(i) < result){
            i++;
        }
        maxCharIndex = i - 1;

        long number;
        for(int x = maxCharIndex; x >= 0; x--){
            int times = 0;
            do{
                number = getPlaceNumber(x) * times;

                if(number + currentNumber < result){
                    times++;
                }

                if(number + currentNumber > result){
                    times--;
                }
            }while(currentNumber + number < result);

            currentNumber += getPlaceNumber(x) * times;
            binar.add(basis[times]);
        }

        return binar.toString();
    }

    private static int charToInt(char binaryChar){
        for(int i = 0; i < basis.length; i++){
            if(basis[i] == binaryChar){
                return i;
            }
        }

        return 0;
    }

    private static long getPlaceNumber(int index){
        long placeNumber = 1;

        if(index > 0) {
            for (int i = 0; i < index; i++) {
                placeNumber *= basis.length;
            }
        }

        return placeNumber;
    }
}
