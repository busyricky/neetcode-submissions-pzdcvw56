class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Pair<Character,Integer>> heap = new PriorityQueue<>((a,b) -> (Integer.compare(b.getValue(), a.getValue())));
        for (char key : map.keySet()) {
            heap.add(new Pair<>(key, map.get(key)));
        }

        StringBuffer sb = new StringBuffer();
        char lastChar = '#';
        while (!heap.isEmpty()) {
            Pair<Character,Integer> pair = heap.poll();
            if (pair.getKey() != lastChar) {
                sb.append(pair.getKey());
                lastChar = pair.getKey();

                if (pair.getValue() - 1 > 0) {
                    heap.add(new Pair<>(pair.getKey(), pair.getValue() - 1));
                }
            } else {
                if (heap.isEmpty()) {
                    return "";
                } else {
                    Pair<Character,Integer> newPair = heap.poll();
                    sb.append(newPair.getKey());

                    lastChar = newPair.getKey();

                    if (newPair.getValue() - 1 > 0) {
                        heap.add(new Pair<>(newPair.getKey(), newPair.getValue() - 1));
                    }
                    heap.add(pair);
                }
            }            
        }

        return sb.toString();
    }
}