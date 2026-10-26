class Solution {
    public String finalString(String s) {
        int n=s.length();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch == 'i'){
                res.reverse();
            }
            else{
                res.append(ch);
            }
        }
        return res.toString();
    }
}