/**
 *
 *@author      Abhiram Rayala
 *
 * This class describes a solution.
 */
final class Solution {

	/**
	 * Constructs a new instance.
	 */
	private Solution() {
		//not called
	}

	/**
	 * Determines whether the specified string is matching.
	 *
	 * @param      str   The string
	 *
	 * @return     True if the specified string is matching, False otherwise.
	 */
	public static String isMatching(final String str) {
		Stack<Character> stack = new Stack<Character>();
		int length = str.length();
		if (str.charAt(0) == '}' || str.charAt(0) == ')' || str.charAt(0) == ']') {
			return "NO";
		}
		for (int i = 0 ; i < length ; i++) {
			char element = str.charAt(i);
			if (element == '{' || element == '(' || element == '[') {
				stack.push(element);
			} else {
				if (!evaluate(stack, element)) {
					return "NO";
				}
			}
		}
		if (stack.isEmpty()) return "YES";
		else return "NO";
	}


	/**
	 * Evaluates whether the char is top of stack
	 *
	 * @param      stack  The stack
	 * @param      c      letter
	 *
	 * @return     true if it is on top else false
	 */
	static boolean evaluate(final Stack<Character> stack ,final  char letter) {
		switch (letter) {
		case '}':
			if (stack.peek() == '{') {
				stack.pop();
			} else {
				return false;
			}
			break;
		case ']':
			if (stack.peek() == '[') {
				stack.pop();
			} else {
				return false;
			}
			break;
		case ')':
			if (stack.peek() == '(') {
				stack.pop();
			} else {
				return false;
			}
			break;
		}
		return true;
	}
}
