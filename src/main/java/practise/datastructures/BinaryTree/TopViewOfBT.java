package practise.datastructures.BinaryTree;

import java.util.*;

public class TopViewOfBT {
    public static void main(String[] args) {
         /* Constructed binary tree is
                1
              /   \
             2     3
            / \    /\
           4   5  6  7
        */
        BinaryTree bt = BinaryTreeUtil.createSampleBT();
        printTopView(bt);
    }

    static void printTopView(BinaryTree bt) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        BinaryTreeNode temp = bt.root;
        int hd = 0;
        temp.hd = hd;
        q.add(temp);

        while (!q.isEmpty()) {
            temp = q.remove();
            hd = temp.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, temp.data);
                System.out.print(temp.data + " ");
            }
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            //System.out.print(entry.getValue() + " ");
        }
    }
}
