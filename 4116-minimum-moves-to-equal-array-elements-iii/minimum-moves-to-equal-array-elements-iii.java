class Solution {
    public int minMoves(int[] nums) {
        int max=nums[0];
        for(int e:nums){
            if(e>max) max=e;
        }
        int totalMoves = 0;
        for (int e : nums) {
            totalMoves += (max - e);
        }
        
        return totalMoves;
    }
}