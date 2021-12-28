package binarysearch;

public class FindSmallestLetterGreaterThanTarget_744 {

    public char nextGreatestLetter(char[] letters, char target) {

        int lo = 0;
        int hi = letters.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target >= letters[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return letters.length == lo ? letters[0] : letters[lo];
    }
}
