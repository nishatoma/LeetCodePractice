package binarysearch;

public class FindCeilingOfNumber {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 4, 5, 6, 9, 14, 16, 18, 20};

        System.out.println(findCeilingOfNumber(arr, 15));

    }

    static int findCeilingOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }

            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return arr[start];
    }
}
