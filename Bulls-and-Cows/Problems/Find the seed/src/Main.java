import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[b - a + 1];

        for (int i = a; i <= b; i++) {
            Random random = new Random(i);
            int max = 0;
            for (int j = 0; j < n; j++) {
                int z = random.nextInt(k);
                if (max < z) {
                    max = z;
                }
            }
            array[i - a] = max;
        }

        int min = array[0];
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                index = i + a;
            }
        }

        System.out.println(index);
        System.out.println(min);
    }
}
