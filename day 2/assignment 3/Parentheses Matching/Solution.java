import java.util.Stack;
class Solution {

	public static String isMatching(final String str){
		Stack <Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (i == 0 && (str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')')){
				return "NO";
			}
			if (str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			}
			else if ((str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')') && !stack.isEmpty()) {
				stack.pop();
			}
		}
		if (stack.size() != 0) {
			return "NO";
		}
		return "YES";
	}
}
