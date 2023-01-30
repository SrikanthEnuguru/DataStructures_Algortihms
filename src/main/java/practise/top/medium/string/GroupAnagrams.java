package practise.top.medium.string;

import java.util.*;

public class GroupAnagrams {
    /**
     *
     * Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
     * The outer loop has complexity O(N) as we iterate through each string.
     * Then, we sort each string in O(KlogK) time.
     *
     * Space Complexity: O(NK), the total information content stored in ans.
     */
    public List<List<String>> groupAnagrams1(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);

        }
        return new ArrayList(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for(String str:strs){
            Arrays.fill(count,0);

            for(char c:str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
