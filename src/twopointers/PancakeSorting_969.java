package twopointers;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting_969 {

    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for (int i = n - 1; i >= 0; --i) {
            int max = i;
            // Find max index
            for (int j = i; j >= 0; j--) {
                if (arr[j] > arr[max]) max = j;
            }
            // That means we have to flip
            if (max != i) {
                flip(arr, max);
                flip(arr, i);
                res.add(max + 1);
                res.add(i + 1);
            }
        }
        return res;
    }

    private void flip(int[] arr, int end) {
        int i = 0;
        int j = end;
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
