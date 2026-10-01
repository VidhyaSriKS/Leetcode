class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> set=new HashSet<>(Arrays.asList(bannedWords));
        int count=0;
        for(String s:message){
            if(set.contains(s)){
                count ++;
            }
        }
        return (count>=2)?true:false;
    }
}