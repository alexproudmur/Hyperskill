import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentInput;

        do {
            currentInput = scanner.next();
            if ("0".equals(currentInput)) {
                break;
            }
            try {
                System.out.print("\n" + 10 * Integer.parseInt(currentInput));
            } catch (NumberFormatException e) {
                System.out.print("\nInvalid user input: " + currentInput);
            }
        } while (true);
    }
}