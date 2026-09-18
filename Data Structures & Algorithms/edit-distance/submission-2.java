class Solution {

    private int helper(String word1, String word2, int n, int m, int i, int j, int [][] dp) {
        if(i >= word1.length()){
            return word2.length() - j;
        }
        if(j >= word2.length()){
            return word1.length() - i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int option1 = Integer.MAX_VALUE, option2 = Integer.MAX_VALUE, option3 = Integer.MAX_VALUE, option4 = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            option1 = helper(word1, word2, n, m, i + 1, j + 1, dp);
        } else {
            option2 = helper(word1, word2, n, m, i, j + 1, dp);
            option3 = helper(word1, word2, n, m, i + 1, j, dp);
            option4 = helper(word1, word2, n, m, i + 1, j + 1, dp);

            if(option2 != Integer.MAX_VALUE){
                option2 ++;
            }
            if(option3 != Integer.MAX_VALUE){
                option3 ++;
            }
            if(option4 != Integer.MAX_VALUE){
                option4 ++;
            }
        }
        int ans = Math.min(option1, Math.min(option2, Math.min(option3, option4)));
        dp[i][j] = ans;
        return ans;

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = -1;
            }
        }
        return helper(word1, word2, n, m, 0, 0, dp);

    }
}
