class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1, n = arr.length;
        int id = 0;
        while(l <= r){
            int mid = (l + r) / 2;
            if(arr[mid] <= x) {
                id = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = id;
        r = id + 1;
        System.out.println(l + " " + r);
        int cnt = 0;
        while(cnt < k){
            int leftDiff = Integer.MAX_VALUE, rightDiff = Integer.MAX_VALUE;
            if(l >= 0){
                leftDiff = Math.abs(x - arr[l]);
            }
            if(r < n){
                rightDiff = Math.abs(arr[r] - x);
            }
            if(leftDiff <= rightDiff){
                l --;
            } else {
                r ++;
            }
            cnt ++;
        }
        List<Integer> output = new ArrayList<>();
        System.out.println(l + " " + r);
        l = Math.max(l, -1);
        r = Math.min(r, n+1);
        for(int i=l+1;i<r;i++){
            output.add(arr[i]);
        }
        return output;

        
    }
}