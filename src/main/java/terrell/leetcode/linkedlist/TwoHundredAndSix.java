package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 00:38 2020-09-05
 */

/**
 * Description: 206 Reverse Linked List
 * Difficulty: Easy
 * 题目：反转链表
 * 解法：遍历反转
 */
public class TwoHundredAndSix {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, iter = head;
        while (iter.next != null) {
            ListNode next = iter.next;
            iter.next = prev;
            prev = iter;
            iter = next;
        }
        iter.next = prev;
        return iter;
    }
}
