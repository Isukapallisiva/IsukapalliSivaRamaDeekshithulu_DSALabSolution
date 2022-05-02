package question1.brackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracketChecker {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter string denoting a bracket sequence:");
		String sequence = in.nextLine().trim().replaceAll("\\s", "");

		if (isBalacingBrackets(sequence)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

		in.close();
	}

	private static boolean isBalacingBrackets(String bracketSequence) {
		Stack<Character> openBracketStack = new Stack<>();

		for (int i = 0; i < bracketSequence.length(); i++) {
			char bracket = bracketSequence.charAt(i);

			if (bracket == '(' || bracket == '[' || bracket == '{') {
				openBracketStack.push(bracket);
				continue;
			}

			if (openBracketStack.isEmpty()) {
				return false;
			}

			char ch;
			switch (bracket) {
			case ')':
				ch = openBracketStack.pop();
				if (ch == '[' || ch == '{') {
					return false;
				}
				break;
			case ']':
				ch = openBracketStack.pop();
				if (ch == '{' || ch == '(') {
					return false;
				}
				break;
			case '}':
				ch = openBracketStack.pop();
				if (ch == '[' || ch == '(') {
					return false;
				}
				break;
			}

		}
		return openBracketStack.isEmpty();
	}
}
