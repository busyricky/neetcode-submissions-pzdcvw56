class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(
            (a,b) -> (b.getValue() - a.getValue())
        );
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        int resp = 0;

        while (maxHeap.size() > 0) {
            Map.Entry<Character,Integer> entry = maxHeap.poll();
            List<Map.Entry<Character,Integer>> list = new ArrayList<>();
            list.add(entry);

            for (int i = 0; i < n; i++) {
                if (maxHeap.size() == 0) {
                    break;
                }
                entry = maxHeap.poll();
                list.add(entry);
            }

            int taskNum = list.size();

            for (Map.Entry<Character,Integer> e : list) {
                if (e.getValue() > 1) {
                    e.setValue(e.getValue() - 1);
                    maxHeap.offer(e);
                }
            }

            if (maxHeap.size() == 0) {
                resp += taskNum;
            } else {
                resp += n + 1;
            }
        }
        

        return resp;
    }
}
