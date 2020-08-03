package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 21:48 2020-08-03
 */

/**
 * Description: 27 Remove Element
 * Difficulty: Easy
 * 题目：给出一个数组和一个数，移除数组中所有给出的这个数，然后返回新的长度
 * 解法：两个指针，一个用来追踪遍历到哪，一个用来替换重复元素
 */
public class TwentySeven {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
