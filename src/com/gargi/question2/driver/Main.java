package com.gargi.question2.driver;

class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

class Main {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void completeBSTtoSkewed(Node root) {

		if (root == null) {
			return;
		}

		completeBSTtoSkewed(root.left);
		Node rightNode = root.right;
		Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		completeBSTtoSkewed(rightNode);

	}

	static void traverseRightSkewedTree(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewedTree(root.right);
	}

	public static void main(String[] args) {

		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		completeBSTtoSkewed(node);
		System.out.println("The resultant  output is :");
		traverseRightSkewedTree(headNode);
	}
}