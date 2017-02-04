package graph;

import java.util.*;

/**
 * Created by bhuvanabellala on 2/3/17.
 */
public class RightView {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        Deque<TreeNode> list0 = new ArrayDeque<>();
        if (root != null) {
            list0.add(root);
        }

        while (!list0.isEmpty()) {

            Deque<TreeNode> list1 = new ArrayDeque<>();
            while (!list0.isEmpty()) {
                TreeNode node = list0.remove();
                if (list0.size() == 0) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    list1.add(node.left);
                }

                if (node.right != null) {
                    list1.add(node.right);
                }
            }

            list0 = list1;
        }

        return result;
    }
}
