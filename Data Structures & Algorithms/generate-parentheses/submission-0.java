class Solution {

    private void helper(List<String> output, StringBuilder sb, int openCnt, int closeCnt, int n) {
        if(openCnt == closeCnt && openCnt == n){
            output.add(sb.toString());
            return;
        }
        if(openCnt > closeCnt){
            sb.append(')');
            helper(output, sb, openCnt, closeCnt + 1, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(openCnt < n){
            sb.append('(');
            helper(output, sb, openCnt + 1, closeCnt, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        helper(output, new StringBuilder(), 0, 0,  n);
        return output;
    }
}
