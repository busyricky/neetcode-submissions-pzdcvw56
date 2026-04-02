class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                return false; //not valid string
            }
        }

        return stack.isEmpty();
    }
}
