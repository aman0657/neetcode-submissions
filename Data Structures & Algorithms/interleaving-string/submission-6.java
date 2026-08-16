class Solution {

    private boolean helper(String s1, String s2, String s3, int i, int j, int [][] dp) {
        if((i + j == s3.length())){
            return i == s1.length() && j == s2.length();
        }
        if(i >= s1.length() && j >= s2.length()){
            return false;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1 ? true : false;
        }

        boolean option1 = false, option2 = false;
        if(i < s1.length() && (i + j) < s3.length() && s1.charAt(i) == s3.charAt(i + j)){
            option1 = helper(s1, s2, s3, i + 1, j, dp);
        } 
        if(j < s2.length() && (i + j) < s3.length() && s2.charAt(j) == s3.charAt(i + j)){
            option2 = helper(s1, s2, s3, i, j + 1, dp);
        }
        option1 = option1 || option2;
        dp[i][j] = option1 == true ? 1 : 0;
        return option1;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        int [][] dp = new int[n+1][m + 1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = -1;
            }
        }
        return helper(s1, s2, s3, 0, 0, dp);
    }
}
