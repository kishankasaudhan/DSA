class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] res = new int[nums1.length];
        for(int num : nums2){
            while(!st.isEmpty() && num > st.peek()){
                map.put(st.pop(),num);
            }
            st.push(num);
        }
        while(!st.isEmpty()){
            map.put(st.pop(),-1);
        }
        int i=0;
        for(int e:nums1){
            res[i++] = map.get(e);
        }
        return res;
    }
}