package validating;

public class Calculator {

    public int factorial(int num) {

        if (num < 0) {
            throw new NumberFormatException("Factorial input number must be 0 or greater: " + num);
        }
        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {

        if (setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("Set and subset sizes can't be negative." );
        }

        if (subsetSize > setSize) {
            throw new IllegalArgumentException("Subset size can't be bigger than set size.");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
