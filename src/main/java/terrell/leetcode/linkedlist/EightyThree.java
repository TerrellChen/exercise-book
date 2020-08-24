package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 00:04 2020-08-25
 */

/**
 * Description: 83 Remove Duplicates from Sorted List
 * Difficulty: Easy
 * 题目，给出一个有序链表，将重复元素重复的部分移除
 * 解法：将当前元素与下一个非自己相连
 */
public class EightyThree {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode();
        start.next = head;
        if (head == null || head.next == null) {
            return start.next;
        }
        while (head != null && head.next != null) {
            ListNode tmp = head;
            while (head.next != null && head.next.val == head.val) {
                head = head.next;
            }
            tmp.next = head.next;
            head = head.next;
        }
        return start.next;
    }
}
