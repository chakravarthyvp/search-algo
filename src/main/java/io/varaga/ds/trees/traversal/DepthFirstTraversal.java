package io.varaga.ds.trees.traversal;

import io.varaga.ds.trees.Node;

/**
 * Depth First Traversal of Binary Trees.
 */
public class DepthFirstTraversal {
	
	   /**
	    * left, root, right. complete left tree and then root, finally right tree
		* gives ordered sorted list
		*/
	   public void inOrderTraversal(Node root) {
	       // root null
		   if (null == root) {
		       return;
		   }
		   
		   inOrderTraversal(root.left);
		   System.out.println(root.data);  
		   inOrderTraversal(root.right);
		   
	   }
	   
	   /**
	    * Pre order travesal
	    * root, left, root 
	    */
	   
	   public void preOrder(Node root) {
		   
		   if (null == root) {
			   return;
		   }
		   
		   System.out.println(root.data);
		   preOrder(root.left);
		   preOrder(root.right);
		   
	   }
	   
	   /**
	    * Post Order
	    * Vist left, vist right and then root
	    */
	   public void postOrder(Node root) {
		   if(null == root) {
			   return;
		   }
		   
		   postOrder(root.left);
		   postOrder(root.right);
		   System.out.println(root.data);
	   }

	}