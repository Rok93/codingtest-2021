package binary_search;

import java.util.Arrays;

public class BinarySearch {

    private static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] > target) {
                end = mid - 1;
                continue;
            }

            start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 10, 15, 19, 21, 23};
        int target = 21;
        int resultPosition = BinarySearch.search(arr, target);
        System.out.println("결과 index: " + resultPosition);
        int libraryResult = Arrays.binarySearch(arr, 2);
        System.out.println("libraryResult = " + libraryResult);
    }
}
