package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 19:34 2020-05-23
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.*;

/**
 * Description: [1,10],[2,5][0,3],[4,7]
 * [0,3][1,10],[2,5],[4,7]
 */
public class FiftySix {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        // sort
        quickSort(intervals, 0, intervals.length - 1);
        List<int[]> tmmp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            tmmp.add(intervals[i]);
        }
        // while(true) {merge}
        while (true) {
            List<int[]> lastTime = tmmp;
            tmmp = new LinkedList<>();
            boolean doMerge = false;
            int i;
            for (i = 0; i < lastTime.size() - 1; i++) {
                int[] a = lastTime.get(i);
                int[] b = lastTime.get(i + 1);
                if (canBeMerged(a, b)) {
                    doMerge = true;
                    tmmp.add(merge(a, b));
                    i++;
                } else {
                    tmmp.add(lastTime.get(i));
                }
            }
            if (i == lastTime.size() - 1) {
                tmmp.add(lastTime.get(lastTime.size() - 1));
            }
            if (!doMerge) {
                break;
            }
        }
        // return;
        int[][] result = new int[tmmp.size()][];
        for (int i = 0; i < tmmp.size(); i++) {
            result[i] = tmmp.get(i);
        }
        return result;
    }

    public boolean canBeMerged(int[] a, int[] b) {
        if (b.length != 2 || a.length != 2) {
            return true;
        }
        if (a[1] >= b[0]) {
            return true;
        }
        return false;
    }

    public int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }

    public void sort(int[][] intervals) {
        int[] tmp = intervals[0];
    }

    class Pair {
        int index;
        int firstValue;

        Pair(int index, int firstValue) {
            this.index = index;
            this.firstValue = firstValue;
        }
    }

    public void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            int pair1Low = low;
            int pair1High = index - 1;
            int pair2Low = index + 1;
            int pair2High = high;
            if (pair1Low < pair1High) {
                quickSort(arr, pair1Low, pair1High);
            }
            if (pair2Low < pair2High) {
                quickSort(arr, pair2Low, pair2High);
            }
        }
    }

    private int getIndex(int[][] arr, int low, int high) {
        int[] tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high][0] >= tmp[0]) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low][0] <= tmp[0]) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }

    public void print(int[][] xxx) {
        for (int i = 0; i < xxx.length; i++) {
            for (int j = 0; j < xxx[i].length; j++) {
                System.out.printf("%d ", xxx[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        int[][] intervals;
        int[][] result;
        FiftySix fiftySix = new FiftySix();


        intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        result = fiftySix.merge(intervals);
        fiftySix.print(result);

        intervals = new int[][]{{1, 4}, {4, 5}};
        result = fiftySix.merge(intervals);
        fiftySix.print(result);

        String xx = "[\n" +
                "[\n" +
                "362,\n" +
                "367\n" +
                "],\n" +
                "[\n" +
                "314,\n" +
                "315\n" +
                "],\n" +
                "[\n" +
                "133,\n" +
                "138\n" +
                "],\n" +
                "[\n" +
                "434,\n" +
                "443\n" +
                "],\n" +
                "[\n" +
                "202,\n" +
                "203\n" +
                "],\n" +
                "[\n" +
                "144,\n" +
                "145\n" +
                "],\n" +
                "[\n" +
                "229,\n" +
                "235\n" +
                "],\n" +
                "[\n" +
                "205,\n" +
                "212\n" +
                "],\n" +
                "[\n" +
                "314,\n" +
                "323\n" +
                "],\n" +
                "[\n" +
                "128,\n" +
                "129\n" +
                "],\n" +
                "[\n" +
                "413,\n" +
                "414\n" +
                "],\n" +
                "[\n" +
                "342,\n" +
                "345\n" +
                "],\n" +
                "[\n" +
                "43,\n" +
                "49\n" +
                "],\n" +
                "[\n" +
                "333,\n" +
                "342\n" +
                "],\n" +
                "[\n" +
                "173,\n" +
                "178\n" +
                "],\n" +
                "[\n" +
                "386,\n" +
                "391\n" +
                "],\n" +
                "[\n" +
                "131,\n" +
                "133\n" +
                "],\n" +
                "[\n" +
                "157,\n" +
                "163\n" +
                "],\n" +
                "[\n" +
                "187,\n" +
                "190\n" +
                "],\n" +
                "[\n" +
                "186,\n" +
                "186\n" +
                "],\n" +
                "[\n" +
                "17,\n" +
                "19\n" +
                "],\n" +
                "[\n" +
                "63,\n" +
                "69\n" +
                "],\n" +
                "[\n" +
                "70,\n" +
                "79\n" +
                "],\n" +
                "[\n" +
                "386,\n" +
                "391\n" +
                "],\n" +
                "[\n" +
                "98,\n" +
                "102\n" +
                "],\n" +
                "[\n" +
                "236,\n" +
                "239\n" +
                "],\n" +
                "[\n" +
                "195,\n" +
                "195\n" +
                "],\n" +
                "[\n" +
                "338,\n" +
                "338\n" +
                "],\n" +
                "[\n" +
                "169,\n" +
                "170\n" +
                "],\n" +
                "[\n" +
                "151,\n" +
                "153\n" +
                "],\n" +
                "[\n" +
                "409,\n" +
                "416\n" +
                "],\n" +
                "[\n" +
                "377,\n" +
                "377\n" +
                "],\n" +
                "[\n" +
                "90,\n" +
                "96\n" +
                "],\n" +
                "[\n" +
                "156,\n" +
                "165\n" +
                "],\n" +
                "[\n" +
                "182,\n" +
                "186\n" +
                "],\n" +
                "[\n" +
                "371,\n" +
                "372\n" +
                "],\n" +
                "[\n" +
                "228,\n" +
                "233\n" +
                "],\n" +
                "[\n" +
                "297,\n" +
                "306\n" +
                "],\n" +
                "[\n" +
                "56,\n" +
                "61\n" +
                "],\n" +
                "[\n" +
                "184,\n" +
                "190\n" +
                "],\n" +
                "[\n" +
                "401,\n" +
                "403\n" +
                "],\n" +
                "[\n" +
                "221,\n" +
                "228\n" +
                "],\n" +
                "[\n" +
                "203,\n" +
                "212\n" +
                "],\n" +
                "[\n" +
                "39,\n" +
                "43\n" +
                "],\n" +
                "[\n" +
                "83,\n" +
                "84\n" +
                "],\n" +
                "[\n" +
                "66,\n" +
                "68\n" +
                "],\n" +
                "[\n" +
                "80,\n" +
                "83\n" +
                "],\n" +
                "[\n" +
                "32,\n" +
                "32\n" +
                "],\n" +
                "[\n" +
                "182,\n" +
                "182\n" +
                "],\n" +
                "[\n" +
                "300,\n" +
                "306\n" +
                "],\n" +
                "[\n" +
                "235,\n" +
                "238\n" +
                "],\n" +
                "[\n" +
                "267,\n" +
                "272\n" +
                "],\n" +
                "[\n" +
                "458,\n" +
                "464\n" +
                "],\n" +
                "[\n" +
                "114,\n" +
                "120\n" +
                "],\n" +
                "[\n" +
                "452,\n" +
                "452\n" +
                "],\n" +
                "[\n" +
                "372,\n" +
                "375\n" +
                "],\n" +
                "[\n" +
                "275,\n" +
                "280\n" +
                "],\n" +
                "[\n" +
                "302,\n" +
                "302\n" +
                "],\n" +
                "[\n" +
                "5,\n" +
                "9\n" +
                "],\n" +
                "[\n" +
                "54,\n" +
                "62\n" +
                "],\n" +
                "[\n" +
                "237,\n" +
                "237\n" +
                "],\n" +
                "[\n" +
                "432,\n" +
                "439\n" +
                "],\n" +
                "[\n" +
                "415,\n" +
                "421\n" +
                "],\n" +
                "[\n" +
                "340,\n" +
                "347\n" +
                "],\n" +
                "[\n" +
                "356,\n" +
                "358\n" +
                "],\n" +
                "[\n" +
                "165,\n" +
                "168\n" +
                "],\n" +
                "[\n" +
                "15,\n" +
                "17\n" +
                "],\n" +
                "[\n" +
                "259,\n" +
                "265\n" +
                "],\n" +
                "[\n" +
                "201,\n" +
                "204\n" +
                "],\n" +
                "[\n" +
                "192,\n" +
                "197\n" +
                "],\n" +
                "[\n" +
                "376,\n" +
                "383\n" +
                "],\n" +
                "[\n" +
                "210,\n" +
                "211\n" +
                "],\n" +
                "[\n" +
                "362,\n" +
                "367\n" +
                "],\n" +
                "[\n" +
                "481,\n" +
                "488\n" +
                "],\n" +
                "[\n" +
                "59,\n" +
                "64\n" +
                "],\n" +
                "[\n" +
                "307,\n" +
                "315\n" +
                "],\n" +
                "[\n" +
                "155,\n" +
                "164\n" +
                "],\n" +
                "[\n" +
                "465,\n" +
                "467\n" +
                "],\n" +
                "[\n" +
                "55,\n" +
                "60\n" +
                "],\n" +
                "[\n" +
                "20,\n" +
                "24\n" +
                "],\n" +
                "[\n" +
                "297,\n" +
                "304\n" +
                "],\n" +
                "[\n" +
                "207,\n" +
                "210\n" +
                "],\n" +
                "[\n" +
                "322,\n" +
                "328\n" +
                "],\n" +
                "[\n" +
                "139,\n" +
                "142\n" +
                "],\n" +
                "[\n" +
                "192,\n" +
                "195\n" +
                "],\n" +
                "[\n" +
                "28,\n" +
                "36\n" +
                "],\n" +
                "[\n" +
                "100,\n" +
                "108\n" +
                "],\n" +
                "[\n" +
                "71,\n" +
                "76\n" +
                "],\n" +
                "[\n" +
                "103,\n" +
                "105\n" +
                "],\n" +
                "[\n" +
                "34,\n" +
                "38\n" +
                "],\n" +
                "[\n" +
                "439,\n" +
                "441\n" +
                "],\n" +
                "[\n" +
                "162,\n" +
                "168\n" +
                "],\n" +
                "[\n" +
                "433,\n" +
                "433\n" +
                "],\n" +
                "[\n" +
                "368,\n" +
                "369\n" +
                "],\n" +
                "[\n" +
                "137,\n" +
                "137\n" +
                "],\n" +
                "[\n" +
                "105,\n" +
                "112\n" +
                "],\n" +
                "[\n" +
                "278,\n" +
                "280\n" +
                "],\n" +
                "[\n" +
                "452,\n" +
                "452\n" +
                "],\n" +
                "[\n" +
                "131,\n" +
                "132\n" +
                "],\n" +
                "[\n" +
                "475,\n" +
                "480\n" +
                "],\n" +
                "[\n" +
                "126,\n" +
                "129\n" +
                "],\n" +
                "[\n" +
                "95,\n" +
                "104\n" +
                "],\n" +
                "[\n" +
                "93,\n" +
                "99\n" +
                "],\n" +
                "[\n" +
                "394,\n" +
                "403\n" +
                "],\n" +
                "[\n" +
                "70,\n" +
                "78\n" +
                "]\n" +
                "]";
        JSONArray jsonArray = JSON.parseArray(xx);
        intervals = new int[jsonArray.size()][];
        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = new int[]{jsonArray.getJSONArray(i).getInteger(0), jsonArray.getJSONArray(i).getInteger(1)};
            intervals[i] = tmp;
        }
        result = fiftySix.merge(intervals);
        fiftySix.print(result);
    }
}
