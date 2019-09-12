package io.varaga.ds.tries;

public class TrieApp {

	public static void main(String ...args) {
		Trie trie = new Trie();
		trie.insertWord("chakkar");
		System.out.println("Is word found: " + trie.searchWord("chakkar"));//found
		System.out.println("Is word found: " + trie.searchWord("chak"));//not found
		trie.insertWord("chak");
		System.out.println("Is word found: " + trie.searchWord("chak"));//found
		//delete chak
		trie.deleteWord("chak");
		System.out.println("Is word found: " + trie.searchWord("chak"));//deleted
	}
	
}
