class Solution {

    private boolean helper(String s, Map<String, Integer> map, int start, int [] dp) {
        if(start >= s.length()){
            return true;
        }
        if(dp[start] !=-1){
            return dp[start] == 1 ? true : false;
        }
        StringBuilder sb = new StringBuilder();
        boolean ans = false;
        for(int end=start;end < s.length();end++){
            sb.append(s.charAt(end));
            if(map.containsKey(sb.toString())){
                ans = ans || helper(s, map, end+ 1, dp);
            }
        }
        dp[start] = ans == true ? 1 : 0;
        return ans;
        
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<wordDict.size();i++) {
            map.put(wordDict.get(i), 1);
        }
        int [] dp = new int[s.length()+1];
        for(int i=0;i<s.length()+1;i++){
            dp[i] = -1;
        }
        return helper(s, map, 0, dp);
    }
}
