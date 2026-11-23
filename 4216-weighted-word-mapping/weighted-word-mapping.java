class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for (String s : words) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sum += weights[c - 'a'];
            }
            int t = sum % 26;
            char mapped = (char) ('z' - t);
            sb.append(mapped);
        }

        return sb.toString();
    }
}