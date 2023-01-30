package practise.top.medium.binarytree;

import java.util.Stack;

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        int max_so_far = Integer.MIN_VALUE;
        return dfs(root, max_so_far);
    }

    public int dfs(TreeNode node, int currMax){
        if(node==null) return 0;

        int l = dfs(node.left, Math.max(node.val, currMax));
        int r = dfs(node.right, Math.max(node.val, currMax));

        int ans = l+r;
        if(node.val>=currMax){
            ans++;
        }

        return ans;
    }

    public int goodNodes_Iterative(TreeNode root) {
        if(root == null) return 0;

        Stack<GoodNodesCountState> stack = new Stack<>();
        stack.push(new GoodNodesCountState(root, Integer.MIN_VALUE));
        int ans=0;

        while(!stack.isEmpty()){
           GoodNodesCountState state = stack.pop();
            TreeNode node = state.node;
            int currMax = state.currMax;
            if(node.val>=currMax){
                ans++;
            }
            if(node.left!=null){
                stack.push(new GoodNodesCountState(node.left, Math.max(node.val, currMax)));
            }
            if(node.right!=null){
                stack.push(new GoodNodesCountState(node.right, Math.max(node.val, currMax)));
            }
        }
        return ans;
    }
}

class GoodNodesCountState{
    TreeNode node;
    int currMax;
    GoodNodesCountState(TreeNode node, int currMax){
        this.node=node;
        this.currMax=currMax;
    }
}
