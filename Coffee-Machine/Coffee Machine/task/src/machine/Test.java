package machine;

public class Test {
    public static void main(String[] args) {
        int k = 0;
        for (Secret sec : Secret.values()) {
            if (sec.toString().startsWith("STAR")) {
                k++;
            }
        }

        System.out.println(k);
    }

    enum Secret {
        FIRST, STAR, START;
    }
}
