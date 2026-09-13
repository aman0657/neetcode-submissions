class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int mostOccured = 0;
        int n = s.length();
        int length = 0;
        int left = 0;
        for(int right=0;right<n;right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            mostOccured = Math.max(mostOccured, map.get(s.charAt(right)));
            while(left < n && (right - left + 1 - (mostOccured))> k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left ++;
            }
            length = Math.max(length, right - left + 1);
        }
        return length;

    }
}
