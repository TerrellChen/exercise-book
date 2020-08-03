package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 18:18 2020-08-02
 */

/**
 * Description: 59 Spiral Matrix II
 * Difficulty: Medium
 * 题目：给一个正整数n，返回一个n * n的矩阵，并且将[1,n*n]的数字在其中按螺旋排列
 * 解法：生成矩阵，按照螺旋状遍历即可
 */
public class FiftyNine {
    public int[][] generateMatrix(int n) {
        // check params: none
        int[][] result = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = num++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = num++;
            }
            left++;
        }
        return result;
    }
}
