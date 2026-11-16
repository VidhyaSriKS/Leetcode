class Solution {

    public static String digitSum(String num){
        int res = 0;
        for(char c:num.toCharArray()){
            res+= (c-'0');
        }
        return Integer.toString(res);
    }

    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        // int res = 0;
        while(s.length()>k){
            StringBuilder temp = new StringBuilder();
            for(char c:s.toCharArray()){
                sb.append(c);
                if(sb.length()==k){
                    temp.append(digitSum(sb.toString()));
                    sb.delete(0,k);
                }
            }
            if(sb.length()!=0){
                temp.append(digitSum(sb.toString()));
                sb.delete(0,k);
            }
            s = temp.toString();
            temp.delete(0,temp.length());
        }
        return s;
    }
}