package twopointers;

public class LC1850 {
    public int getMinSwaps(String num, int k) {
        // Get num array
        int[] arr = new int[num.length()];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = num.charAt(i) - '0';
        }
        // Get kth
        int[] kth = getKth(arr, k);
        // Count swaps
        return countSwaps(arr, kth);
    }

    private int[] getKth(int[] arr, int k) {
        int[] clone = arr.clone();
        while (k-- != 0) {
            nextPerm(clone);
        }
        return clone;
    }

    private void nextPerm(int[] arr) {
        int n = arr.length;

        // 1) find first pivot where non-increasing
        int pivot = getPivot(arr);
        // Check pivot
        if (pivot == -1) {
            // Just reverse whole thing
            reverse(arr, 0);
            return;
        }
        // 2) Find next greater element at right most index
        int next = getNext(arr, pivot);
        // Swap pivot and next
        swap(arr, pivot, next);
        // Reverse after pivot
        reverse(arr, pivot + 1);
    }

    private int getNext(int[] arr, int pivot) {
        for (int i = arr.length - 1; i > pivot; --i) {
            if (arr[i] > arr[pivot]) {
                return i;
            }
        }
        return -1;
    }

    private int getPivot(int[] arr) {
        for (int i = arr.length - 2; i >= 0; --i) {
            if (arr[i] < arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    private void reverse(int[] arr, int lo) {
        int hi = arr.length - 1;
        while (lo < hi) {
            swap(arr, lo, hi);
            --hi;
            ++lo;
        }
    }

    int countSwaps(int[] arr, int[] kth) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == kth[i]) {
                // Continue here
                continue;
            }
            // Otherwise, there is a difference
            int j = i + 1;
            System.out.println("i = " + i + " j = " + j);
            while (j < n && arr[i] != kth[j]) {
                ++j;
            }

            while (j > i) {
                swap(kth, j - 1, j);
                ++res;
                --j;
            }
        }
        return res;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
