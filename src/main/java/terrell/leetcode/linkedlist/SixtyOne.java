package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 22:21 2020-08-21
 */

/**
 * Description: 61 Rotate List
 * Difficulty: Medium
 * 题目： 将给定链表按右移指定位
 * 解法：将链表连成圈，将后移根据长度算出前移，然后前移并拆断链表
 */
public class SixtyOne {
    public static class ListNode {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode point = head;
        int len = 1;
        while (point.next != null) {
            len++;
            point = point.next;
        }
        int forward = 0;
        if (k < len) {
            forward = len - k - 1;
        } else {
            forward = (len - (k%len) - 1);
        }
        point.next = head;

        for (; forward >= 0; forward--) {
            point = point.next;
        }

        head = point.next;
        point.next = null;
        return head;
    }

    public static void main(String[] args) {
        SixtyOne sixtyOne = new SixtyOne();
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);

        ListNode result = sixtyOne.rotateRight(first, 2);
        System.out.println(result.val);

        first = new ListNode(0);
        first.next = new ListNode(1);
        first.next.next = new ListNode(2);
        result = sixtyOne.rotateRight(first, 4);
        System.out.println(result.val);

        first = new ListNode(1);
        first.next = new ListNode(2);
        result = sixtyOne.rotateRight(first, 2);
        System.out.println(result.val);
    }
}
