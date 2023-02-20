package practise.top.medium.graph;

import java.util.*;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * https://leetcode.com/problems/number-of-provinces/solutions/127619/friend-circles/
 */
public class NumberOfProvinces {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;
    public int findCircleNum1(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        seen = new boolean[n];

        for(int i=0;i<n;i++){
            if(!graph.containsKey(i)){
                graph.put(i, new ArrayList<>());
            }
            for(int j=i+1; j<n;j++){
                if(!graph.containsKey(j)){
                    graph.put(j, new ArrayList<>());
                }
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!seen[i]){
                ans++;
                seen[i]=true;
                dfs_rec(i);
            }
        }
        return ans;
    }

    public void dfs_rec(int node){
        for (int neighbour: graph.get(node)){
            if(!seen[neighbour]){
                seen[neighbour]=true;
                dfs_rec(neighbour);
            }
        }
    }

    public void dfs_iterative(int start){
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int node = stack.pop();
            for(int neighbour:graph.get(node)){
                if(!seen[neighbour]){
                    seen[neighbour]=true;
                    stack.push(neighbour);
                }
            }
        }
    }
}
