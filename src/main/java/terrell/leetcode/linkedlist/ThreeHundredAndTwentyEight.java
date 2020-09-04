package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 01:13 2020-09-05
 */

/**
 * Description: 328 Odd Even Linked List
 * Difficulty: Medium
 * 题目：将一个链表奇数位放前面，偶数位放后面
 * 解法：剔出偶数位组成新链表，连接到后面
 */
public class ThreeHundredAndTwentyEight {
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode eventStart = new ListNode(0), iter = head, evenIter = eventStart, prev = null;
        while (iter != null && iter.next != null) {
            ListNode next = iter.next.next;
            evenIter.next = iter.next;
            evenIter = evenIter.next;
            evenIter.next = null;
            iter.next = next;
            prev = iter;
            iter = iter.next;
        }

        if (iter == null) {
            iter = prev;
        }

        iter.next = eventStart.next;
        return head;
    }
}
