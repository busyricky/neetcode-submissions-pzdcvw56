class TimeMap {
    Map<Integer, Map<String, String>> map;
    Map<String, List<Integer>> tsMap;
    

    public TimeMap() {
        map = new HashMap<>();
        tsMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(timestamp)) {
            map.get(timestamp).put(key,value);
        } else {
            Map<String, String> kvMap = new HashMap<>();
            kvMap.put(key, value);
            map.put(timestamp, kvMap);
        }

        if (tsMap.containsKey(key)) {
            tsMap.get(key).add(timestamp);
        } else {
            tsMap.put(key, new ArrayList<>(List.of(timestamp)));
        }
    }
    
    public String get(String key, int timestamp) {
        if (map.get(timestamp) != null && map.get(timestamp).get(key) != null) {
            return map.get(timestamp).get(key);
        }
        else if (!tsMap.containsKey(key)) {
            return "";
        }
        else {
            List<Integer> list = tsMap.get(key);
            int l = 0, r = list.size() - 1;

            while (l <= r) {
                int mid = l + (r-l)/2;

                if (list.get(mid) == timestamp) {
                    r = mid;
                    break;
                } else if (list.get(mid) < timestamp) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return (r < 0) ? "" : map.get(list.get(r)).get(key);
        }
    }
}
