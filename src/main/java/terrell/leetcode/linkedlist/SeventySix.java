package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 22:53 2020-08-21
 */

/**
 * Description: 76 Minimum Window Substring
 * Difficulty: Hard
 * 题目：给出一个字符串S和字符串T，找出S中最短的包含T全部字符的子串
 * 解法：首先为了将查找字符是否在t中，将t转化为ascii的map的访问，时间复杂度为o(1)，也就是代码中的map。
 *      同时map最初也用来记录t中是否存在重复的字符。
 *      遍历map，记录我们一共要找到多少种字符，并且每个字符需要多少个（find need required）
 *      用left、right两个指针从0开始遍历
 *      循环中：
 *          循环直到left匹配到一个字符后，find对应增加，同时检查是否达到need，如达到，required--
 *          当匹配到left后，开始匹配right。如果required这时候已经是0，那么直接按照当前长度，产生一个子串，
 *          比较已经记录的子串，仅保留最短的
 *          将left++，继续下一轮循环
 *
 *  一些小的优化点：可以缓存right遍历时匹配到的点，以便left右移追right的时候，减少扫描量
 */
public class SeventySix {
    public String minWindow(String s, String t) {
        int[] map = new int[255];
        char[] ct = t.toCharArray();
        for (int i = 0; i < ct.length; i++) {
            map[ct[i]]++;
        }
        int required = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                required++;
            }
        }
        int[] find = new int[required];
        int[] need = new int[required];

        for (int i = 0, j = 0; i < map.length; i++) {
            if (map[i] != 0) {
                need[j++] = map[i];
                map[i] = j;
            }
        }
        int left = 0;
        int right = 0;
        int findStart = 0;
        int findEnd = Integer.MAX_VALUE;
        while (left < s.length()) {
            while (left < s.length() && map[s.charAt(left)] == 0) {
                left++;
            }
            if (left >= s.length()) {
                break;
            }
            if (left >= right) {
                find[map[s.charAt(left)] - 1]++;
                if (find[map[s.charAt(left)] - 1] == need[map[s.charAt(left)] - 1]) {
                    required--;
                }
            }
            if (right == 0) {
                right = left + 1;
            }

            while (right < s.length() && required != 0) {
                if (map[s.charAt(right)] != 0) {
                    find[map[s.charAt(right)] - 1]++;
                    if (find[map[s.charAt(right)] - 1] == need[map[s.charAt(right)] - 1]) {
                        required--;
                    }
                }
                right++;
            }

            if (required == 0) {
                if (right - left < findEnd - findStart) {
                    findStart = left;
                    findEnd = right;
                }
            }
            find[map[s.charAt(left)] - 1]--;
            if (find[map[s.charAt(left)] - 1] == need[map[s.charAt(left)] - 1] - 1) {
                required++;
            }
            left++;
        }

        if (findEnd != Integer.MAX_VALUE) {
            return s.substring(findStart, findEnd);
        }
        return "";
    }

    public static void main(String[] args) {
        SeventySix seventySix = new SeventySix();
        System.out.println(seventySix.minWindow("ADOBECODEBANC", "ABC"));

        System.out.println(seventySix.minWindow("a", "a"));

        System.out.println(seventySix.minWindow("a", "b"));

        System.out.println(seventySix.minWindow("aa", "aa"));

        System.out.println(seventySix.minWindow("bba", "ab"));
    }
}
