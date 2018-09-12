package io.varaga.ds.trees.traversal;

import java.util.LinkedList;
import java.util.Queue;

import io.varaga.ds.trees.Node;

public class BreadthFirstTraversal {

	public void bfTraversal(Node root) {
	   	if (root  == null) {
		  return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node currentNode = queue.remove();
			System.out.println(currentNode.data);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null)
				queue.add(currentNode.right);
		}

	}
}
