class Solution {
    public boolean isPalindrome(int x) {
        int original = x;
        int rev = 0;
        if((x<0) || (x%10==0 && x!=0)){
            return false;
        }
        while(x>0){
            int ld = x%10;
            rev = rev*10+ld;
            x/=10;
        }
        return rev == original;
    }
}