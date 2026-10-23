class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int num = nums[i];
            int rem = 0;
            while(num != 0){
                int digit = num % 10;
                rem += digit;
                num /= 10;
            }
            if(rem == i){
                return i;
            }
        }
        return -1;   
    }
}