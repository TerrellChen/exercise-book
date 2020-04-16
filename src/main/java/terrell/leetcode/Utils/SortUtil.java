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
}
