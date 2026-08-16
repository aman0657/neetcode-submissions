class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String curr = strs[i];
            int [] cnt = new int[26];
            for(int j=0;j<curr.length();j++){
                cnt[curr.charAt(j) - 'a'] ++;
            }
            String key = Arrays.toString(cnt);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(curr);
        }
        return new ArrayList<>(res.values());
        
    }
}
