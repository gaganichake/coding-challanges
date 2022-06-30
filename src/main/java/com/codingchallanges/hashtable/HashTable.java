package com.codingchallanges.hashtable;

import java.util.LinkedList;
import java.util.List;

/* Implement HashTable
 *
 * Approach I: Using Array - Array size must be large enough to accommodate unique hashes.
 * Approach II: Using Array and Linked List - If Array size is large, Linked List will be shorter, vice a versa.
 * Approach III: Using Binary Search Tree - Array is not required.
 */

public class HashTable<K, V> {

	private final int MAX_SIZE = 1000;

	private final LinkedList<Node<K, V>>[] array;

	public HashTable() {
		array = new LinkedList[MAX_SIZE];
	}

	public static class Node<K, V> {

		private final K key;
		private final V val;

		private Node(K key, V val) {
			this.key = key;
			this.val = val;
		}

		public K getKey() {
			return key;
		}

		public V getVal() {
			return val;
		}
	}


	// Approach II
	public void put(K key, V val){

		int index = hashCode(key);

		LinkedList<Node<K, V>> list  = array[index];

		if(list == null) {
			list = new LinkedList<>();
			array[index] = list;
		}

		for(Node<K, V> node : list) {
			if(node.key.equals(key)) {
				list.remove(node);
				break;
			}
		}
		list.add(new Node<>(key, val));
	}

	// Approach II
	public V get(K key) {

		int index = hashCode(key);

		LinkedList<Node<K, V>> list = array[index];// An unknown key may also return an index of valid LinkedList

		if(list == null) return null;

		for(Node<K, V> node : list) {
			if(node.key.equals(key)) return node.getVal();
		}

		return null;
	}


	private int hashCode(Object key) {
		return Math.abs(key.hashCode()) % MAX_SIZE;
	}

	public static void main(String[] args) {

		HashTable<String, Integer> hashtable = new HashTable<>();

		hashtable.put("Peoria", 61615);
		hashtable.put("Moline", 67112);

		for(int i = 0; i < 200; i++) {
			hashtable.put("Key"+i, i);
		}

		System.out.println("ZIP code for Peoria: " + hashtable.get("Peoria"));
		System.out.println("ZIP code for Moline: " + hashtable.get("Moline"));
		System.out.println("ZIP code for Key0: " + hashtable.get("Key0"));
		System.out.println("ZIP code for Key50: " + hashtable.get("Key50"));
		System.out.println("ZIP code for Key199: " + hashtable.get("Key199"));
		System.out.println("ZIP code for Key222: " + hashtable.get("Key222"));// This key does not exist
	}

}
