package terrell.leetcode.item30;
/**
 * @author: TerrellChen
 * @version: Created in 01:28 2020-04-18
 */

import org.junit.Assert;

import java.util.Arrays;

/**
 * Description:
 */
public class ThirtySix {
    public boolean isValidSudoku(char[][] board) {
        if (!checkRow(board)) {
            return false;
        }
        if (!checkColumn(board)) {
            return false;
        }
        if (!checkGrid(board)) {
            return false;
        }
        return true;
    }

    public char[] getGrid(char[][] board, int rowIndex, int columnIndex) {
        char[] result = new char[board.length];
        int num = 0;
        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = columnIndex; j < columnIndex + 3; j++) {
                result[num++] = board[i][j];
            }
        }
        return result;
    }

    public char[] getRow(char[][] board, int index) {
        return board[index];
    }

    public char[] getColumn(char[][] board, int index) {
        char[] result = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            result[i] = board[i][index];
        }
        return result;
    }

    public boolean checkRow(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            char[] row = getRow(board, i);
            if (checkCharArray(row)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkColumn(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            char[] column = getColumn(board, i);
            if (checkCharArray(column)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkGrid(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char[] grid = getGrid(board, 3 * i, 3 * j);
                if (checkCharArray(grid)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkCharArray(char[] temp) {
        int[] counter = getCounter();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '.') {
                continue;
            }
            int index = Integer.parseInt(String.valueOf(temp[i]));
            counter[index]--;
        }
        return illegal(counter);
    }

    public int[] getCounter() {
        return new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    }

    public boolean illegal(int[] counter) {
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ThirtySix thirtySix = new ThirtySix();
        Assert.assertEquals(true, thirtySix.isValidSudoku(board));
    }

}
