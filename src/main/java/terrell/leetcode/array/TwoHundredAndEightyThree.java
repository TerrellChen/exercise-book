package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 22:09 2020-08-05
 */

/**
 * Description: 283 Move Zeroes
 * Difficulty: Easy
 * 题目：给出一个数组，要求移动其中的0到末尾，不改变其他元素原有顺序
 * 解法1：两个指针，一个指0，一个指元素，将元素前移，后面的全部用0填充，时间复杂度nlogn，空间复杂度o(1)
 * 4ms faster than 13.44%
 * 40.3MB less than 5.10%?????
 * 解法2：额外空间存，时间复杂度o(2n)，空间复杂度o(n)
 * 解法3：只管把非0往前塞，最后补0 时间复杂度o(n),空间复杂度o(1)
 * 0ms faster than 100%
 * 42.4MB less than 5.10%?????(有问题吧？)
 */
public class TwoHundredAndEightyThree {
    public void moveZeroes(int[] nums) {
        solution2(nums);
    }

    void solution1(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int zeroIndex = Integer.MIN_VALUE;
        int index = 0;
        int nextNotZeroIndex = Integer.MIN_VALUE;
        while (true) {
            // find zero
            while (index < nums.length) {
                if (nums[index] == 0) {
                    zeroIndex = index;
                    break;
                }
                index++;
            }
            if (index >= nums.length - 1) {
                return;
            }
            index++;
            // find next not zero
            while (index < nums.length) {
                if (nums[index] != 0) {
                    nextNotZeroIndex = index;
                    break;
                }
                index++;
            }
            if (index >= nums.length) {
                return;
            }
            // swap
            nums[zeroIndex] = nums[nextNotZeroIndex];
            nums[nextNotZeroIndex] = 0;
            // set index -> swaped not zero index
            index = zeroIndex + 1;
        }
    }

    void solution2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TwoHundredAndEightyThree twoHundredAndEightyThree = new TwoHundredAndEightyThree();
        int[] nums;
        // case 1
        nums = new int[]{0, 1, 0, 3, 12};
        twoHundredAndEightyThree.moveZeroes(nums);
        print(nums);

    }
}
