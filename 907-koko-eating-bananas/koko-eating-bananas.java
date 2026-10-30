class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        int n = piles.length;
        if(n < 1) return 0;
        //take the max. pile as high
        for(int pile : piles){
            high = Math.max(high,pile);
        }
        int ans = 0;
        //binary search
        while(low <= high){
            long hours = 0;

            int mid = low+(high-low)/2;

            for(int pile : piles){
                hours += (pile + mid - 1) / mid; //for index out of bound(kiya pile mid hi hai)
            }

            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}