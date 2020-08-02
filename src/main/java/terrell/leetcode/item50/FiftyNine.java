package terrell.leetcode.item50;
/**
 * @author: TerrellChen
 * @version: Created in 18:18 2020-08-02
 */

/**
 * Description:
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
