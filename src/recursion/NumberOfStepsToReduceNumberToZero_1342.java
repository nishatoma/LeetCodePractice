package recursion;

class NumberOfStepsToReduceNumberToZero_1342 {
    public int numberOfSteps(int num) {

        if (num == 0) {
            return 0;
        }

        if ((num & 1) == 0) {
            // even
            return 1 + numberOfSteps(num / 2);
        }
        return 1 + numberOfSteps(num - 1);
    }
}
