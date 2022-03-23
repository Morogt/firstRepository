import java.util.Scanner;

public class Calculator {
    public static String operator;
    private static int num1;
    private static int num2;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputNumber = scanner.nextLine();
        definingNumbers(inputNumber);
        System.out.println(process());
    }

    private static void definingNumbers(String number) throws Exception {
        String[] arrayExpression = number.split(" ");
        if (arrayExpression.length > 3) {
            throw new Exception("Формат математической операции " +
                    "не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        try {
            operator = arrayExpression[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Строка не является математической операцией");
        }
        getNum(arrayExpression);
    }

    private static void getNum(String[] arrayExpression) throws Exception {
        try {
            num1 = Integer.parseInt(arrayExpression[0]);
            num2 = Integer.parseInt(arrayExpression[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Строка не является математической операцией");
        } catch (NumberFormatException e) {
            Translation translation = new Translation();
            translation.translation(arrayExpression);
            System.exit(1);
        }
    }

    private static int process() {
        switch (operator) {
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
}