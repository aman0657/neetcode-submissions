class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, curr_min = prices[0];
        for(int i=1;i<prices.length;i++){
            max = Math.max(max, prices[i] - curr_min);
            curr_min = Math.min(curr_min, prices[i]);
        }
        return max;
    }
}
