class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !checkParen(c, stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean checkParen(Character c, Character p) {
        if ((c == '}' && p == '{') ||
          (c == ')' && p == '(') ||
          (c == ']' && p == '[')) {
            return true;
        } else {
            return false;
        }
    }
}
