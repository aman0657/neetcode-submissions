class Solution {

    private void helper(int n, int openCount, int closedCount, StringBuilder sb, List<String> output) {
        if(openCount == closedCount && closedCount == n){
            output.add(sb.toString());
            return;
        }
        if(openCount > closedCount){
            sb.append(")");
            helper(n, openCount, closedCount + 1, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(openCount < n){
            sb.append("(");
            helper(n, openCount + 1, closedCount, sb, output);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        helper(n, 0, 0, new StringBuilder(), output);
        return output;
    }
}
