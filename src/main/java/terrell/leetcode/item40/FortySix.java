package terrell.leetcode.item40;
/**
 * @author: TerrellChen
 * @version: Created in 22:04 2020-04-23
 */

import java.util.*;

/**
 * Description:
 */
public class FortySix {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] index = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        int sum = 1;
        for (int i = 1; i <= index.length; i++) {
            sum *= i;
        }

        List<Integer> original = fromArray(index, nums);
        result.add(original);

        for (int i = 1; i < sum; i++) {
            nextPermutation(index);
            List<Integer> temp = fromArray(index, nums);
            result.add(temp);
        }

        return result;
    }

    public List<Integer> fromArray(int[] index, int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[index[i]]);
        }
        return result;
    }

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
        int[] nums = new int[]{1,2,3};
        FortySix fortySix = new FortySix();
        List<List<Integer>> result = fortySix.permute(nums);
        System.out.println(result.size());
    }
}
