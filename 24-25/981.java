class TimeMap {

    private Map<String, List<Integer>> mapTime;
    private Map<String, List<String>> mapValue;

    public TimeMap() {
        mapTime = new HashMap<>();
        mapValue = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!mapTime.containsKey(key)) {
            mapTime.put(key, new ArrayList<>());
            mapValue.put(key, new ArrayList<>());
        }
        mapTime.get(key).add(timestamp);
        mapValue.get(key).add(value); 
    }
    
    public String get(String key, int timestamp) {
        if (!mapTime.containsKey(key)) {
            return "";
        }
        if (timestamp < mapTime.get(key).getFirst()) {
            return "";
        }
        int index = find(mapTime.get(key), timestamp);
        return mapValue.get(key).get(index);
    }

    private int find(List<Integer> list, int a) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (list.get(mid) == a) {
                return mid;
            }
            if (list.get(mid) > a) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */