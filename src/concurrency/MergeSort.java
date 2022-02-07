package concurrency;

import java.util.Arrays;

public class MergeSort {

    private static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        // make copy arrays for left and right side
        int[] L = new int[n1];
        int[] R = new int[n2];

        // fill left and right side
        for (int i = 0; i < n1; ++i) {
            L[i] = a[i + l];
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = a[m + 1 + j];
        }

        // Fill the original array
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }

// clear up the remainders
        while (i < n1) {
            a[k++] = L[i++];
        }

        while(j < n2) {
            a[k++] = R[j++];
        }
    }
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {

        int[] a = new int[]{1, 0, 5, 6, 6, 7, 2, 4};


        sort(a);

        Arrays.stream(a).forEach(System.out::println);
    }

}
