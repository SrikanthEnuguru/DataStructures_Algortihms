package practise.top.easy.string;

import java.util.Set;
import java.util.TreeSet;

public class CountPairsOfSimilarStrings {
    public static void main(String[] args) {
        System.out.println(similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"}));
    }
    public static int similarPairs(String[] words) {
        int res = 0;
        if (words == null || words.length == 0) return res;

        int len = words.length;
        for (int i = 0; i < len - 1; i++) {
            String s1 = words[i];
            for (int j = i + 1; j < len; j++) {
                String s2 = words[j];
                if (isSimilar2(s1, s2)) {
                    res = res + 1;
                    ;
                }
            }
        }
        return res;
    }

    public int similarPairs_best(String[] words) {
        int cnt = words.length;
        int[] masks = new int[cnt];
        byte[] buff = new byte[101];
        for (int i = cnt - 1; i >= 0; i--) {
            int n = words[i].length();
            words[i].getBytes(0, n, buff, 0);
            int bits = 0;
            for (int j = n - 1; j >= 0; j--)
                bits |= (1 << (buff[j] - 'a'));
            masks[i] = bits;
        }

        int pairsCount = 0;
        for (int i = 0; i < cnt - 1; i++) {
            int m = masks[i];
            for (int j = i + 1; j < cnt; j++)
                if ((m ^ masks[j]) == 0)
                    pairsCount++;
        }
        return pairsCount;
    }

    public static boolean isSimilar2(String s1, String s2) {
        int[] arr1 = new int[26];
        for (char c : s1.toCharArray()) {
            arr1[c - 'a']++;
        }
        int[] arr2 = new int[26];
        for (char c : s2.toCharArray()) {
            arr2[c - 'a']++;
        }

        for(int i=0;i<26;i++){
            if(arr1[i] !=0 || arr2[i]!=0){
                if(!(arr1[i] >0 && arr2[i]>0)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSimilar1(String s1, String s2) {
        Set<Character> set1 = new TreeSet<>();
        Set<Character> set2 = new TreeSet<>();

        for (char curr : s1.toCharArray()) {
            set1.add(curr);
        }
        for (char curr : s2.toCharArray()) {
            set2.add(curr);
        }

        return set1.equals(set2);
    }
}
