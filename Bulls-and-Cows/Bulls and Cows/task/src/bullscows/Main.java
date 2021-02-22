package bullscows;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // инициализация сканнера
        final Scanner scanner = new Scanner(System.in);

        try {
            // в блоке try выполняется программа, могут возникать исключительные ситуции
            // которые являются подклассом IllegalArgumentException
            System.out.println("Please, enter the secret code's length:");
            int sizeOfNumber = Integer.parseInt(scanner.next());
            System.out.println("Input the number of possible symbols in the code:");
            int quantityOfUnique = Integer.parseInt(scanner.next());
            if (sizeOfNumber > 36 || sizeOfNumber < 1 || (sizeOfNumber > quantityOfUnique) || (quantityOfUnique > 36)) {
                throw new IllegalArgumentException("Error");
            }

            // если программа прошла, то генерируем код
            String secret = generateSecret(sizeOfNumber, quantityOfUnique);
            String input;
            int k = 1;

            // печать якобы скрытого кода звездочками
            String pseudoSecret = "*".repeat(sizeOfNumber);
            char finishingChar = (char) (96 + quantityOfUnique - 10);

            System.out.printf("The secret is prepared: %s (0-9, a-%c).\n", pseudoSecret, finishingChar);
            System.out.println("Okay, let's start a game!");

            System.out.println(secret);
            do {
                System.out.printf("Turn %d:\n", k);
                input = scanner.next();
                Pair res = checkBullsAndCows(secret, input);
                printResult(res);
                k++;
            } while (!input.equals(secret));

            System.out.println("Congratulations! You guessed the secret code.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error");
        }
    }

    // метод генерации кода, который использует в себе вспомогательные методы вроде генерации списка
    static String generateSecret(int sizeOfNumber, int quantityOfUnique) {
        StringBuilder code = new StringBuilder();
        char[] array = generateArray(quantityOfUnique);

        while (code.length() != sizeOfNumber) {
            int c = (int) (Math.floor(Math.random() * quantityOfUnique));
            if (code.indexOf(String.valueOf(array[c])) == -1) {
                code.append(array[c]);
            }
        }
        return String.valueOf(code);
    }

    // генерация списка уникальных символов, берется срез от списка всех символов (допустимых)
    static char[] generateArray(int quantityOfUnique) {
        char[] main = new char[36];

        // числа
        for (int i = 0; i < 10; i++) {
            main[i] = (char) (i + 48);
        }

        // буквы
        for (int i = 10; i < 36; i++) {
            main[i] = (char) (i + 87);
        }

        char[] array = new char[quantityOfUnique];

        for (int i = 0; i < quantityOfUnique; i++) {
            array[i] = main[i];
        }

        return array;
    }

    // проверка на быков и коров, возвращает кортеж значений соответственно
    static Pair checkBullsAndCows (String secret, String input) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == secret.charAt(i)) {
                bulls++;
            } else {
                if (secret.indexOf(input.charAt(i)) != -1) {
                    cows++;
                }
            }
        }
        return new Pair(bulls, cows);
    }

    // вывод результата
    static void printResult(Pair pair) {
        int bulls = pair.bulls;
        int cows = pair.cows;

        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else if (cows == 0) {
            System.out.printf("Grade: %d bull(s).\n", bulls);
        } else if (bulls == 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
        }
    }
}

// вспомогательный класс кортежа
class Pair {
    int bulls;
    int cows;

    public Pair(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }
}