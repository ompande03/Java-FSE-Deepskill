package com.financial.forecasting;

public class FinancialForecast {

    // Recursive method to calculate future investment value
    public static double calculateFutureValue(double currentAmount, double annualGrowthRate, int remainingYears) {
        if (remainingYears == 0) {
            return currentAmount; // Base case: no more years left
        }
        // Recursive step: grow the amount and decrease the year count
        return calculateFutureValue(currentAmount * (1 + annualGrowthRate), annualGrowthRate, remainingYears - 1);
    }

    public static void main(String[] args) {
        // Initial investment amount
        double initialInvestment = 1000.0;

        // Annual growth rate (e.g., 10% as 0.10)
        double rateOfGrowth = 0.10;

        // Investment duration in years
        int investmentDuration = 5;

        // Calculate future value using the recursive method
        double projectedValue = calculateFutureValue(initialInvestment, rateOfGrowth, investmentDuration);

        // Display the result formatted to 2 decimal places
        System.out.printf("Future value after %d years: %.2f%n", investmentDuration, projectedValue);
    }
}
