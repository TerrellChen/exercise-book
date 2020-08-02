package terrell.leetcode.item70;
/**
 * @author: TerrellChen
 * @version: Created in 18:39 2020-08-02
 */

/**
 * Description:
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
