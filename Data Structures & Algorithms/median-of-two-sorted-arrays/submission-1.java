class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] a = nums1;
        int [] b = nums2;
        if(nums1.length > nums2.length){
            a = nums2;
            b = nums1;
        }
        int n = a.length;
        int m = b.length;
        int total = (n + m);
        int half = (total + 1) / 2;
        int l = 0, r = n;
        while(l <= r){
            int i = (l + r) / 2;
            int j = half - i;
            int Aleft = i > 0 ? a[i-1] : Integer.MIN_VALUE;
            int Aright = i < n ? a[i] : Integer.MAX_VALUE;
            int Bleft = j > 0 ? b[j-1] : Integer.MIN_VALUE;
            int Bright = j < m ? b[j] : Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total % 2 != 0){
                    return Math.max(Aleft, Bleft);
                } else {
                    return (double)(Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
                }
            } else if(Aleft > Bright){
                r = i -1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}
