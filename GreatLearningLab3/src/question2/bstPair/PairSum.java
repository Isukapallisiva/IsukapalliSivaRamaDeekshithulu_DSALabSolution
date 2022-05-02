package question2.bstPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PairSum {
	Node root;

	static class Pair<DT1, DT2> {
		DT1 x;
		DT2 y;

		Pair(DT1 x, DT2 y) {
			this.x = x;
			this.y = y;
		}
	}

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}

		void insert(int value) {
			if (value == data) {
				return;
			}

			if (value < data) {
				if (left == null) {
					left = new Node(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new Node(value);
				} else {
					right.insert(value);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		PairSum ps = new PairSum();
		ps.insert(40);
		ps.insert(20);
		ps.insert(10);
		ps.insert(30);
		ps.insert(60);
		ps.insert(50);
		ps.insert(70);

		List<Integer> list = getSortedElements(ps.root);

		System.out.print("Enter the value required pair sum: ");
		int sum = in.nextInt();

		List<Pair<Integer, Integer>> pairs = findPairWithSum(list, sum);

		if (pairs.isEmpty()) {
			System.out.println("No pair found for the required sum of " + sum);
		} else {
			System.out.println("\nSum = " + sum);
			System.out.println("Pair list: ");

			for (Pair<Integer, Integer> pair : pairs) {
				System.out.println("(" + pair.x + "," + pair.y + ")");
			}

			System.out.println();
		}

		in.close();
	}

	private void insert(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			root.insert(value);
		}
	}

	private static List<Integer> getSortedElements(Node root) {
		List<Integer> result = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Node current = root;
		boolean flag = false;
		while (!flag) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				if (stack.empty()) {
					flag = true;
				} else {
					current = stack.pop();
					result.add(current.data);
					current = current.right;
				}
			}
		}
		return result;
	}

	private static List<Pair<Integer, Integer>> findPairWithSum(List<Integer> list, int sum) {
		List<Pair<Integer, Integer>> pairs = new ArrayList<>();
		int leftIndex = 0;
		int length = list.size();
		int rightIndex = length - 1;
		while (leftIndex < rightIndex) {
			if (list.get(leftIndex) + list.get(rightIndex) < sum) {
				leftIndex++;
			} else if (list.get(leftIndex) + list.get(rightIndex) > sum) {
				rightIndex--;
			} else {
				pairs.add(new Pair<Integer, Integer>(list.get(leftIndex), list.get(rightIndex)));
				leftIndex++;
				rightIndex--;
			}
		}

		return pairs;
	}

	

}
