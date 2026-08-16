class Solution {

    HashMap<Integer, String> map = new HashMap<>();
    Solution(){
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    private List<String> helper(String digits) {
        if(digits.length() == 0){
            return List.of("");
        }
        List<String> child = helper(digits.substring(1));
        List<String> output = new ArrayList<>();
        String curr = map.get(digits.charAt(0) - '0');
        int len = curr.length();
        for(int i=0;i<len;i++){
            char ch = curr.charAt(i);
            for(int j=0;j<child.size();j++){
                output.add( ch + child.get(j));
            }
        }
        return output;

    }
    public List<String> letterCombinations(String digits) {
         if(digits.length() == 0){
            return List.of();
        }
        return helper(digits);
    }
}
