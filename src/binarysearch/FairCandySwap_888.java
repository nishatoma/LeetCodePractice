package binarysearch;

import java.util.Arrays;

public class FairCandySwap_888 {

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sA = 0, sB = 0;

        for (int b : bobSizes) {
            sB += b;
        }

        for (int a : aliceSizes) {
            sA += a;
        }

        Arrays.sort(aliceSizes);

        int diff = (sA - sB) / 2;

        for (int b : bobSizes) {
            if (bs(aliceSizes, b + diff) != -1) {
                return new int[]{b + diff, b};
            }
        }


        return new int[]{0};
    }

    static int bs(int[] a, int t) {


        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == t) {
                return mid;
            } else if (t > a[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
