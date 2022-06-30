package com.codingchallanges.tree.tries;

public class TriesUsingArray {
	
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;

    TriesUsingArray[] children = new TriesUsingArray[ALPHABET_SIZE];

    // isEndOfWord is true if the node represents
    // end of a word
    boolean isEndOfWord;

    public boolean hasChildren() {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if(children[i] != null) return true;
        }
        return false;
    }
    
    public void add(String word) {
        
    	TriesUsingArray node = this;
        
        int index;

        for (int level = 0; level < word.length(); level++) {
            
            index = word.charAt(level) - 'a';
            
            if (node.children[index] == null)
                node.children[index] = new TriesUsingArray();

            node = node.children[index];
        }

        // mark last node as leaf
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        
    	TriesUsingArray node = this;
        
        int index;

        for (int level = 0; level < word.length(); level++) {

            index = word.charAt(level) - 'a';

            if (node.children[index] == null)
                return false;

            node = node.children[index];
        }

        return (node.isEndOfWord);
    }
    
    public static int findPrefix(TriesUsingArray rootNode, String prefix) {

        int index;
        TriesUsingArray node = rootNode;

        for (int level = 0; level < prefix.length(); level++) {
            
            index = prefix.charAt(level) - 'a';

            if (node.children[index] == null)
                return 0;

            node = node.children[index];
        }

        // Number of words starting with prefix = number of leaf nodes of sub-tries beginning with prefix[Index_of_last_letter]
        return countAllLeafNodes(node);
    }
    
	public int countAllLeafNodes() {
		return countAllLeafNodes(this);
	}
	
	private static int countAllLeafNodes(TriesUsingArray node) {
        
        int count = 0;
        
        if(node.isEndOfWord) count++;
        
        for (int i = 0; i < node.children.length; i++) {
            
            // There are max 26 possible children and some may be null.
            if(node.children[i] != null) {
                
                count+=countAllLeafNodes(node.children[i]);
            }
        }
        
        return count;
    }
}
