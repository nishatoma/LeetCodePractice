package subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(subset(arr));
        System.out.println(subsetDuplicates(new int[]{1, 2, 2}));
    }

    static List<List<Integer>> subset(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        // For every number in the list
        for (int num : arr) {
            // I need to take the size of the res list,
            // and only iterate through that size
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> subList = new ArrayList<>(res.get(j));
                // then add the current num to every sublist in my result list
                subList.add(num);
                // then add the sublist to my result list.
                res.add(subList);
            }
        }
        return res;
    }

    static List<List<Integer>> subsetDuplicates(int[] arr) {
        // First, sort the array so the duplicates are
        // right next to each other
        Arrays.sort(arr);
        // Initiate result list
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int start = 0;
        int end = 0;
        // For every number in the list
        for (int i = 0; i < arr.length; i++) {
            int size = res.size();
            // initially we assume that start is == 0
            start = 0;
            // but if we find a duplicate, no need to start from
            // the beginning
            if (i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }
            end = size - 1;
            // I need to take the size of the res list,
            // and only iterate through that size

            for (int j = start; j < size; j++) {
                List<Integer> subList = new ArrayList<>(res.get(j));
                // then add the current num to every sublist in my result list
                subList.add(arr[i]);
                // then add the sublist to my result list.
                res.add(subList);
            }
        }
        return res;
    }
}
