package terrell.leetcode.item30;
/**
 * @author: TerrellChen
 * @version: Created in 00:43 2020-04-18
 */

import org.junit.Assert;

import java.util.Arrays;

/**
 * Description:
 */
public class ThirtyFour {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }

        int targetIndex = binarySearch(nums, 0, nums.length - 1, target);

        if (targetIndex == -1) {
            return result;
        }

        int firstIndex = targetIndex;
        int lastIndex = targetIndex;

        for (int i = targetIndex; i != -1; i--) {
            if (nums[i] == target) {
                firstIndex = i;
                continue;
            }
            break;
        }

        for (int i = targetIndex; i != nums.length; i++) {
            if (nums[i] == target) {
                lastIndex = i;
                continue;
            }
            break;
        }

        result[0] = firstIndex;
        result[1] = lastIndex;
        return result;
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

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        ThirtyFour thirtyFour = new ThirtyFour();
        Assert.assertTrue(Arrays.equals(new int[]{3, 4}, thirtyFour.searchRange(nums, target)));

        target = 6;
        Assert.assertTrue(Arrays.equals(new int[]{-1, -1}, thirtyFour.searchRange(nums, target)));

        nums = new int[]{2, 2};
        target = 2;
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, thirtyFour.searchRange(nums, target)));

        nums = new int[]{1, 3};
        target = 1;
        Assert.assertTrue(Arrays.equals(new int[]{0, 0}, thirtyFour.searchRange(nums, target)));

        nums = new int[]{0, 0, 0, 1, 2, 3};
        target = 0;
        Assert.assertTrue(Arrays.equals(new int[]{0, 2}, thirtyFour.searchRange(nums, target)));
    }
}
