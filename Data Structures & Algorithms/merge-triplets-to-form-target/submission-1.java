class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean foundX = false, foundY = false, foundZ = false;
        for(int i=0;i<triplets.length;i++){
            int x = triplets[i][0];
            int y = triplets[i][1];
            int z = triplets[i][2];
            if(x > target[0] || y > target[1] || z > target[2]){
                continue;
            }
            if(x == target[0]){
                foundX = true;
            }
            if(y == target[1]){
                foundY = true;
            }
            if(z == target[2]){
                foundZ = true;
            }
        }
        return foundX && foundY && foundZ;
    }
}
