class TimeMap {
    Map<String,List<Pair<String,Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Pair<>(value,timestamp));
        } else {
            List<Pair<String,Integer>> newList = new ArrayList<>();
            newList.add(new Pair<>(value,timestamp));
            map.put(key, newList);
        }
    }
    
    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair<String,Integer>> list = map.get(key);
            return binarySearch(list, timestamp);
        }

        return "";
    }

    private String binarySearch(List<Pair<String,Integer>> list, int t) {
        if (list.size() == 0 || t < list.get(0).getValue()) {
            return "";
        }

        int l = 0, r = list.size() - 1, bestSoFar = -1;

        while (l <= r) {
            int mid = l + (r-l)/2;
            int midTs = list.get(mid).getValue();

            if (midTs == t) {
                return list.get(mid).getKey();
            } else if (midTs < t) {
                bestSoFar = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return bestSoFar == -1 ? "" : list.get(bestSoFar).getKey();
    }
}
