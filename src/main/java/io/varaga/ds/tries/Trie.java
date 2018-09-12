package io.varaga.ds.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    //DS Node for trie
	class TrieNode {
	   Map<Character, TrieNode> children = new HashMap<>();
	   boolean isCompleteWord;
	   
	   TrieNode(boolean isComplete){
	   		//children.put(c, this);
			this.isCompleteWord = isComplete;
	   }
	   
	}
	
	public TrieNode addNode(TrieNode parent, Character c, boolean isComplete) {
		if (parent == null) {
			return new TrieNode(isComplete);
		}
		
		TrieNode child = new TrieNode(isComplete);
		TrieNode node = parent.children.get(c);
		if(node != null) {
			return node;
		}
		parent.children.put(c, child);
		return child;
	}

    public TrieNode getNode(TrieNode tree, String literals) {
		//check edge case
		TrieNode tempNode = tree;
		for (Character c: literals.toCharArray()) {
			tempNode = tempNode.children.get(c);
			if(tempNode == null) {
				return null;
			}
		}
		//we should have the trieNode from the root that has the literals walked through
		return tempNode;
	}

    public static void main(String ...args) {
		Trie trie = new Trie();
		TrieNode root = trie.new TrieNode(false);
		TrieNode child = trie.addNode(root, 'c', false);
		child = trie.addNode(child, 'h', false);
		child = trie.addNode(child, 'a', false);
		child = trie.addNode(child, 'k', false);
		child = trie.addNode(child, 'k', false);
		child = trie.addNode(child, 'u', true);
		child = trie.addNode(child, 'r', false);
		
		//
		child = trie.addNode(root, 'c', false);
		
		child = trie.getNode(root, "c");
		child = trie.addNode(child, 'a', false);
		child = trie.addNode(child, 'r', true);
		child = trie.addNode(child, 't', true);
		
		//getNode
		TrieNode node = trie.getNode(root, "chak");
		System.out.println(node.isCompleteWord);
		node = trie.getNode(root, "chakku");
		System.out.println(node.isCompleteWord);
		node = trie.getNode(root, "chakkur");
		System.out.println(node.isCompleteWord);
		
		node = trie.getNode(root, "ca");
		System.out.println(node.isCompleteWord);
		node = trie.getNode(root, "cart");
		System.out.println(node.isCompleteWord);
		node = trie.getNode(root, "c");
		System.out.println("Size of children for root: " + node.children.size());
		for(Character ca: node.children.keySet()) {
			System.out.println("child for char 'c': " + ca);
		}
		
	}

}