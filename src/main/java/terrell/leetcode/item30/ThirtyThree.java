package terrell.leetcode.item30;
/**
 * @author: TerrellChen
 * @version: Created in 23:22 2020-04-16
 */

import org.junit.Assert;

/**
 * Description:
 */
public class ThirtyThree {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return search(nums, 0, nums.length - 1, target, false);
    }

    public int search(int[] nums, int fromIndex, int toIndex, int target, boolean ordered) {
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
            if (ordered) {
                return search(nums, midIndex, toIndex, target, true);
            } else {
                if (mid < end) {
                    // right is ascending order, pivot in the left
                    if (end > target) {
                        // search in ordered area: mid-end
                        return search(nums, midIndex, toIndex, target, true);
                    } else {
                        // search in non-orderd area: start-mid
                        return search(nums, fromIndex, midIndex, target, false);
                    }
                } else {
                    // left is ascending order, pivot in the right
                    // search in non-orderd area: mid-end
                    return search(nums, midIndex, toIndex, target, false);
                }
            }
        } else if (target < mid) {
            if (ordered) {
                return search(nums, fromIndex, midIndex, target, true);
            } else {
                if (mid < end) {
                    // right is ascending order, pivot in the left
                    // search in non-ordered area: start-mid
                    return search(nums, fromIndex, midIndex, target, false);
                } else {
                    // left is ascending order, pivot in the right
                    if (target > start) {
                        // search in ordered area: start-mid
                        return search(nums, fromIndex, midIndex, target, true);
                    } else {
                        // search in non-orderd area: mid-end
                        return search(nums, midIndex, toIndex, target, false);
                    }
                }

            }
        } else {
            return midIndex;
        }
    }

    public static void main(String[] args) {
        ThirtyThree thirtyThree = new ThirtyThree();
        int target = 0;
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int result = 4;
        Assert.assertEquals(result, thirtyThree.search(nums, target));

        target = 1;
        nums = new int[]{1, 3};
        result = 0;
        Assert.assertEquals(result, thirtyThree.search(nums, target));

        target = 6;
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        result = 2;
        Assert.assertEquals(result, thirtyThree.search(nums, target));

        target = 2;
        nums = new int[]{4,5,6,7,0,1,2};
        result = 6;
        Assert.assertEquals(result, thirtyThree.search(nums, target));
    }
}
