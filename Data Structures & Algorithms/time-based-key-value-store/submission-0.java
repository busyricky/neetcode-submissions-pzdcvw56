class TimeMap {

    Map<String, Map<Integer, String>> map;
    Map<String, int[]> keys;

    public TimeMap() {
        map = new HashMap<>();
        keys = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            Map<Integer,String> newMap = new HashMap<>();
            newMap.put(timestamp,value);
            map.put(key, newMap);
        }
        
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            Map<Integer,String> currMap = map.get(key);

            if (currMap.containsKey(timestamp)) {
                return currMap.get(timestamp);
            } else {
                return prevTimeHelper(currMap, timestamp-1);
            }
        } else {
            return "";
        }
    }

    private String prevTimeHelper(Map<Integer,String> currMap, int timestamp) {
        if (timestamp < 1) {
            return "";
        }

        if (currMap.containsKey(timestamp)) {
            return currMap.get(timestamp);
        } else {
            return prevTimeHelper(currMap, timestamp-1);
        }
    }
}
