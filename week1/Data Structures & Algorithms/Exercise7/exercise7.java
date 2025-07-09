public class FinancialForecasting {

    // 3. Implementation: Recursive method
    // Predict future value using: FV = PV * (1 + rate)^n
    public static double forecastValue(double presentValue, double rate, int years) {
        if (years == 0) return presentValue;
        return forecastValue(presentValue * (1 + rate), rate, years - 1);
    }

    // Optimized version using memoization (optional, useful if overlapping subproblems)
    public static double forecastValueOptimized(double presentValue, double rate, int years, double[] memo) {
        if (years == 0) return presentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastValueOptimized(presentValue, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double presentValue = 10000; // Initial investment
        double rate = 0.05; // 5% annual growth
        int years = 10;

        double futureValue = forecastValue(presentValue, rate, years);
        System.out.printf("\nRecursive Forecast: Value after %d years = %.2f\n", years, futureValue);

        double[] memo = new double[years + 1];
        double optimizedValue = forecastValueOptimized(presentValue, rate, years, memo);
        System.out.printf("Memoized Forecast: Value after %d years = %.2f\n", years, optimizedValue);
    }
}