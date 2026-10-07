import java.util.*;

class Solution {

    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(String s, int index,
                     int left, int right,
                     int balance, StringBuilder sb) {

        if (index == s.length()) {
            if (left == 0 && right == 0 && balance == 0) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);

        // Remove
        if (c == '(' && left > 0) {
            dfs(s, index + 1, left - 1, right, balance, sb);
        }

        if (c == ')' && right > 0) {
            dfs(s, index + 1, left, right - 1, balance, sb);
        }

        // Keep
        if (c != '(' && c != ')') {

            sb.append(c);
            dfs(s, index + 1, left, right, balance, sb);
            sb.deleteCharAt(sb.length() - 1);

        } else if (c == '(') {

            sb.append(c);
            dfs(s, index + 1, left, right, balance + 1, sb);
            sb.deleteCharAt(sb.length() - 1);

        } else if (balance > 0) {

            sb.append(c);
            dfs(s, index + 1, left, right, balance - 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}