package terrell.leetcode.string;
/**
 * @author: TerrellChen
 * @version: Created in 00:35 2020-08-13
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 17 Letter Combinations of a Phone Number
 * Difficulty: Medium
 * 题目：九宫格输入，给出一串数字，返回可能的英文输入组合
 * 解法：暴力解法，列出每个数字对应可能的英文字母，遍历数字枚举所有可能。
 */
public class Seventeen {
    private static char[] two = new char[]{'a','b','c'};
    private static char[] three = new char[]{'d','e','f'};
    private static char[] four = new char[]{'g','h','i'};
    private static char[] five = new char[]{'j','k','l'};
    private static char[] six = new char[]{'m','n','o'};
    private static char[] seven = new char[]{'p','q','r','s'};
    private static char[] eight = new char[]{'t','u','v'};
    private static char[] nine = new char[]{'w','x','y','z'};
    private static Map<String, char[]> digitsMap = new HashMap<String, char[]>(){{
        put("2", two);
        put("3", three);
        put("4", four);
        put("5", five);
        put("6", six);
        put("7", seven);
        put("8", eight);
        put("9", nine);
    }};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (char num:digits.toCharArray()){
            result = combine(result, digitsMap.get(String.valueOf(num)));
        }
        return result;
    }

    private List<String> combine(List<String> a, char[] b){
        List<String> result = new ArrayList<>();
        if (a == null || a.size() == 0){
            a = new ArrayList<>();
            a.add("");
        }
        for (String aa:a){
            for (char bb:b){
                result.add(new StringBuilder(aa).append(bb).toString());
            }
        }
        return result;
    }
}
