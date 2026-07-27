class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // Opening bracket: push to stack
                stack.push(c);
            } else {
                // Closing bracket: must match top of stack
                if (stack.isEmpty()) {
                    return false; // No matching open bracket
                }
                
                char open = stack.pop();
                
                // Check if types match
                if ((c == ')' && open != '(') ||
                    (c == '}' && open != '{') ||
                    (c == ']' && open != '[')) {
                    return false; // Mismatch
                }
            }
        }
        
        // Stack must be empty (all brackets closed)
        return stack.isEmpty();
    }
}