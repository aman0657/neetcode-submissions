class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length() > s2.length()){
        return false;
       }
       int n = s1.length();
       int m = s2.length();
       int [] freqS1 = new int[26];
       int [] freqS2 = new int[26];
        int match = 0;
       for(int i=0;i<n;i++){
            freqS1[s1.charAt(i) - 'a'] ++;
            freqS2[s2.charAt(i) - 'a'] ++;
       }
       for(int i=0;i<26;i++){
        if(freqS1[i] == freqS2[i]) {
            match ++;
        }
       }
       int l = 0;
       for(int r=n;r<m;r++){
        char ch = s2.charAt(r);
        freqS2[ch - 'a'] ++;
        if(match == 26){
            return true;
        }
        if(freqS1[ch - 'a'] == freqS2[ch - 'a']){
            match ++;
        } else if(freqS1[ch - 'a'] + 1 == freqS2[ch - 'a'] ){
            match --;
        }
        ch = s2.charAt(l);
        freqS2[ch - 'a'] --;
        if(freqS1[ch - 'a'] == freqS2[ch - 'a']){
            match ++;
        } else if(freqS1[ch - 'a'] - 1 == freqS2[ch - 'a']){
            match --;
        }
        l ++;
       }
    return match == 26;
    }
}
