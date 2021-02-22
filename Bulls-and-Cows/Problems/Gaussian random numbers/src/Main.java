import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        double m = scanner.nextDouble();
        boolean toContinue = true;

        while (toContinue) {
            Random random = new Random(k);
            double j;
            for (int i = 0; i < n; i++) {
                j = random.nextGaussian();
                if (j > m) {
                    toContinue = true;
                    break;
                } else {
                    toContinue = false;
                }
            }
            k++;
        }

        System.out.println(k - 1);
    }
}