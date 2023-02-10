package practise.datastructures.BinarySearchTree;

/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 * <p>
 * https://leetcode.com/problems/unique-binary-search-trees/
 * https://leetcode.com/problems/unique-binary-search-trees/solutions/168911/official-solution/?orderBy=most_votes
 */
public class UniqueBinarySearchTrees {
    /**
     * Time complexity : the main computation of the algorithm is done at the statement with G[i].
     * So the time complexity is essentially the number of iterations for the statement,
     * which is ∑i=2n i=(2+n)(n−1)2 to be exact, therefore the time complexity is O(N2)
     * <p>
     * Space complexity : The space complexity of the above algorithm is mainly the storage to keep all the intermediate solutions,
     * therefore O(N)
     */
    public int numTrees(int n) {

        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

}
