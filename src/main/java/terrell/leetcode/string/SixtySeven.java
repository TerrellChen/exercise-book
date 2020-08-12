package terrell.leetcode.string;
/**
 * @author: TerrellChen
 * @version: Created in 00:43 2020-08-13
 */

/**
 * Description: 67 Add Binary
 * Difficulty: Easy
 * 题目：给出两个非空二进制字符串，返回和
 * 解法1：按照加法规则遍历
 * 解法2：先全加，再进位
 * 俩解法貌似差不多效率。。
 */
public class SixtySeven {
    public String addBinary(String a, String b) {
        int i = 0;
        boolean carry = false;
        int aLen = a.length();
        int bLen = b.length();
        char[] result = new char[Math.max(aLen, bLen)];
        while (i < aLen || i < bLen) {
            char addendA = i < aLen ? a.charAt(aLen - i - 1) : 48;
            char addendB = i < bLen ? b.charAt(bLen - i - 1) : 48;
            int addendCarry = carry ? 1 : 0;
            int sum = addendA + addendB + addendCarry - 96;
            if (sum >= 2) {
                sum -= 2;
                carry = true;
            } else {
                carry = false;
            }
            result[result.length - i++ - 1] = (char) (sum + 48);
        }
        if (carry) {
            return '1' + new String(result);
        }
        return new String(result);
    }

    public String addBinary1(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int rLen = Math.max(aLen, bLen);
        char[] result = new char[rLen];
        int i = 0;
        int index = 0;
        if (aLen > bLen) {
            for (i = 1; i <= aLen; i++) {
                result[rLen - i] = a.charAt(aLen - i);
            }

            for (i = 1; i <= bLen; i++) {
                index = rLen - i;
                result[index] = (char) (b.charAt(bLen - i) + result[index] - 48);
            }

        } else {
            for (i = 1; i <= bLen; i++) {
                result[rLen - i] = b.charAt(bLen - i);
            }

            for (i = 1; i <= aLen; i++) {
                index = rLen - i;
                result[index] = (char) (a.charAt(aLen - i) + result[index] - 48);
            }
        }


        for (i = rLen - 1; i > 0; i--) {
            if (result[i] > 49) {
                result[i] -= 2;
                result[i - 1] += 1;
            }
        }

        if (result[i] > 49) {
            result[i] -= 2;
            return '1' + new String(result);
        }
        return new String(result);
    }


    public static void main(String[] args) {
        SixtySeven sixtySeven = new SixtySeven();
        System.out.println(sixtySeven.addBinary1("11", "1"));
        System.out.println(sixtySeven.addBinary1("1010", "1011"));
        System.out.println(sixtySeven.addBinary1("1111", "1111"));
    }
}
