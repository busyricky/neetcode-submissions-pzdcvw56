class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> processed;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        processed = new HashSet<>();

        //build prereqs
        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0], b = prerequisites[i][1];

            if (map.containsKey(b)) {
                map.get(b).add(a);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                map.put(b, list);
            }
        }

        //check for cycles, while keeping track of already processed nodes
        for (int course = 0; course < numCourses; course++) {
            if (!checkCourse(course, processed, new HashSet<>(), map)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCourse(int course, Set<Integer> processed, Set<Integer> currPath, Map<Integer, List<Integer>> map) {
        if (processed.contains(course)) {
            return true;
        }

        if (currPath.contains(course)) {
            return false;
        }

        currPath.add(course);

        if (map.containsKey(course)) {
            for (int prereq : map.get(course)) {
                if (!checkCourse(prereq, processed, currPath, map)) {
                    return false;
                }
            }
        }

        processed.add(course);
        currPath.remove(course);
        return true;
    }
}
