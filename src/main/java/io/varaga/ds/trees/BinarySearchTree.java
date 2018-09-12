package io.varaga.ds.trees;

import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.Finishings;

import io.varaga.ds.trees.traversal.BreadthFirstTraversal;
import io.varaga.ds.trees.traversal.DepthFirstTraversal;

public class BinarySearchTree {

    public Node createNode(int data){
	      return new Node(data);
	}

    public Node findMinValue(Node root) {
    	if(root == null) {
    		return root;
    	}
    	
    	if(root.left != null) {
    		root = findMinValue(root.left);
    	}
    	return root;
    }
    
    public Node insertNode(Node root, int value) {
	     // empty tree if root is null
		 if(null == root){
		    //create the root of the tree
			return root = createNode(value);			
		 }
		 
		 //if there is root, check if the value should be inserted in the left subtree or right subtree
		 if (value < root.data){
			 root.left = insertNode(root.left, value);
		 } else {
			 root.right = insertNode(root.right, value);
		 }		
		 
		 return root;
	 }

    public Node findNode(Node root, int value) {
    	if (root == null) {
    		return null;
    	}
    	if (value == root.data) {
    		return root;
    	}
    	if(value < root.data) {
    		return findNode(root.left, value);
    	} else {
    		return findNode(root.right, value);
    	}
    }
    
    public Node inOrderSuccessor(Node root, int value) {
    	Node node = findNode(root, value);
    	if(node == null) 
    		return null;
    	//case has no right subtree
    	if (node.right == null) {
    		Node successor = null;
    		Node parent = root;
    		while(parent != node) {
    			if (value < parent.data) {
    				successor = parent;
    				parent = parent.left;
    			} else {
    				parent = parent.right;
    			}
    		}
    		return successor;
    	} else {
    		//case node has right subtree
    		return findMinValue(node.right);
    	}
    	
    }
    
    public static void main(String ...args) {
	   
	    final BinarySearchTree bst = new BinarySearchTree();
		final List<Integer> nodeList = Arrays.asList(2,3,4,1,0,10,5,6,7);
		Node rootNode = new Node(5);
		
		nodeList.forEach( number -> bst.insertNode(rootNode, number));
		
		DepthFirstTraversal traversal = new DepthFirstTraversal();
		traversal.inOrderTraversal(rootNode);
		
		// insert 3,2,1,7,8
		
		Node root2 = new Node(3);
		bst.insertNode(root2, 2);
		bst.insertNode(root2, 7);
		bst.insertNode(root2, 8);
		bst.insertNode(root2, 10);
		bst.insertNode(root2, 25);
		bst.insertNode(root2, 15);
		bst.insertNode(root2, 4);
		bst.insertNode(root2, 5);
		
		traversal.inOrderTraversal(root2);
		
		BreadthFirstTraversal bsfT = new BreadthFirstTraversal();
		
		bsfT.bfTraversal(root2);
		
		System.out.print("MinValue: " + bst.findMinValue(root2));
		System.out.print("InOrderSucesor: " + bst.inOrderSuccessor(root2, 15));
	}
}