class Solution {

    private int helper(String s, int ind, int [] dp) {
        if(ind > s.length()){
            return 0;
        }
        if(ind == s.length()){
            return 1;
        }
        if(s.charAt(ind) == '0'){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int ans1 = helper(s, ind + 1, dp);
        int ans2 = 0;
        if(ind <= s.length() - 2){
            String temp = s.substring(ind, ind + 2);
            Integer i = Integer.parseInt(temp);
            if(i <= 26 && i >= 10){
                ans2 = helper(s,ind + 2, dp);
            }
        }
        dp[ind] = ans1 + ans2;
        return dp[ind];
    } 
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return helper(s,0, dp);
       

    }
}
