class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n1=nums.length;
        int n2=nums.length*2;
        int[] res=new int[n2];
    
        for(int i=0;i<nums.length;i++){
            res[i]=nums[i];
        }
        int k=0;
        for(int i=n2-1;i>=n1;i--){
            res[i]=nums[k++];
        }
        return res;
    }
}