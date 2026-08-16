class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                stk.add(ch);
            } else {
                if(stk.isEmpty()){
                    return false;
                }
                char pop = stk.pop();
                if((ch == '}' && pop == '{') || (ch == ')' && pop == '(') ||(ch == ']' && pop == '[')){
                    continue;
                } 
                return false;
            }
        }
        if(stk.isEmpty())
        return true;
        return false;
    }
}
