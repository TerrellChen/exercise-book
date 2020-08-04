package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 21:55 2020-08-03
 */

/**
 * Description: 189 Rotate Array
 * Difficulty: Easy
 * 题目：给出一个数组，及一个数k，将整个数组后移k位（末尾的提前）
 * 解法：当成一个圈就好，首先确认k小于nums.length，然后每次走k步，最终会回到原位，如果没有遍历完所有的，就从下一个数字触发继续按k遍历
 */
public class OneHundredAndEightyNine {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int currentIndex = i;
            int prev = nums[i];
            do {
                int next = (currentIndex + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                currentIndex = next;
                count++;
            } while (i != currentIndex);
        }
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OneHundredAndEightyNine oneHundredAndEightyNine = new OneHundredAndEightyNine();
        int[] nums;
        int k;
        // case 1
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 3;
        oneHundredAndEightyNine.rotate(nums, k);
        print(nums);
    }
}
