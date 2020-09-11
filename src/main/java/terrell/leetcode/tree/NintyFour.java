package terrell.leetcode.tree;
/**
 * @author: TerrellChen
 * @version: Created in 23:07 2020-09-11
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 94 Binary Tree Inorder Traversal
 * Difficulty: Medium
 * 题目：中序遍历
 * 解法：中序遍历
 */
public class NintyFour {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode iter = root, prev = null;
        while (iter != null) {
            if (iter.left == null) {
                result.add(iter.val);
                iter = iter.right;
            } else {
                prev = iter.left;
                while (prev.right != null && prev.right != iter) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = iter;
                    iter = iter.left;
                } else {
                    prev.right = null;
                    result.add(iter.val);
                    iter = iter.right;
                }
            }
        }

        return result;
    }
}
