class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> heap = new PriorityQueue<>(
            (a, b) -> Double.compare(b[0],a[0]) // b is bigger and goes first
        );

        for (int[] point : points) {
            double x = (double) point[0], y = (double) point[1];
            double distance = Math.sqrt(x*x + y*y);

            heap.offer(new double[]{distance,x,y});

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] resp = new int[heap.size()][2];
        int counter = 0;
        for (double[] point : heap) {
            resp[counter] = new int[]{(int) point[1],(int) point[2]};
            counter++;
        }

        return resp;
    }
}
