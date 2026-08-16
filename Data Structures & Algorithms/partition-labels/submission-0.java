class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }
        int max_ind = 0;
        int curr_cnt = 0;
        for(int i=0;i<s.length();i++){
            int id = map.get(s.charAt(i));
            max_ind = Math.max(max_ind, id);
            if(i < max_ind){
                curr_cnt ++;
            } else {
                list.add(curr_cnt + 1);
                curr_cnt = 0;
            }
        }
        return list;
    }
}
