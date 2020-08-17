package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 22:33 2020-08-17
 */

/**
 * Description: 25 Reverse Nodes in k-Group
 * Difficulty: Hard
 * 题目：
 */
public class TwentyFive {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headFlag = new ListNode(0);
        headFlag.next = head;
        ListNode pre = headFlag;
        while (isLengthEnough(head, k)) {
            swap(pre, head, k);
            pre = head;
            head = head.next;
        }
        return headFlag.next;
    }

    public void swap(ListNode pre, ListNode start, ListNode end) {
        if (start.next == end) {
            pre.next = end;
            start.next = end.next;
            end.next = start;
        } else {
            ListNode endNext = end.next;
            ListNode endPre = start;
            while (endPre.next != end) {
                endPre = endPre.next;
            }
            ListNode startNext = start.next;
            pre.next = end;
            end.next = startNext;
            endPre.next = start;
            start.next = endNext;
        }
    }

    public ListNode swap(ListNode headPre, ListNode head, int n) {
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            swap(getNode(headPre, i), getNode(headPre, i + 1), getNode(headPre, j + 1));
        }
        return headPre.next;
    }

    public ListNode getNode(ListNode start, int offset) {
        while (offset != 0) {
            start = start.next;
            offset--;
        }
        return start;
    }

    public boolean isLengthEnough(ListNode l, int k) {
        while (k != 0) {
            if (l == null) {
                return false;
            }
            l = l.next;
            k--;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
