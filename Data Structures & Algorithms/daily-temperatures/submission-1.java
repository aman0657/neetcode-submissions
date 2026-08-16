class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        stack.add(n-1);
        int [] output = new int[n];
        output[n-1] = 0;
        for(int i=n-2;i>=0;i--){
            int val = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] <= val){
                stack.pop();
            }
            if(stack.isEmpty()){
                output[i] = 0;
            } else {
                output[i] = stack.peek() - i ;
            }
            stack.add(i);
        }
        return output;
    }
}
