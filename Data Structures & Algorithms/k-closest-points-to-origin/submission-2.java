class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair<Double,int[]>> heap = new PriorityQueue<>((a,b) -> (Double.compare(b.getKey(), a.getKey())));

        for (int[] point : points) {
            double dist = Math.sqrt((point[0]*point[0]) + (point[1]*point[1]));

            Pair<Double,int[]> newPair = new Pair(dist, point);

            heap.add(newPair);

            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[][] resp = new int[heap.size()][2];
        int counter = 0;

        while (!heap.isEmpty()) {
            resp[counter] = heap.remove().getValue();
            counter++;
        }

        return resp;
    }
}
