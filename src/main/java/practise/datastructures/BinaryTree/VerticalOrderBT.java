package practise.datastructures.BinaryTree;

import java.util.*;

public class VerticalOrderBT {

    public static void main(String[] args) {
        /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7

        Output: Vertical Order Printing
           4
           2
           1 5 6
           3
           7

        */
        BinaryTree bt = BinaryTreeUtil.createSampleBT();
        printVerticalOrder(bt);
    }

    static void printVerticalOrder(BinaryTree bst) {

        Map<Integer, List<BinaryTreeNode>> map = new TreeMap<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        BinaryTreeNode temp = bst.root;
        int hd = 0;
        temp.hd = hd;
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();
            hd = temp.hd;
            List<BinaryTreeNode> list = map.get(hd);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(temp);
            map.put(hd, list);

            if (temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            List<BinaryTreeNode> list = map.get(it.next());
            for (BinaryTreeNode node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }
}
