package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 19:07 2020-08-02
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 119 Pascal's Triangle II
 * Difficulty: Easy
 * 题目：给出一个[0,33]的数，返回杨辉三角这一行的内容
 * 备注：要求空间只用o(k)
 * 解法：在行内进行遍历即可
 */
public class OneHundredAndNineteen {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<>(rowIndex + 1);
        if (rowIndex == 0) {
            return result;
        }
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
            result.add(1);
        }
        return result;
    }
}
