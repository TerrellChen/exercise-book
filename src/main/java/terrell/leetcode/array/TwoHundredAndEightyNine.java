package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 22:36 2020-08-05
 */

import java.util.List;

/**
 * Description: 289 Game of Life
 * Difficulty: Medium
 * 题目：太长看原题
 * 解法：引入额外状态，两次遍历
 * 0ms 39.7MB
 */
public class TwoHundredAndEightyNine {
    int DIE = 0;
    int LIVE = 1;
    int DIE_TO_LIVE = 2;
    int LIVE_TO_DIE = 3;

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aliveCount = countAliveAround(board, i, j);
                board[i][j] = nextValue(board[i][j], aliveCount);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = finalValue(board[i][j]);
            }
        }
    }

    private int finalValue(int cur) {
        if (cur == DIE_TO_LIVE) {
            return LIVE;
        }
        if (cur == LIVE_TO_DIE) {
            return DIE;
        }
        return cur;
    }

    private int nextValue(int cur, int aliveCount) {
        if (aliveCount < 2) {
            if (cur == LIVE) {
                return LIVE_TO_DIE;
            }
            return cur;
        }

        if (aliveCount == 3) {
            if (cur == DIE) {
                return DIE_TO_LIVE;
            }
            return cur;
        }

        if (aliveCount > 3) {
            if (cur == LIVE) {
                return LIVE_TO_DIE;
            }
            return cur;
        }
        return cur;
    }

    private int countAliveAround(int[][] board, int i, int j) {
        int alive = 0;
        int[] candidateOfI;
        int[] candidateOfJ;
        if (i + 1 < board.length && i - 1 >= 0) {
            candidateOfI = new int[]{i - 1, i, i + 1};
        } else if (i + 1 < board.length) {
            candidateOfI = new int[]{i + 1, i};
        } else if (i - 1 >= 0) {
            candidateOfI = new int[]{i - 1, i};
        } else {
            candidateOfI = new int[]{i};
        }
        // j+1
        if (j + 1 < board[0].length && j - 1 >= 0) {
            candidateOfJ = new int[]{j - 1, j, j + 1};
        } else if (j + 1 < board[0].length) {
            candidateOfJ = new int[]{j + 1, j};
        } else if (j - 1 >= 0) {
            candidateOfJ = new int[]{j - 1, j};
        } else {
            candidateOfJ = new int[]{j};
        }

        for (int a : candidateOfI) {
            for (int b : candidateOfJ) {
                if (a == i && b == j) {
                    continue;
                }
                if (board[a][b] == 1 || board[a][b] == 3) {
                    alive++;
                }
            }
        }
        return alive;
    }
}
