package binarysearch;

import java.util.Arrays;

public class FindDistanceValueBetweenTwoArrays_1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;

        Arrays.sort(arr2);

        return solve(arr1, arr2, d);
    }

    static int solve(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int num : arr1) {
            if (doesDistanceExist(arr2, num, d)) {
                res++;
            }
        }

        return res;
    }

    static boolean doesDistanceExist(int[] arr, int num, int d) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (num - d <= arr[mid] && arr[mid] <= num + d) {
                return false;
            } else if (arr[mid] < num - d) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return true;
    }
}
