class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int n = s1.length(), m = s2.length();
        int [] freq1 = new int[26];
        int [] freq2 = new int[26];
        for(int i=0;i<n;i++){
            freq1[s1.charAt(i) - 'a'] ++;
            freq2[s2.charAt(i) - 'a'] ++;
        }

        int match = 0;
        for(int i=0;i<26;i++){
            if(freq1[i] == freq2[i]) {
                match ++;
            }
        }
        int l = 0;
        for(int r=n;r<m;r++){
            if(match == 26){
                return true;
            }
            freq2[s2.charAt(r) - 'a'] ++;
            if(freq2[s2.charAt(r) - 'a'] == freq1[s2.charAt(r) - 'a']) {
                match ++;
            }
            if(freq2[s2.charAt(r) - 'a'] - 1 == freq1[s2.charAt(r) - 'a']) {
                match --;
            }

            freq2[s2.charAt(l) - 'a'] --;
            if(freq2[s2.charAt(l) - 'a'] == freq1[s2.charAt(l) - 'a']) {
                match ++;
            }
            if(freq2[s2.charAt(l) - 'a'] + 1 == freq1[s2.charAt(l) - 'a']) {
                match --;
            }
            l ++;
        }
        if(match == 26){
            return true;
        }
        return false;

    }
}
