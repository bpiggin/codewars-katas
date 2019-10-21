import java.math.BigInteger;

public class FibonacciNumbers {

    public static BigInteger fib(BigInteger n) {

        //For n = 0
        if (n.equals(BigInteger.ZERO)) return n;

        //Account for -ve n
        boolean positive = n.abs() == n;
        n = n.abs();

        //For n = 1, 2 (and -1,-2).
        if (n.equals(BigInteger.ONE)) return BigInteger.ONE;
        if (n.equals(BigInteger.TWO) && positive) return BigInteger.ONE;
        if (n.equals(BigInteger.TWO)) return BigInteger.ONE.negate();

        //Use Matrix Multiplication to find nth Fibonacci term.
        BigInteger[] QMatrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
        BigInteger result = calculateFibTerm(QMatrix, n.intValue())[1];

        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO) && !positive) {
            return result.negate();
        }
        return result;
    }

    //Performs O(Logn) using matrix exponentiation see here: https://kukuruku.co/post/the-nth-fibonacci-number-in-olog-n/
    private static BigInteger[] calculateFibTerm(BigInteger[] matrix, int n) {
        BigInteger[] QMatrix = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
        while (n != 0) {
            //Use exponentiation by squaring: https://en.wikipedia.org/wiki/Exponentiation_by_squaring
            if (n % 2 != 0) QMatrix = performMatrixMultiplication(QMatrix, matrix);
            n /= 2;
            matrix = performMatrixMultiplication(matrix, matrix);
        }
        return QMatrix;
    }

    //Multiply 2x2 matrices.
    private static BigInteger[] performMatrixMultiplication(BigInteger[] x, BigInteger[] y) {
        return new BigInteger[] {
                x[0].multiply(y[0]).add(x[1].multiply(y[2])),
                x[0].multiply(y[1]).add(x[1].multiply(y[3])),
                x[2].multiply(y[0]).add(x[3].multiply(y[2])),
                x[2].multiply(y[1]).add(x[3].multiply(y[3]))
        };
    }
}
