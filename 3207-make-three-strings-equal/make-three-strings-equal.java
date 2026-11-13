class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        
        if (s1.charAt(0) != s2.charAt(0) || s1.charAt(0) != s3.charAt(0) || s2.charAt(0) != s3.charAt(0)) {
            return -1;
        }

        int minLen = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int commonLength = 0;

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        return (s1.length() - commonLength) + (s2.length() - commonLength) + (s3.length() - commonLength);
    }
}