package terrell.leetcode.string;
/**
 * @author: TerrellChen
 * @version: Created in 00:28 2020-08-13
 */

/**
 * Description: 14 Longest Common Prefix
 * Difficulty: Easy
 * 题目：给出一个字符串数组，找到最长前缀
 * 解法：以第一个为例，向后匹配即可。
 */
public class Fourteen {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) {
            return "";
        }

        String prefix = null;
        for (String str:strs) {
            if (prefix == null) {
                prefix = str;
                continue;
            }
            if (prefix.length() > str.length()) {
                prefix = prefix.substring(0, str.length());
            }
            if (str.startsWith(prefix)) {
                continue;
            } else {
                // find common prefix
                int index = 0;
                for (int i=0;i<prefix.length();i++) {
                    if (str.charAt(i) != prefix.charAt(i)) {
                        index = i;
                        break;
                    }
                }
                prefix = prefix.substring(0, index);
            }
        }
        return prefix;
    }
}
