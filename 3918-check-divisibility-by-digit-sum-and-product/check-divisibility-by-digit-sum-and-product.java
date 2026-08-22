class Solution {
    public boolean checkDivisibility(int n) {
        int sum = digitSum(n);
        int product = digitProduct(n);
        
        int total = sum + product;
        return n % total == 0;
    }

    private static int digitSum(int n) {
        int sum = 0;
        int temp = n; 
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    private static int digitProduct(int n) {
        int pro = 1;
        int temp = n;
        while (temp > 0) {
            pro *= temp % 10;
            temp /= 10;
        }
        return pro;
    }
}