class Solution {
    public int reverseDegree(String s) {
        int vid=0;
        for(int w=0;w<s.length();w++){
            char ch=s.charAt(w);
            vid+=(w+1)*('z'-ch+1);
        }
        return vid;
    }
}
