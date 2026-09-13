class TimeMap {
        Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> timestamps = map.get(key);
        if(timestamps == null){
            return "";
        }
        int l = 0, r = timestamps.size() - 1;
        String ans = "";
        while(l <= r){
            int mid = (l + r) / 2;
            Pair curr = timestamps.get(mid);
            if(curr.key <= timestamp){
                ans = curr.value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static class Pair {
        int key;
        String value;
        Pair(int key, String value){
            this.key = key;
            this.value = value;
        }
    }
}
