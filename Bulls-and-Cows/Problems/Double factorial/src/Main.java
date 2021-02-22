import java.math.BigInteger;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) { ;
        BigInteger result = BigInteger.ONE;

        while (n > 0) {
            result = result.multiply(BigInteger.valueOf(n));
            n -= 2;
        }
        return result;
    }
}