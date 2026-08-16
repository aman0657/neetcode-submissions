class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [] time = new double[n];
        int [][] arr = new int[n][2];
        
        for(int i=0;i<n;i++){
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (int [] a, int [] b) -> {
            return a[0] - b[0];
        });
        for(int i=0;i<n;i++){
            time[i] = target - arr[i][0];
            time[i] = (double)time[i] / arr[i][1];
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(n-1);
        for(int i=n-2;i>=0;i--){
            double val = time[i];
            if(val > time[stack.peek()]){
                stack.add(i);
            }
        }
        return stack.size();

    }
}
