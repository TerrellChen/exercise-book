package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 16:51 2020-05-23
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 54 Spiral Matrix
 * Difficulty: Medium
 * 题目：给出一个螺旋排列的矩阵，将内容按螺旋排列取出并输出
 * 解法：按螺旋遍历即可，每次"撞墙"即边界缩短一阶
 */
public class FiftyFour {
    public List<Integer> spiralOrder(int[][] martrix) {
        List<Integer> result = new LinkedList<>();
        List<Cor> index = new LinkedList<>();
        if (martrix.length == 0 || martrix[0].length ==0) {
            return result;
        }
        Border border = new Border(martrix);
        Cor current = new Cor(0, 0);
        index.add(current);
        int count = 0;
        Move move = Move.NOWHERE;
        while (current.illegal(border)) {
            // find way
            move = findWay(current, border, move, count);
            if (move.equals(Move.NOWHERE)) {
                break;
            }
            // update border
            if (count++ != 0) {
                border.turn(move);
            }
            // move & record
            current = move(index, current, move, border);
        }

        for (Cor cor : index) {
            result.add(martrix[cor.y][cor.x]);
        }
        return result;
    }

    int tryMove(Cor cor, Move move, Border border) {
        switch (move) {
            case DOWN:
                return border.bottom - cor.y - 1;
            case UP:
                return cor.y - border.top - 1;
            case LEFT:
                return cor.x - border.left - 1;
            case RIGHT:
                return border.right - cor.x - 1;
            default:
                throw new RuntimeException();

        }
    }

    Move findWay(Cor cor, Border border, Move lastMove, int count) {
        Move next = Move.getNext(lastMove);
        if (tryMove(cor, next, border) > 0) {
            return next;
        }
        if (count == 0) {
            next = Move.getNext(next);
            if (tryMove(cor, next, border) > 0) {
                return next;
            }
        }
        return Move.NOWHERE;
    }

    Cor move(List<Cor> index, Cor cor, Move move, Border border) {
        int times = tryMove(cor, move, border);
        for (int i = 0; i < times; i++) {
            switch (move) {
                case DOWN:
                    cor = cor.increamentY(1);
                    break;
                case UP:
                    cor = cor.reduceY(1);
                    break;
                case LEFT:
                    cor = cor.reduceX(1);
                    break;
                case RIGHT:
                    cor = cor.increamentX(1);
                    break;
                default:
                    throw new RuntimeException();
            }
            index.add(cor);
        }
        return cor;
    }


    enum Move {
        LEFT, RIGHT, DOWN, UP, NOWHERE;

        static Move getNext(Move move) {
            switch (move) {
                case RIGHT:
                    return DOWN;
                case DOWN:
                    return LEFT;
                case LEFT:
                    return UP;
                case UP:
                    return RIGHT;
                default:
                    return RIGHT;

            }
        }
    }

    class Cor {
        final int x;
        final int y;

        private Cor() {
            throw new RuntimeException();
        }

        Cor(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Cor increamentX(int times) {
            return new Cor(x + times, y);
        }

        Cor increamentY(int times) {
            return new Cor(x, y + times);
        }

        Cor reduceX(int times) {
            return new Cor(x - times, y);
        }

        Cor reduceY(int times) {
            return new Cor(x, y - times);
        }

        boolean illegal(Border border) {
            return x > border.left && x < border.right && y > border.top && y < border.bottom;
        }

    }

    class Border {
        int left;
        int right;
        int top;
        int bottom;

        Border(int[][] martrix) {
            left = -1;
            right = martrix[0].length;
            top = -1;
            bottom = martrix.length;
        }

        void turn(Move move) {
            switch (move) {
                case DOWN:
                    top++;
                    break;
                case UP:
                    bottom--;
                    break;
                case LEFT:
                    right--;
                    break;
                case RIGHT:
                    left++;
                    break;
                default:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] martrix;
        List<Integer> result;
        FiftyFour fiftyFour = new FiftyFour();
        martrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        result = fiftyFour.spiralOrder(martrix);
        System.out.println(result);


        martrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        result = fiftyFour.spiralOrder(martrix);
        System.out.println(result);
    }
}
