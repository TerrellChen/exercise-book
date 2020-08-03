package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 21:48 2020-08-03
 */

/**
 * Description: 26 Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * 题目： 给出一个排序过的数组，要求原地移除其中重复的元素，并返回新的长度
 * 解法：遍历，两个指针，一个用来记录遍历到哪，一个用来把不重复的元素前移
 */
public class TwentySix {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
