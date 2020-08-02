package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 22:27 2020-04-16
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description:
 */
public class ThirtyOne {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int violateOrder = 0;
        boolean find = false;
        for (int i = nums.length - 1; i != 0; i--) {
            if (nums[i - 1] < nums[i]) {
                violateOrder = i - 1;
                find = true;
                break;
            }
        }

        if (find) {
            for (int i = nums.length - 1; i > violateOrder; i--) {
                if (nums[i] > nums[violateOrder]) {
                    nums[i] = nums[i] ^ nums[violateOrder];
                    nums[violateOrder] = nums[i] ^ nums[violateOrder];
                    nums[i] = nums[i] ^ nums[violateOrder];
                    break;
                }
            }
            sort(nums, violateOrder + 1, nums.length, false);
            return;
        }
        reverse(nums);
    }

    public void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    // terrell.leetcode.Utils.SortUtil.sort
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

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        ThirtyOne s = new ThirtyOne();
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
