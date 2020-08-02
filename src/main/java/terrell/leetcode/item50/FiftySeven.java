package terrell.leetcode.item50;
/**
 * @author: TerrellChen
 * @version: Created in 14:31 2020-08-02
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 * start: 2/8/2020 14:36
 * end: 2/8/2020 15:39
 */
public class FiftySeven {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // check param
        if (newInterval.length == 0) {
            return intervals;
        }
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        // combine
        List<int[]> resultList = new LinkedList<>();
        int[] temp = null;
        boolean hasAddNewInterval = false;
        boolean useTemp = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] iTemp = intervals[i];
            if (temp == null) {
                /**
                 * [i0, i1] [n0, n1] has 3 situation:
                 * case 1: [i0, i1, n0, n1] add i
                 * case 2: [n0, n1, i0, i1] add n add i
                 * case 3: [min(i0, n0), max(i1, n1)] union as temp
                 */
                // case 1
                if (iTemp[1] < newInterval[0]) {
                    resultList.add(iTemp);
                    continue;
                }
                // case 2
                if (iTemp[0] > newInterval[1]) {
                    if (hasAddNewInterval == false) {
                        resultList.add(newInterval);
                        hasAddNewInterval = true;
                    }
                    resultList.add(iTemp);
                    continue;
                }
                // case 3
                useTemp = true;
                temp = new int[]{Math.min(iTemp[0], newInterval[0]), Math.max(iTemp[1], newInterval[1])};
            } else {
                /**
                 * [i0, i1] [t0, t1] has
                 * case 1: [i0, i1, t0, t1] add i
                 * case 2: [t0, t1, i0, i1] add t, add i
                 * case 3: [min(i0, t0), max(i1, t1)] union as temp
                 */
                // case 1
                if (iTemp[1] < temp[0]) {
                    resultList.add(iTemp);
                    continue;
                }
                // case 2
                if (iTemp[0] > temp[1]) {
                    if (hasAddNewInterval == false) {
                        resultList.add(temp);
                        hasAddNewInterval = true;
                    }
                    temp = null;
                    resultList.add(iTemp);
                    continue;
                }
                // case 3
                useTemp = true;
                temp = new int[]{Math.min(iTemp[0], temp[0]), Math.max(iTemp[1], temp[1])};
            }
        }
        if (temp != null) {
            resultList.add(temp);
        } else {
            if (useTemp == false && hasAddNewInterval == false) {
                resultList.add(newInterval);
            }
        }



        // return result
        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            int[] temp = result[i];
            System.out.println(temp[0] + " " + temp[1]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals;
        int[] newInterval;
        FiftySeven fiftySeven = new FiftySeven();

        // case 1
        intervals = new int[][]{new int[]{1, 3}, new int[]{6, 9}};
        newInterval = new int[]{2, 5};
        print(fiftySeven.insert(intervals, newInterval));
        System.out.println("");

        // case 2
        intervals = new int[][]{new int[]{1, 2}, new int[]{3, 5}, new int[]{6, 7}, new int[]{8, 10}, new int[]{12, 16}};
        newInterval = new int[]{4, 8};
        print(fiftySeven.insert(intervals, newInterval));
        System.out.println("");

        // case 3
        intervals = new int[][]{new int[]{1, 5}};
        newInterval = new int[]{2, 3};
        print(fiftySeven.insert(intervals, newInterval));
        System.out.println("");

        // case 4
        intervals = new int[][]{new int[]{1, 5}};
        newInterval = new int[]{6, 8};
        print(fiftySeven.insert(intervals, newInterval));
        System.out.println("");
    }
}
