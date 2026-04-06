class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prereqList = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            prereqList.add(new ArrayList<Integer>());
        }

        for (int[] prereq : prerequisites) {
            prereqList.get(prereq[1]).add(prereq[0]);
            indegrees[prereq[0]]++;
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                qu.offer(i);
            }
        }

        int count = 0;
        int[] resp = new int[numCourses];

        while (!qu.isEmpty()) {
            int curr = qu.poll();
            resp[count] = curr;

            for (int nei : prereqList.get(curr)) {
                indegrees[nei]--;
                
                if (indegrees[nei] == 0) {
                    qu.offer(nei);
                }
            }

            count++;
        }

        return count == numCourses ? resp : new int[]{};
    }
}
