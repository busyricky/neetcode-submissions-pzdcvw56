class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (stack.isEmpty()) {
                    remove[i] = true;
                } else {
                    stack.pop();
                }
            } else if (c == '(') {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}