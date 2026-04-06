class Solution {
    class Node {
        int course;
        List<Node> prereqs;

        Node(int course) {
            this.course = course;
            prereqs = new ArrayList<>();
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> classes = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] prereq : prerequisites) {
            if (!classes.containsKey(prereq[1])) {
                Node newPrereq = new Node(prereq[1]);
                classes.put(prereq[1],newPrereq);
            }

            if (classes.containsKey(prereq[0])) {
                classes.get(prereq[0]).prereqs.add(classes.get(prereq[1]));
            } else {
                Node newClass = new Node(prereq[0]);
                newClass.prereqs.add(classes.get(prereq[1]));
                classes.put(prereq[0],newClass);
            }

            indegrees[prereq[1]]++;
        }

        //kahn's algo
        Queue<Node> qu = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                qu.offer(classes.get(i));
            }
        }

        int count = 0;
        while (!qu.isEmpty()) {
            Node curr = qu.poll();
            count++;

            if (curr != null && curr.prereqs != null) {
                 for (Node nei : curr.prereqs) {
                    indegrees[nei.course]--;
                    if (indegrees[nei.course] == 0) {
                        qu.offer(nei);
                    }
                }
            }
            
        }

        return count == numCourses;
    }
}
