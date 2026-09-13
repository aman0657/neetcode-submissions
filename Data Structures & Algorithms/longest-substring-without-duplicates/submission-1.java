class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        int n = s.length();
        int l = 0;
        for(int right=0;right<n;right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right) , 0) + 1);
            while(l < n && map.get(s.charAt(right)) > 1){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l ++;
            }
            length = Math.max(length, right - l + 1);
        }
        return length;
    }
}
