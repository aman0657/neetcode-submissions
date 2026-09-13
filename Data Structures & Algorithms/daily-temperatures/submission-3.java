class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int [] output = new int[n];
        stk.add(n-1);
        for(int i=n-2;i>=0;i--){
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                output[i] = 0;
            } else {
                output[i] = stk.peek() - i;
            }
            stk.add(i);
        }
        return output;
    }
}
