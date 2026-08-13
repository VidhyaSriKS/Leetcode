class Solution {
    
    static class Node {
        int len = 0;
        int longest = 0;
        int pref = 0;
        int suff = 0;
        char left = 0;
        char right = 0;

        Node() {}

        Node(int len, int longest, int pref, int suff, char left, char right) {
            this.len = len;
            this.longest = longest;
            this.pref = pref;
            this.suff = suff;
            this.left = left;
            this.right = right;
        }
    }

    private Node merge(Node L, Node R) {
        int len = L.len + R.len;
        int longest = Math.max(L.longest, R.longest);
        boolean canPlus = (L.right == R.left);

        if (canPlus) {
            longest = Math.max(longest, L.suff + R.pref);
        }

        int pref = L.pref + ((L.pref == L.len && canPlus) ? R.pref : 0);
        int suff = R.suff + ((R.suff == R.len && canPlus) ? L.suff : 0);

        return new Node(len, longest, pref, suff, L.left, R.right);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        
        int n2 = 1;
        while (n2 < n) {
            n2 <<= 1;
        }

        Node[] tree = new Node[2 * n2];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            tree[i + n2] = new Node(1, 1, 1, 1, c, c);
        }

        for (int i = n2 - 1; i >= 1; i--) {
            tree[i] = merge(tree[i << 1], tree[(i << 1) + 1]);
        }

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i] + n2;
            char c = queryCharacters.charAt(i);

            tree[idx] = new Node(1, 1, 1, 1, c, c);

            for (idx >>= 1; idx >= 1; idx >>= 1) {
                tree[idx] = merge(tree[idx << 1], tree[(idx << 1) + 1]);
            }

            ans[i] = tree[1].longest;
        }

        return ans;
    }
}