class Solution {
    public int findNumbers(int[] nums) {
        int c=0;
        for(int e:nums){
            String str=String.valueOf(e);
            int len=str.length();
            if(len%2==0) c++;
        }
        return c;
    }
}