class TimeMap {

    Map<String, Map<Integer, String>> map;
    Map<String, List<Integer>> ts;

    public TimeMap() {
        map = new HashMap<>();
        ts = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).put(timestamp, value);
            ts.get(key).add(timestamp);
        } else {
            Map<Integer,String> newMap = new HashMap<>();
            newMap.put(timestamp,value);
            map.put(key, newMap);

            List<Integer> list = new ArrayList<>();
            list.add(timestamp);
            ts.put(key, list);
        }        
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            Map<Integer,String> currMap = map.get(key);

            if (currMap.containsKey(timestamp)) {
                return currMap.get(timestamp);
            } else {
                return prevTimeHelper(currMap, timestamp-1, key);
            }
        } else {
            return "";
        }
    }

    private String prevTimeHelper(Map<Integer,String> currMap, int timestamp, String key) {
        List<Integer> nums = ts.get(key);
        
        if (nums.size() == 0 || timestamp < nums.get(0)) {
            return "";
        }

        int left = 0, right = nums.size() - 1, target = timestamp;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (target == nums.get(mid)) {
                return currMap.get(nums.get(mid));
            } else if (target < nums.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right<0 ? currMap.get(nums.get(0)) : currMap.get(nums.get(right));
    }
}
