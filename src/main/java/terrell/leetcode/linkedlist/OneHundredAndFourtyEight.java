package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 00:01 2020-09-05
 */

/**
 * Description: 148 Sort List
 * Difficulty: Medium
 * 题目：nlogn的时间复杂度，常数空间下，对链表进行排序
 * 解法：归并排序：分治，拆开，merge（排序），这里采用从顶向下
 */
public class OneHundredAndFourtyEight {
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

    public ListNode sortList(ListNode head) {
        // check
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, mid = head, iter = head;
        while (iter != null && iter.next != null) {
            prev = mid;
            mid = mid.next;
            iter = iter.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);

        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0), iter = start;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }

        if (l1 != null) {
            iter.next = l1;
        }

        if (l2 != null) {
            iter.next = l2;
        }

        return start.next;
    }

}
