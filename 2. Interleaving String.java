//RecursionSolution 
//Time Limit Exceeds


class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1length = s1.length();
        int s2length = s2.length();
        int s3length = s3.length();
        if(s1length + s2length != s3length){  // Basic check
            return false;
        }
        return traversal(s1,s2,s3,0,0,0);
    }
    public boolean traversal(String s1, String s2, String s3,int s1len, int s2len, int s3len){
        
        if(s1len == s1.length() && s2len ==s2.length() && s3len ==s3.length() ){
                return true;
        }
        else if(s1len != s1.length() && s2len !=s2.length() &&  s3len == s3.length()){
            return false;
        }
        if(s1len < s1.length()  && s2len < s2.length()){
            if(s3.charAt(s3len) == s1.charAt(s1len) && s3.charAt(s3len) == s2.charAt(s2len)){
                return  traversal(s1,s2,s3,s1len+1,s2len,s3len+1) || traversal(s1,s2,s3,s1len,s2len+1,s3len+1);   // If character match with s1 and s2
            }
            else if(s3.charAt(s3len) == s1.charAt(s1len)){
                return traversal(s1,s2,s3,s1len+1,s2len,s3len+1);
            }else if(s3.charAt(s3len) == s2.charAt(s2len)){
                return traversal(s1,s2,s3,s1len,s2len+1,s3len+1);
            }else{
                return false;
            }
        }else{  //Direct Substring Check
            int s1length = s1.length();
            int s2length = s2.length();
            int s3length = s3.length();
            if(s1len == s1.length() && s2len ==s2.length() && s3len ==s3.length() ){
                return true;
            }
            if(s1len < s1.length()){
                if(s1length - s1len == s3length -s3len){
                   
                    return s1.substring(s1len,s1.length()).equals(s3.substring(s3len,s3.length()));
                }else{
                    return false;
                }
            }else{
                if(s2length - s2len == s3length -s3len){
                    return s2.substring(s2len,s2.length()).equals(s3.substring(s3len,s3.length()));
                }else{
                    return false;
                }
            }
        }
    }
}





//RecursionWith Memo
 public class Solution {
    public boolean is_Interleave(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }
        if (memo[i][j] >= 0) {
            return memo[i][j] == 1 ? true : false;
        }
        boolean ans = false;
        if (s3.charAt(k) == s1.charAt(i) && is_Interleave(s1, i + 1, s2, j, s3, k + 1, memo)
                || s3.charAt(k) == s2.charAt(j) && is_Interleave(s1, i, s2, j + 1, s3, k + 1, memo)) {
            ans = true;
        }
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return is_Interleave(s1, 0, s2, 0, s3, 0, memo);
    }
}