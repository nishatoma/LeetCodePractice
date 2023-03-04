package twopointers;

public class LC31 {
    public void nextPermutation(int[] arr) {
        // Step 1: find first non-increasing number
        // from right
        int n = arr.length - 1;
        int pivot = getFirstNonIncreasingIndex(arr);
        // Check edge case, this is the last permutation
        if (pivot == -1) {
            reverse(arr, 0);
            return;
        }
        // Otherwise, find the next greater, and right-most element
        // from the element at pivot
        int next = findNextGreaterIndex(arr, pivot);
        // Swap both elements
        swap(arr, pivot, next);
        // Reverse the suffix after the pivot
        reverse(arr, pivot + 1);
    }

    private int findNextGreaterIndex(int[] arr, int pivot) {
        for (int i = arr.length - 1; i > pivot; --i) {
            if (arr[pivot] < arr[i]) {
                return i;
            }
        }
        return -1;
    }

    private int getFirstNonIncreasingIndex(int[] arr) {
        for (int i = arr.length - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        // If this is the last permutation,
        // Then the entire array is increasing from right to left.
        return -1;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int lo) {
        int hi = arr.length - 1;
        while (lo < hi) {
            swap(arr, lo, hi);
            ++lo;
            --hi;
        }
    }
}
