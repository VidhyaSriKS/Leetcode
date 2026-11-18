class Solution {
    public int alternatingSum(int[] nums) {

        boolean on = true;
        int sum = 0;

        for(int n : nums){
            if(on){
                sum += n;
            }else{
                sum -= n;
            }
            on = !on;
        }

        return sum;
        
    }
}