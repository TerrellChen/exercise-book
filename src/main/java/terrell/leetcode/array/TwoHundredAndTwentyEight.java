package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 22:42 2020-08-04
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 228 Summary Ranges
 * Difficulty: Medium
 * 题目：给出一个排过序且无重复的数组，返回其中的range（连续就算range，单个也是range）
 * 解法：遍历，几个点：1）记住上一个值；2）记录是否出现过连续的情况
 */
public class TwoHundredAndTwentyEight {
    public List<String> summaryRanges(int[] nums) {
        // check params
        List<String> result = new LinkedList<>();
        if (nums.length == 0) {
            return result;
        }

        boolean pair = false;
        boolean started = false;
        int start = 0;
        int cur;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            // 没有设置过start
            if (!started) {
                start = cur;
                last = cur;
                pair = false;
                started = true;
                continue;
            }

            if (cur - last == 1) {
                pair = true;
            } else {
                if (pair) {
                    result.add(String.format("%d->%d", start, last));
                } else {
                    result.add(String.valueOf(start));
                }
                start = cur;
                pair = false;
            }
            last = cur;
        }
        if (started) {
            if (pair) {
                result.add(String.format("%d->%d", start, last));
            } else {
                result.add(String.valueOf(start));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoHundredAndTwentyEight twoHundredAndTwentyEight = new TwoHundredAndTwentyEight();
        int[] nums;
        List<String> result;
        // case 1
        nums = new int[]{0,1,2,4,5,7};
        result = twoHundredAndTwentyEight.summaryRanges(nums);

        System.out.println(result);
    }
}
