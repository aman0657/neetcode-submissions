class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int [][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (int [] a, int [] b) -> {
            return a[0] - b[0];
        });
        double [] time = new double[n];
        for(int i=0;i<n;i++){
            time[i] = (double)(target - arr[i][0]) / arr[i][1];
        }
        Stack<Integer> stk = new Stack<>();
        stk.add(n-1);
        for(int i=n-2;i>=0;i--){
            if(time[i] > time[stk.peek()]){
                stk.add(i);
            }
        }
        return stk.size();
    }
}
