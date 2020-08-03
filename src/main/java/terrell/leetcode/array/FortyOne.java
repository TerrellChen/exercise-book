package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 22:43 2020-04-20
 */

import java.util.Arrays;

/**
 * Description: 41 First Missing Positive
 * Difficulty: Hard
 * 题目：给出一个未排序的数组，找到缺少的第一个正整数
 * 备注：期望时间复杂度o(n)，并且使用常数级别的额外空间
 * 解法1：快排，找1，然后开始往后遍历（不符合备注）
 * 解法2：TODO
 */

/**
 * TODO
 * Runtime: 1 ms, faster than 32.14% of Java online submissions for First Missing Positive.
 * Memory Usage: 37.5 MB, less than 6.85% of Java online submissions for First Missing Positive.
 */
public class FortyOne {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int indexOfOne = binarySearchNearest(nums, 0, nums.length - 1, 1);
        if (indexOfOne == -1) {
            return 1;
        }
        if (nums[indexOfOne] != 1) {
            return 1;
        }
        int counter = nums[indexOfOne];
        for (int i = indexOfOne; i < nums.length; i++) {
            if (nums[i] == counter) {
                continue;
            } else if (nums[i] == counter + 1) {
                counter++;
                continue;
            } else {
                return counter + 1;
            }
        }
        return nums[nums.length - 1] + 1;
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

    }
}
