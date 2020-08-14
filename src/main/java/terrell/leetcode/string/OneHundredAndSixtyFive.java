package terrell.leetcode.string;
/**
 * @author: TerrellChen
 * @version: Created in 22:44 2020-08-14
 */

/**
 * Description: 165 Compare Version Numbers
 * Difficulty: Medium
 * 题目：版本号比较 例如1.0.1 1.01.001
 * 解法：写给去前面0获取真实值的方法，然后按点分割，比较版本号即可
 */
public class OneHundredAndSixtyFive {
    public int compareVersion(String version1, String version2) {
        // check param
        // get level
        String[] version1Split = version1.split("\\.");
        String[] version2plit = version2.split("\\.");

        int v1Len = version1Split.length;
        int v2Len = version2plit.length;
        int len = Math.max(v1Len, v2Len);
        for (int i = 0; i < len; i++) {
            if (i < v1Len && i < v2Len) {
                int v1 = getNumIgonreZero(version1Split[i]);
                int v2 = getNumIgonreZero(version2plit[i]);
                if (v1 != v2) {
                    return v1 > v2 ? 1 : -1;
                }

            } else if (i < v1Len) {
                int v1 = getNumIgonreZero(version1Split[i]);
                if (v1 != 0) {
                    return 1;
                }
            } else if (i < v2Len) {
                int v2 = getNumIgonreZero(version2plit[i]);
                if (v2 != 0) {
                    return -1;
                }
            } else {
                return 0;
            }
        }

        return 0;
    }

    private int getNumIgonreZero(String version) {
        int firstNotZero = -1;
        for (int i = 0; i < version.length(); i++) {
            if (version.charAt(i) != '0') {
                firstNotZero = i;
                break;
            }
        }

        if (firstNotZero == -1) {
            return 0;
        }
        return Integer.parseInt(version.substring(firstNotZero));
    }

    public static void main(String[] args) {
        OneHundredAndSixtyFive oneHundredAndSixtyFive = new OneHundredAndSixtyFive();
        System.out.println(oneHundredAndSixtyFive.compareVersion("0.1", "1.1"));
        System.out.println(oneHundredAndSixtyFive.compareVersion("1.0.1", "1"));
        System.out.println(oneHundredAndSixtyFive.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(oneHundredAndSixtyFive.compareVersion("1.01", "1.001"));
        System.out.println(oneHundredAndSixtyFive.compareVersion("1.0", "1.0.0"));
    }
}

