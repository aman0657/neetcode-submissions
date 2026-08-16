class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i=0;i<n;i++){
            String curr = tokens[i];
            if(curr.equals("+") || curr.equals("-") || curr.equals("*") || curr.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                result = 0;
                if(curr.equals("+")){
                    result = first + second;
                } else if(curr.equals("-")){
                    result = first - second;
                } else if(curr.equals("*")){
                    result = first * second;
                } else if(curr.equals("/")){
                    if( second == 0)
                    return Integer.MAX_VALUE;
                    result = first / second;
                }
                stack.add(result);
            } else {
                stack.add(Integer.parseInt(curr));
            }
        }
        if(!stack.isEmpty()){
            return stack.pop();
        }
        return result;
    }
}
