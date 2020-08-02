package terrell.leetcode.array;
/**
 * @author: TerrellChen
 * @version: Created in 18:54 2020-08-02
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 */
public class OneHundredAndEighteen {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }
        List<Integer> firstLine = new ArrayList<>(1);
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        for (int i=1;i<numRows;i++) {
            int length = i+1;
            List<Integer> thisLine = new ArrayList<>(i+1);
            thisLine.add(1);
            List<Integer> lastLine = result.get(i-1);
            for (int j=1;j<length-1;j++) {
                thisLine.add(lastLine.get(j-1) + lastLine.get(j));
            }
            thisLine.add(1);
            result.add(thisLine);
        }
        return result;
    }
}
