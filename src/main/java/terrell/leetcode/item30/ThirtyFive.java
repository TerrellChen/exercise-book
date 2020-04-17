package terrell.leetcode.item30;
/**
 * @author: TerrellChen
 * @version: Created in 01:09 2020-04-18
 */

import org.junit.Assert;

/**
 * Description:
 */
public class ThirtyFive {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int nearestIndex = binarySearchNearest(nums, 0, nums.length - 1, target);
        if (nearestIndex == -1) {
            return 0;
        }
        if (nums[nearestIndex] == target) {
            return nearestIndex;
        }
        return nearestIndex + 1;
    }

    public static int binarySearchNearest(int[] nums, int fromIndex, int toIndex, int target) {
        if (toIndex - fromIndex < 3) {
            for (int i = fromIndex; i < toIndex + 1; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            for (int i = fromIndex; i < toIndex + 1; i++) {
                if (nums[i] > target) {
                    return i - 1;
                }
            }
            return toIndex;
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
            return binarySearchNearest(nums, midIndex, toIndex, target);
        } else if (target < mid) {
            return binarySearchNearest(nums, fromIndex, midIndex, target);
        } else {
            return midIndex;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 7;
        ThirtyFive thirtyFive = new ThirtyFive();
        Assert.assertEquals(4, thirtyFive.searchInsert(nums, target));
    }
}
