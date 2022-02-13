public class FuzzyDuck {

    public static void main(String[] args) {

        int doesHeCount = 0;
        boolean fuzzyDuck = true;
        boolean doesHeCalled = false;
        for (int i = 1; i <= 10; ++i) {

            for (int j = 1; j <= 10; j++) {
                doesHeCount++;
                if ((doesHeCount) % 15 == 0) {
                    doesHeCount = 0;
                    fuzzyDuck = !fuzzyDuck;
                    doesHeCalled = !doesHeCalled;
                    System.out.println(j + " Does He?");
                } else {
                    if (!fuzzyDuck) {
                        if (doesHeCalled) {
                            if (j == 10) {
                                System.out.println(j + " Ducky Fuzz");
                            } else {
                                System.out.println(10 - j + " Ducky Fuzz");
                            }

                        } else {
                            System.out.println(j + " Ducky Fuzz");
                        }

                    } else {
                        if (doesHeCalled) {
                            if (j == 10) {
                                System.out.println(j + " Fuzzy Duck");
                            } else {
                                System.out.println(10 - j + " Fuzzy Duck");
                            }
                        } else {
                            System.out.println(j + " Fuzzy Duck");
                        }
                    }
                }
                fuzzyDuck = !fuzzyDuck;
            }

        }
    }
}
