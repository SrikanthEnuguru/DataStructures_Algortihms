package practise.top.medium.dp;

/**
 * Given an array of numbers and a diff value, count no of subsets with the given diff
 *
 * Input = [3,1,2,3] diff=3
 * Output =3
 * [3,1,2][3] = 6-3 =3
 * [3,3][1,2] = 6-3 =3
 * [1,2,3][3]= 6-3=3
 *
 * https://www.youtube.com/watch?v=QihB4bI6BJw&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=12
 */
public class CountSubsetsWithGivenDifference {

    public static void main(String[] args) {
        System.out.println(count(new int[]{3,1,2,3}, 3));
    }
    public static int count(int[] nums, int diff){
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        // s1-s2 = diff ; s1+s2 =sum => s1= (diff+sum)/2
        int subsetSum = (diff+sum)/2;
        int n=nums.length;

        int[][] dp = new int[n+1][subsetSum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=subsetSum;j++){
                if(j==0){
                    dp[i][j]=1;
                } else if(i==0){
                    dp[i][j]=0;
                } else if(nums[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j]= dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][subsetSum];
    }
}
