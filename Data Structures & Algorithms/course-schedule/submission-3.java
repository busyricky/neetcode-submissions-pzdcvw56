class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] processed = new boolean[numCourses];

        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            map.get(prereq[1]).add(prereq[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, processed, new HashSet<>())) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer,List<Integer>> map, boolean[] processed, Set<Integer> currPath) {
        if (processed[course]) {
            return true;
        }

        if (currPath.contains(course)) {
            return false;
        }
        currPath.add(course);

        for (int nextClass : map.get(course)) {
            if (!dfs(nextClass, map, processed, currPath)) {
                return false;
            }
        }

        currPath.remove(course);
        processed[course] = true;

        return true;
    }
}
