class Solution {

    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    private void helper(String s, int start, List<String> sb, List<List<String>> output) {
        if(start >= s.length()){
            output.add(new ArrayList<>(sb));
            return;
        }
        for(int end=start;end<s.length();end++){
            if(isPalindrome(s, start, end)){
                sb.add(s.substring(start, end + 1));
                helper(s, end+1, sb, output);
                sb.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), output);
        return output;
    }
}
