class Solution {

    private int helper(int [] dp, String s, int id) {
        if(id > s.length()){
            return 0;
        }
        if(id == s.length()){
            return 1;
        }
        if(s.charAt(id) == '0'){
            return 0;
        }
        if(dp[id] != -1){
            return dp[id];
        }
        int option1 = helper(dp, s, id + 1);
        int option2 = 0;
        if(id + 1 < s.length()){
            if(s.charAt(id) == '1' || (s.charAt(id) == '2' && (s.charAt(id + 1)) < '7')){
                option2 = helper(dp, s, id + 2);
            }
        }
        int ans = option1 + option2;
        dp[id] = ans;
        return ans;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n + 1];
        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        return helper(dp, s, 0);
    }
}
