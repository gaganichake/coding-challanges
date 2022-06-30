package com.codingchallanges.tree.tries;

import java.util.HashMap;
import java.util.Map;

/*
 * https://en.wikipedia.org/wiki/Trie
 * 
 */
public class Tries {

	Map<Character, Tries> children = new HashMap<>();

	// isEndOfWord is true if the node represents end of a word
	boolean isEndOfWord;

	public boolean hasChildren() {
		return children.isEmpty();
	}
	
	public void add(String word) {
		
		Tries node = this;
		
		for (int level = 0; level < word.length(); level++) {
			
			char c = word.charAt(level);
			
			if (!node.children.containsKey(c))
				node.children.put(c, new Tries());

			node = node.children.get(c);
		}

		// mark last node as leaf
		node.isEndOfWord = true;
	}

	//Searches only complete words.
	public boolean search(String word) {
		
		Tries node = this;
		
		for (int level = 0; level < word.length(); level++) {

			char c = word.charAt(level);

			if (!node.children.containsKey(c))
				return false;

			node = node.children.get(c);
		}

		return (node.isEndOfWord);
	}
	
	public int findPrefix(Tries rootNode, String prefix) {

		Tries node = rootNode;

		for (int level = 0; level < prefix.length(); level++) {
			
			char c = prefix.charAt(level);

			if (!node.children.containsKey(c))
				return 0;

			node = node.children.get(c);
		}

		// Number of words starting with prefix = number of leaf nodes of sub-tries beginning with prefix[Index_of_last_letter]
		return node.countAllLeafNodes();
	}
	
	public int countAllLeafNodes() {
		return countAllLeafNodes(this);
	}
	
	public static int countAllLeafNodes(Tries node) {
		
		int count = 0;
		
		if(node.isEndOfWord) count++;//example: cat, caterpillar
		
		//There could be more words starting with the current node (cat).
		for (char c : node.children.keySet()) {
			
			count+=countAllLeafNodes(node.children.get(c));
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		Tries node = new Tries();
		
		node.add("eddie");
		node.add("edward");
		node.add("edwina");

		System.out.println("Find ed: " + node.search("ed"));//Prefix searched are invalid
		System.out.println("Find eddie: " + node.search("eddie"));
		System.out.println("Find edward: " + node.search("edward"));
		System.out.println("Find edwina: " + node.search("edwina"));
		System.out.println("Find edzz: " + node.search("edzz"));
		System.out.println("Find : " + node.search(""));
	}

}
