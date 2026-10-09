
class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open++;
            } else {
                // If another ')' is not available, insert one
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; // Consume the second ')'
                } else {
                    insertions++; // Insert the missing ')'
                }

                // This '))' must match an opening '('
                if (open > 0) {
                    open--;
                } else {
                    insertions++; // Insert a missing '('
                }
            }
        }

        // Each unmatched '(' needs two ')'
        insertions += open * 2;

        return insertions;
    }
}
