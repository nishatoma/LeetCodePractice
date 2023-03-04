package twopointers;

public class LC556 {
    public int nextGreaterElement(int n) {
        // Same as next permutation, just need to convert the
        // number to an array...
        String str = Integer.toString(n);
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = str.charAt(i) - '0';
        }
        // Now do same thing as before,
        // 1) Find first non-increasing element from right
        int pivot = findFirstNonIncreasingIndex(arr);
        // If the pivot is -1, then the whole thing can be reversed
        if (pivot < 0) {
            return pivot;
        }
        // 2) Otherwise, find next greater element with the right most
        // index
        int next = findNextGreaterRightMostIndex(arr, pivot);
        // 4) Now, swap the two numbers
        swap(arr, pivot, next);
        // 5) reverse the arr from pivot + 1
        reverse(arr, pivot + 1);
        // print numbers
        for (int x : arr) {
            System.out.print(x + " ");
        }
        // Return result
        return arrToNum(arr);
    }

    int arrToNum(int[] arr) {
        int digit = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (digit > (Integer.MAX_VALUE - arr[i]) / 10) {
                return -1;
            }
            digit = 10 * digit + arr[i];
        }
        return digit;
    }

    private int findFirstNonIncreasingIndex(int[] arr) {
        for (int i = arr.length - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private int findNextGreaterRightMostIndex(int[] arr, int pivot) {
        for (int i = arr.length - 1; i > pivot; --i) {
            if (arr[i] > arr[pivot]) {
                return i;
            }
        }
        return -1;
    }

    private void reverse(int[] arr, int lo) {
        int hi = arr.length - 1;
        while (lo < hi) {
            swap(arr, lo, hi);
            ++lo;
            --hi;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
