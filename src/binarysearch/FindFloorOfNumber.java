package binarysearch;

public class FindFloorOfNumber {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 7, 9, 10, 14, 16, 18, 20};

        System.out.println(findFloorOfNumber(arr, 4));
    }

    static int findFloorOfNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]){
                return arr[mid];
            }

            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[end];
    }
}
