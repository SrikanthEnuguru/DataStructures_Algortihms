package practise.top.easy.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/solutions/186920/official-solution/
 */
public class MinDepth {
    public int minDepth_BFS(TreeNode root) {
        Queue<State> q = new LinkedList<>();
        if (root == null) {
            return 0;
        } else {
            q.add(new State(root, 1));
        }

        int currDepth = 0;
        while (!q.isEmpty()) {
            State state = q.poll();
            TreeNode node = state.node;
            currDepth = state.depth;

            // return the depth for the 1st leaf reached in BFS
            if (node.left == null && node.right == null) {
                break;
            }

            if (node.left != null) {
                q.add(new State(node.left, currDepth + 1));
            }
            if (node.right != null) {
                q.add(new State(node.right, currDepth + 1));
            }
        }
        return currDepth;

    }
}
