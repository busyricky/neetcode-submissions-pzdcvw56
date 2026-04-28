class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for (char c : map.keySet()) {
            heap.add(map.get(c));
        }

        Queue<Pair<Integer,Integer>> cooldown = new LinkedList<>();
        int cycles = 0;

        while (!heap.isEmpty() || !cooldown.isEmpty()) {
            if (!cooldown.isEmpty() && cooldown.peek().getValue() <= cycles) {
                heap.add(cooldown.poll().getKey());
            }
            
            if (!heap.isEmpty()) {
                int freq = heap.poll() - 1;

                if (freq > 0) {
                    cooldown.add(new Pair<>(freq,cycles+n+1));
                }
            }
            
            cycles++;
        }

        return cycles;
    }
}
