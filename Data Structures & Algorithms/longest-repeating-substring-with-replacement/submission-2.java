class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int ans = 0;
        int max_freq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r=0;r<n;r++){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            max_freq = Math.max(max_freq, map.get(s.charAt(r)));
            while(l < n && (r - l + 1 - max_freq) > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                // if(map.get(s.charAt(l)) == 0){
                //     map.remove(s.charAt(l));
                // }
                l ++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
