package terrell.leetcode.string;
/**
 * @author: TerrellChen
 * @version: Created in 22:59 2020-08-14
 */

/**
 * Description: 344 Reverse String
 * Difficulty: Easy
 * 题目：翻转字符数组，只用常数级额外空间
 * 解法：直接交换呗
 */
public class ThreeHundredAndFortyFour {
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int i = 0, j = s.length - 1;
        char tmp = 0;
        while (i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
