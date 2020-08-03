package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 20:28 2020-08-03
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: 164 Maximum Gap
 * Difficulty: Hard
 * 题目：找到无序数组中最大的间隔
 * 解法1：快排数组，然后找，时间复杂度nlogn
 * 解法2：以间隔(max-min)/总个数，进行分bucket。bucket内数字一定小于等于间隔，bucket间可能存在大于的间隔，只需要比较bucket间
 */
public class OneHundredAndSixtyFour {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }

        int interval = (max - min) / (nums.length - 1);
        int bucketNums;
        if (interval == 0) {
            if (max - min == 0) {
                return 0;
            }
            interval = max - min;
        }
        bucketNums= (max - min) / interval + 1;
        List<List<Integer>> bucketList = new ArrayList<>(bucketNums);
        for (int i = 0; i < bucketNums; i++) {
            bucketList.add(new LinkedList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            int bucketNum = (nums[i] - min) / interval;
            bucketList.get(bucketNum).add(nums[i]);
        }
        int greatestInterval = 0;

        int lastMax = Integer.MIN_VALUE;
        for (int i = 0; i < bucketList.size(); i++) {
            List<Integer> tempList = bucketList.get(i);
            if (tempList.size() == 0) {
                continue;
            }
            Iterator<Integer> iterator = tempList.iterator();
            int tempMax = Integer.MIN_VALUE;
            int tempMin = Integer.MAX_VALUE;
            while (iterator.hasNext()) {
                int cur = iterator.next();
                tempMax = Math.max(cur, tempMax);
                tempMin = Math.min(cur, tempMin);
            }
            if (lastMax != Integer.MIN_VALUE) {
                greatestInterval = Math.max(greatestInterval, tempMin - lastMax);
            }
            lastMax = tempMax;
        }
        return greatestInterval;
    }

    public static void main(String[] args) {
        OneHundredAndSixtyFour oneHundredAndSixtyFour = new OneHundredAndSixtyFour();
        int[] nums;
        // case 1
        nums = new int[]{3,6,9,1};
        System.out.println(oneHundredAndSixtyFour.maximumGap(nums));
        // case 2
        nums = new int[]{10};
        System.out.println(oneHundredAndSixtyFour.maximumGap(nums));
        // case 3
        nums = new int[]{1, 1, 1, 1};
        System.out.println(oneHundredAndSixtyFour.maximumGap(nums));
        // case 3
        nums = new int[]{1, 1, 1, 1, 1, 5, 5, 5, 5, 5};
        System.out.println(oneHundredAndSixtyFour.maximumGap(nums));
    }
}
