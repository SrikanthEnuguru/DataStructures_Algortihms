package practise.top.medium.binarytree;


import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode node, List<Integer> result){
        if(node!=null){
            helper(node.left, result);
            result.add(node.val);
            helper(node.right,result);
        }
    }

}
