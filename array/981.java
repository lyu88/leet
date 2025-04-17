class TimeMap {

    private Map<String, List<Pair>> map;

    private static class Pair {
        int timestamp;
        String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = map.get(key);
        int left = 0, right = pairs.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (pairs.get(mid).timestamp == timestamp) {
                result = pairs.get(mid).value;
                break;
            } else if (pairs.get(mid).timestamp < timestamp) {
                result = pairs.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */