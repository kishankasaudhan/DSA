class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int j = 0;
        int[] nums = new int[n];
        for(int i=0;i<n && j<n;i++){
            nums[j++] = arr[i];
            if(arr[i] == 0 && j<n){
                nums[j++] = 0;
            }
        }
        for(int i=0;i<n;i++){
            arr[i] = nums[i];
        }
    }
}