class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        int n = s.length();
        // min and max left paranthesis i have
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                leftMin ++;
                leftMax ++;
            } else if(s.charAt(i) == ')'){
                leftMin = Math.max(0, leftMin - 1);
                leftMax --;
            } else {
                leftMin = Math.max(0, leftMin - 1);
                leftMax ++;
            }
            if(leftMax < 0){
                return false;
            }
        }
        if(leftMin == 0){
            return true;
        }
        return false;

    }
}
