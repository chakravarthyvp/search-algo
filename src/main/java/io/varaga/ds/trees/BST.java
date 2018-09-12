package io.varaga.ds.trees;

import io.varaga.ds.trees.traversal.DepthFirstTraversal;

public class BST {
	
	public Node insertNode(Node root, int value) {
		//
		if(root == null) {
			root = new Node(value);
			return root;
		}
		
		if (value <= root.data) {
			root.left = insertNode(root.left, value);
		} else {
			root.right = insertNode(root.right, value);
		}
		
		return root;
	}
	
	public static void main(String ...args) {

	     BST bst = new BST();
		 Node root = new Node(35);
		 
		 bst.insertNode(root, 37);
		 bst.insertNode(root, 67);
		 bst.insertNode(root, 45);
		 bst.insertNode(root, 56);
		 bst.insertNode(root, 87);
		 bst.insertNode(root, 97);
		 bst.insertNode(root, 85);
		 bst.insertNode(root, 12);
		 bst.insertNode(null, 13);
		 
		 DepthFirstTraversal traversal = new DepthFirstTraversal();
		 System.out.println("\n PreOrder");
		 traversal.preOrder(root);
		 
		 System.out.println("\n PostOrder");
		 traversal.postOrder(root);
		 
		 System.out.println("\n InOrder");
		 traversal.inOrderTraversal(root);
	}
}


