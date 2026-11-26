class Solution {
    private static int sum(int num){
        int sum=0;
        while(num>0){
            int digit=num%10;
            sum+=digit;
            num/=10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=sum(nums[i]);
        }
        Arrays.sort(nums);
        return nums[0];
    }
}