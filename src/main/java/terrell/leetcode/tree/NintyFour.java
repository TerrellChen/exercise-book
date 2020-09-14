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
 * 解法：Morris 中序遍历
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
        // 算法逻辑如下
        while (iter != null) {
            if (iter.left == null) {
                // 如果当前节点的左孩为空，则读当前节点，然后当前节点移动至其右孩
                result.add(iter.val);
                iter = iter.right;
            } else {
                // 如果当前节点的左孩不为空，则找到当前节点中序遍历下的前驱节点
                // 找到中序下的前驱节点即找到当前节点左子树中最右的一个节点
                prev = iter.left;
                while (prev.right != null && prev.right != iter) {
                    prev = prev.right;
                }
                // 这里要对找到的这个前驱节点做点事情
                if (prev.right == null) {
                    // 如果前驱节点的右节点为空，则设置前驱节点的右节点为当前节点，然后当前节点移动至当前节点的左孩
                    // 这里同时也说明前面的while循环以right == null为逻辑退出
                    prev.right = iter;
                    iter = iter.left;
                } else {
                    // 如果前驱节点的右节点不为空，则将其设置为空，并读当前节点，然后将当前节点移动至当前节点的右孩
                    // 这里同时也说明前面的while循环以right == iter为逻辑退出，即右节点为当前节点
                    // 右节点为当前节点该节点已经经历过当前逻辑判断中，if的另一个逻辑，被作为前驱节点设置过右孩了
                    prev.right = null;
                    result.add(iter.val);
                    iter = iter.right;
                }
            }
        }

        return result;
    }
}
