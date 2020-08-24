package terrell.leetcode.linkedlist;
/**
 * @author: TerrellChen
 * @version: Created in 23:45 2020-08-24
 */

/**
 * Description: 82 Remove Duplicates from Sorted List II
 * Difficulty: Medium
 * 题目：给出了一个排序过的链表，删去其中重复的元素
 * 解法：遍历，保留上一个元素和当前元素，如果在找到下一个不相同元素前，当前元素存在重复，则链接上一个元素和下一个元素，否则指针全部进一
 */
public class EightyTwo {
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
        ListNode last = start;
        while (head != null && head.next != null) {
            ListNode tmp = head;
            boolean find = false;
            while (head.next.val == head.val) {
                find = true;
                head = head.next;
                if (head.next == null) {
                    break;
                }
            }
            if (find) {
                last.next = head.next;
                head = head.next;
            } else {
                last = tmp;
                head = tmp.next;
            }
        }
        return start.next;
    }

}
