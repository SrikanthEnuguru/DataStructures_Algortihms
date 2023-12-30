package practise.leetcode75.arraystring;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.

 * Return the merged string.
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 */
public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder result = new StringBuilder();
        int i=0, j = 0;

        while(i<m || j<n){
            if(i<m){
                result.append(word1.charAt(i));
                i++;
            }
            if(j<n){
                result.append(word2.charAt(j));
                j++;
            }
        }
        return result.toString();
    }
}
