class Solution {
    public int minMoves2(int[] nums) {
        int moves = 0;
        int n = nums.length;
        Arrays.sort(nums);
        int median = nums[n/2];
        for(int i=0;i<n;i++){
            moves += Math.abs(nums[i] - median);
        }
        return moves;
    }
}