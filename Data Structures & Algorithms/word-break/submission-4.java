class Solution {
    private boolean helper(String s, Map<String, Integer> map, int [] dp, int start) {
        if(start >= s.length()){
            return true;
        }
        if(dp[start] != -1){
            return dp[start] == 1 ? true : false;
        }
        StringBuilder sb = new StringBuilder();
        boolean ans = false;
        for(int end= start;end < s.length();end ++){
            sb.append(s.charAt(end));
            if(map.containsKey(sb.toString())){
                ans = ans || helper(s, map, dp, end + 1);
            }
        }
        dp[start] = ans == true ? 1 : 0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int dp[] = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<wordDict.size();i++){
            map.put(wordDict.get(i), i);
        }
        return helper(s, map, dp, 0);
    }
}
