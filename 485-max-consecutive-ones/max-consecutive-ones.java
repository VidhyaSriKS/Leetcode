class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int res=0;
        int count=0;
        
        for(int j=0;j<n;j++){
            if(nums[j]==1){
                count++;
            }
            else{
                res=Math.max(res,count);
                count=0;
            }
        }
        return Math.max(count,res);
    }
}