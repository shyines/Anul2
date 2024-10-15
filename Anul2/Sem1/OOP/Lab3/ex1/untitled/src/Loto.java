import java.math.BigDecimal;

public class Loto {

    private static BigDecimal factorial (int factori) {
        BigDecimal result = BigDecimal.ONE;
        for(int i = 0;i < factori; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }

        return result;
    }


    private BigDecimal calculateCombination(int n, int k) {
        BigDecimal nFactorial = factorial(n);
        BigDecimal kFactorial = factorial(k);
        BigDecimal _factorial = factorial(n - k);
        _factorial = _factorial.multiply(kFactorial);


        return nFactorial.divide(_factorial);
    }
}
