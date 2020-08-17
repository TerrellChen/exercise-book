package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 21:54 2020-08-17
 */

/**
 * Description: 2 Add Two Numbers
 * Difficulty: Medium
 * 题目：给出两个非空链表，内容是反向的，给出同样方向的加出来的和
 * 解法：暴力啊。。
 */
public class Two {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode root = result;
        ListNode prev = null;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                result.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result.val += l2.val;
                l2 = l2.next;
            }

            boolean carry = false;
            if (result.val >= 10) {
                carry = true;
                result.val -= 10;
            }
            result.next = new ListNode(0);
            if (carry) {
                result.next.val++;
            }
            prev = result;
            result = result.next;
        }
        if (result.val == 0) {
            prev.next = null;
        }
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
