package terrell.leetcode.Utils;
/**
 * @author: TerrellChen
 * @version: Created in 22:53 2020-04-16
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 */
public class SortUtil {
    public static void sort(int[] nums, int fromIndex, int toIndex, boolean reverse) {
        if (!reverse) {
            Arrays.sort(nums, fromIndex, toIndex);
            return;
        }

        Integer[] integers = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }

        Arrays.sort(integers, fromIndex, toIndex, Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = integers[i];
        }
    }

    public static int binarySearch(int[] nums, int fromIndex, int toIndex, int target) {
        if (toIndex - fromIndex < 3) {
            for (int i = fromIndex; i < toIndex + 1; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        int midIndex = (fromIndex + toIndex) / 2;
        int mid = nums[midIndex];
        int start = nums[fromIndex];
        int end = nums[toIndex];

        if (target == mid) {
            return midIndex;
        }
        if (target == start) {
            return fromIndex;
        }
        if (target == end) {
            return toIndex;
        }

        if (target > mid) {
            return binarySearch(nums, midIndex, toIndex, target);
        } else if (target < mid) {
            return binarySearch(nums, fromIndex, midIndex, target);
        } else {
            return midIndex;
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;

    }
}
