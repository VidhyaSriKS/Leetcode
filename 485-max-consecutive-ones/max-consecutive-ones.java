class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int temp = 0;
        for(int num:nums){
            if(num==0){
                res = Math.max(res,temp);
                temp=0;
            }else{
                temp++;
            }
        }
        res = Math.max(temp,res);
        return res;
    }
}