class Solution {
    public int minInsertions(String s) {
        int need = 0;
        int insertions = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                need += 2;
                if(need % 2 == 1){
                    insertions++;
                    need--;
                }
            }else{
                need--;
                if(need < 0){
                    insertions++;
                    need = 1;
                }
            }
        }
        return need + insertions;
    }
}