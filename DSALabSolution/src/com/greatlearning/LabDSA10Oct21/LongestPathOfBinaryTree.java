package com.greatlearning.LabDSA10Oct21;

import java.util.ArrayList;

public class LongestPathOfBinaryTree {

	static class Node {
		int data;
		Node leftNode, rightNode;

		Node (int value) {
			data = value;
			leftNode = rightNode = null;
		}
	}

	public static ArrayList <Integer> findLongestPath(Node root) {

		if (root == null) {
			ArrayList <Integer> output = new ArrayList <Integer>();
			return output;
		}

		ArrayList <Integer> leftNodeList = findLongestPath(root.leftNode);

		ArrayList <Integer> rightNodeList = findLongestPath(root.rightNode);


		//compare the Left Node Path with Right Node Path, the root is added to the Longest Path
		if (rightNodeList.size() < leftNodeList.size()) {
			leftNodeList.add(root.data);
		}
		else {
			rightNodeList.add(root.data);
		}

		return (leftNodeList.size() > rightNodeList.size() ? leftNodeList : rightNodeList);
	}



	public static void main(String[] args) {

		
		Node root = new Node(100);
		root.leftNode = new Node(20);
		root.rightNode = new Node(130);
		root.leftNode.leftNode = new Node(10);
		root.leftNode.rightNode = new Node(50);
		root.rightNode.leftNode = new Node(110);
		root.rightNode.rightNode =new Node(140);
		root.leftNode.leftNode.leftNode = new Node(5);
		
		ArrayList <Integer> resultList = findLongestPath(root);

		int resultListSize = resultList.size();

		System.out.println("The Longest Path is");

		for(int i = resultListSize - 1; i>=0; i-- ) {
			System.out.print(resultList.get(i) + (i != 0 ? "->" : ""));
		}
		
		System.out.println("\n");
	}

}
