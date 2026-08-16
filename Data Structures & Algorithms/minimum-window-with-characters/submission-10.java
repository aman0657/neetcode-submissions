class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        

        int n = s.length(), m = t.length();
        int st = -1, ed = 0;
        for(int i=0;i<m;i++){
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int need = m, have = 0;
        int l = 0;
        int ans = Integer.MAX_VALUE;
        for(int r = 0;r<n;r++){
            char ch = s.charAt(r);
            mapS.put(ch, mapS.getOrDefault(ch,0) + 1);
            if(mapT.containsKey(ch) && mapS.get(ch) <= mapT.get(ch)){
                have ++;
            }
            while(need == have){
                char left = s.charAt(l);
                mapS.put(left, mapS.get(left) - 1);
                if(mapT.containsKey(left) && mapS.get(left) < mapT.get(left)){
                    have --;
                }
                if(ans > (r - l + 1)){
                    st = l;
                    ed = r;
                    ans = r - l + 1;
                }
                l ++;
            }
            
            
            
        }
        if(st == -1){
            return "";
        }
        return s.substring(st, ed + 1);
    }
}
