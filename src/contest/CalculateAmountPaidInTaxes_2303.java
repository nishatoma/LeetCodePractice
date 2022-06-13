package contest;

public class CalculateAmountPaidInTaxes_2303 {

    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int prev = 0;
        for (int i = 0; i < brackets.length; ++i) {
            int upper = brackets[i][0];
            double tax = brackets[i][1] / 100.0;
            res += Math.max(0.0, (Math.min(income, upper) - prev) * tax);
            prev = upper;
        }
        return res;
    }
}
