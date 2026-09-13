class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            int [] fre = new int[26];
            String curr = strs[i];
            for(int j=0;j<curr.length();j++){
                fre[curr.charAt(j) - 'a'] ++;
            }
            String key = Arrays.toString(fre);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(curr);
        }
        return new ArrayList<>(map.values());
    }
}
