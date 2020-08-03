package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 18:39 2020-08-02
 */

/**
 * Description: 73 Set Matrix Zeroes
 * Difficulty: Medium
 * 题目：给出一个含0矩阵，要求找到矩阵中的0，并将0所在的行/列，均置为0，返回数组
 * 解法：主要难点在只转换最初的0，那么找到0之后的转换不一定需要转换为0，而可以转换为一个替代物，比如Integer.MAX_VALUE，
 *      遍历完之后再将这些数转换为0输出
 */
public class SeventyThree {
    public void setZeroes(int[][] matrix) {
        int modified = 123456789;
        for (int i=0;i<matrix.length;i++) {
            boolean jLineHasZero = false;
            for (int j=0;j<matrix[i].length;j++) {
                if (matrix[i][j] == 0) {
                    jLineHasZero = true;
                    break;
                }
            }
            if (jLineHasZero) {
                for (int j=0;j<matrix[i].length;j++) {
                    if (matrix[i][j] != 0) {
                        matrix[i][j] = modified;
                    }
                }
            }
        }
        for (int j=0;j<matrix[0].length;j++) {
            boolean iLineHasZero = false;
            for (int i=0;i<matrix.length;i++) {
                if (matrix[i][j] == 0) {
                    iLineHasZero = true;
                    break;
                }
            }
            if (iLineHasZero) {
                for (int i=0;i<matrix.length;i++) {
                    if (matrix[i][j] != 0) {
                        matrix[i][j] = modified;
                    }
                }
            }
        }

        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j] == modified) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
