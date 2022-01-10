package binarysearch;

public class FindInMountainArray_1095 {

    public int findInMountainArray(int target, int[] mountainArr) {

        // Step 1, find the peak of the array i.e the mountain index.
        int s = 0;
        int e = mountainArr.length - 2;


        while (s <= e) {
            int m = s + (e - s) / 2;

            if (mountainArr[m] > mountainArr[m + 1]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        // s is peak mountain array index!!

        int first = search(target, mountainArr, 0, s);
        int second = search(target, mountainArr, s + 1, mountainArr.length - 1);

        if (first == -1 && second == -1) {
            return -1;
        }

        if (first == -1) {
            return second;
        }

        if (second == -1) {
            return first;
        }

        return Math.min(first, second);

    }

    static int search(int target, int[] mountainArr, int s, int e) {

        int res = -1;

        boolean asc = mountainArr[s] < mountainArr[e];

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (mountainArr[m] == target) {
                res = m;
            }

            if (asc) {
                if (mountainArr[m] > target) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else {
                if (mountainArr[m] < target) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }
        }
        return res;
    }
}
