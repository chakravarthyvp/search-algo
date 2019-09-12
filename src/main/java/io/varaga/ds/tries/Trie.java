package io.varaga.ds.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Trie. Application for a word complete searches.
 * @author varagac
 *
 */
public class Trie {
	
	TrieNode root;
	
	public Trie() {
		root = new TrieNode(' ');
	}
	
	/**
	 * Inserts the given word into the Trie block and marks the word as complete.
	 * 
	 * @param word - word to insert into.
	 */
	public void insertWord(String word) {
		TrieNode current = root;
		
		for (Character c: word.toCharArray()) {
			if (current.getChildren().get(c) == null) {
				current.getChildren().put(c, new TrieNode(c));
			}
			current = current.getChildren().get(c);
		}
		current.isWord = true;
	}
	
	/**
	 * Checks that the given word is in the Trie.
	 * 
	 * @param word - word to search for
	 * @return - boolean if the word is found and is complete.
	 */
	public boolean searchWord(final String word) {
		TrieNode current = root;
		for (Character c: word.toCharArray()) {
			if (current.getChildren().get(c) == null) {
				return false;
			}
			current = current.getChildren().get(c);
		}
		return current.isWord;
	}

	/**
	 * Marks the word for deletion. The deleted word is left in the Trie, however marked as incomplete.
	 * @see #searchWord(String) - returns false if the word is deleted.
	 * 
	 * @param word - word to mark for deletion/incomplete.
	 * @return true - if the word is complete and if it was marked as deleted.
	 */
	public boolean deleteWord(String word) {
		TrieNode current = root;
		for(Character c: word.toCharArray()) {
			if(current.getChildren().get(c) == null) {
				return false; 
			}
			current =current.getChildren().get(c);
		}
		current.isWord = false;
		return true;
	}
	
}

class TrieNode {
	char character;
	Map<Character, TrieNode> childrenNodes;
	boolean isWord;
	
	public TrieNode(char c) {
		this.character = c;
		childrenNodes = new HashMap<Character, TrieNode>();
	}
	
	public Map<Character, TrieNode> getChildren() {
		return childrenNodes;
	}
}