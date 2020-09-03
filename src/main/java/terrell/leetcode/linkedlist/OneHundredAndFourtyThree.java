package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 23:18 2020-09-03
 */

/**
 * Description: 143 Reorder List
 * Difficulty: Medium
 * 题目：L1->l2->...->Ln-1->Ln 转换为L1->Ln->L1->Ln-1->...
 * 解法：1)遍历一遍找到中点；2)中点之后的链表反转；3)从头开始插入反转后便于遍历的后半截链表
 */
public class OneHundredAndFourtyThree {
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

    public void reorderList(ListNode head) {
        // part 1
        ListNode iter = head, mid = head;
        while (iter != null && iter.next != null) {
            mid = mid.next;
            iter = iter.next.next;
        }

        if (mid == null || mid.next == null) {
            return;
        }
        // part 2
        iter = mid.next;
        mid.next = null;

        ListNode last = iter;
        iter = iter.next;
        last.next = null;
        while (iter != null) {
            ListNode next = iter.next;
            iter.next = last;
            last = iter;
            iter = next;
        }

        // part 3
        iter = head;
        while (iter != null && last != null) {
            ListNode nextOfStart = iter.next;
            ListNode nextOfEnd = last.next;

            iter.next = last;
            last.next = nextOfStart;
            iter = nextOfStart;
            last = nextOfEnd;
        }
    }

    public static void main(String[] args) {
        OneHundredAndFourtyThree oneHundredAndFourtyThree = new OneHundredAndFourtyThree();

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        oneHundredAndFourtyThree.reorderList(listNode);

        System.out.println(listNode.val);

    }
}
