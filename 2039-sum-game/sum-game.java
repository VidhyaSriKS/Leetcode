class Solution {
    public boolean sumGame(String num) {
        int n = num.length(), n2 = n >> 1;
        int diff = 0;
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            boolean isq = c == '?';
            boolean half = i < n2;
            int sgn = (half ? 1 : 0) * 2 - 1;
            int d = (isq ? 9 : (c - '0') * 2);
            diff += sgn * d;
        }
        return diff != 0;
    }
}