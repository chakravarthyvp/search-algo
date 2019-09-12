package io.varaga.ds.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrieNode {
	
	Character thisChar;
	Map<Character, TrieNode> children;
	
	public void insertNode(TrieNode root, String chars) {
		if (root == null) {
			root = new TrieNode();
			root.children = new HashMap<Character, TrieNode>();
		}
		List<Character> listOfChars = new ArrayList<>();
		for (Character c: chars.toCharArray()) {
			listOfChars.add(c);
		}
		Iterator<Character> charIter = listOfChars.listIterator();
		while (charIter.hasNext()) {
			Character c = charIter.next();
			if(root.children == null) {
				root.children = new HashMap<Character, TrieNode>();
			}
			if(root.children.get(c) != null) {
				root = root.children.get(c);
				continue;
			}
			TrieNode cNode = new TrieNode();
			cNode.children = new HashMap<Character, TrieNode>();
			cNode.thisChar = c;
			root.children.put(c, cNode);
			root = cNode;
		}
	}
	
	public void traverseTrie(TrieNode trie) {
		if (trie == null) {
			return;
		}
		if (trie != null) {
			System.out.println(trie.thisChar);
		}
		if (trie.children != null) {
			trie.children.keySet().forEach(key -> {
				traverseTrie(children.get(key));
			});
		}
	}
	
	public static void main(String ...args) {
		TrieNode root = new TrieNode();
		root.insertNode(root, "Chakkar");
		root.traverseTrie(root);
	}
}
