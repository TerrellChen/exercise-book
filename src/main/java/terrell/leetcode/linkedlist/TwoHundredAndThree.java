package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 00:33 2020-09-05
 */

/**
 * Description: 203 Remove Linked List Elements
 * Difficulty: Easy
 * 题目：移除链表中指定的值
 * 解法：遍历移除
 */
public class TwoHundredAndThree {
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

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start, iter = head;
        while (iter != null) {
            if (iter.val == val) {
                prev.next = iter.next;
                iter = iter.next;
                continue;
            }
            iter = iter.next;
            prev = prev.next;
        }

        return start.next;
    }
}
