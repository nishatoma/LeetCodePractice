package binarysearch;

public class SearchSortedRotatedArray_33 {

    public static void main(String[] args) {
        int[] arr =  new int[]{4, 5, 6, 7, 0, 1, 2};

        System.out.println(search(arr, 0));
//        System.out.println(searchB(arr, 0, 0,6));
        System.out.println(findPivot(arr));
    }

    static int search(int[] nums, int target) {
        int k = findPivot(nums);
        System.out.println("K = " + k);
        int firstHalf = searchB(nums, target, 0, k);

        if (firstHalf != -1) {
            return firstHalf;
        }

        int secondHalf = searchB(nums, target, k + 1, nums.length - 1);

        return secondHalf;
    }

    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // if the mid is actually less than prev;
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid -1;
            }
            // case 3, if all elements from middle till end are
            // smaller than the first element
            if (arr[mid] <= arr[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int searchB(int[] nums, int target, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;

//            System.out.println(nums[m]);
            if(nums[m] == target) {
                return m;
            }

            if (nums[m] > target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
