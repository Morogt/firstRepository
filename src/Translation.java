import java.util.HashMap;
import java.util.Map;

public class Translation {

    static Map<String, Integer> translatorArray = new HashMap<>();
    static Map<Integer, String> reverseTranslatorArray = new HashMap<>();

    public void translation(String[] arrayExpression) throws Exception {
        reverseTranslatorArray.put(1, "I");
        reverseTranslatorArray.put(2, "II");
        reverseTranslatorArray.put(3, "III");
        reverseTranslatorArray.put(4, "IV");
        reverseTranslatorArray.put(5, "V");
        reverseTranslatorArray.put(6, "VI");
        reverseTranslatorArray.put(7, "VII");
        reverseTranslatorArray.put(8, "VIII");
        reverseTranslatorArray.put(9, "IX");
        reverseTranslatorArray.put(10, "X");
        reverseTranslatorArray.put(20, "XX");
        reverseTranslatorArray.put(30, "XXX");
        reverseTranslatorArray.put(40, "XL");
        reverseTranslatorArray.put(50, "L");
        reverseTranslatorArray.put(60, "LX");
        reverseTranslatorArray.put(70, "LXX");
        reverseTranslatorArray.put(80, "LXXX");
        reverseTranslatorArray.put(90, "XC");
        reverseTranslatorArray.put(100, "C");

        translatorArray.put("I", 1);
        translatorArray.put("II", 2);
        translatorArray.put("III", 3);
        translatorArray.put("IV", 4);
        translatorArray.put("VI", 6);
        translatorArray.put("V", 5);
        translatorArray.put("VII", 7);
        translatorArray.put("VIII", 8);
        translatorArray.put("IX", 9);
        translatorArray.put("X", 10);

        int num1 = getTranslatorNumber(arrayExpression[0]);
        int num2 = getTranslatorNumber(arrayExpression[2]);

        if (Calculator.operator.equals("-") && num1 < num2) {
            throw new Exception("В римской системе нет отрицательных чисел");
        }
        printResult(process(num1, num2));

    }

    public int getTranslatorNumber(String string) throws Exception {
        try {
            return translatorArray.get(string);
        } catch (Throwable e) {
            throw new Exception("Используются одновременно разные системы счисления или введены" +
                    " некорректные данные");
        }
    }

    public static int process(int num1, int num2) {
        switch (Calculator.operator) {
            case "*":
                return num1 * num2;
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    private void printResult (int result) {
        String outcome = "";
        int hundreds = (result / 100) % 10;
        int tens = (result / 10) % 10;
        int numbers = result % 10;

        if (hundreds == 1) {
            System.out.println(reverseTranslatorArray.get(100));
            System.exit(1);
        }
        if (tens >= 1) {
            outcome += reverseTranslatorArray.get(tens * 10);
        }
        if (numbers >= 1) {
            outcome += reverseTranslatorArray.get(numbers);
        }
        if (numbers == 0 && tens == 0 && hundreds == 0) {
            outcome = "0";
        }

        System.out.println(outcome);
    }
}