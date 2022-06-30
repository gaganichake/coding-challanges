package com.codingchallanges.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
 * A ransom note can be formed by cutting words out of a magazine to form a new sentence.
 * How would you figure out if a ransom note (represented as string) can be formed from
 * a given magazine (string)
 *
 * Tips: Keeping track of duplicate words is the key to the solution. Once a word cut-out
 * from the magazine, it can not be reused.
 */
public class MatchNoteWithMagazine {

	public static boolean matchNoteWithMagazine(String note, String magazine) {

		Map<String, Integer> mapMagazineWords = new HashMap<>();
		Map<String, Integer> mapNoteWords = new HashMap<>();

		if(magazine == null || magazine.isEmpty() || note  == null || note.isEmpty()) return false;

		String[] magazineWords = magazine.split(" ");

		for(String word : magazineWords) {
			mapMagazineWords.put(word, mapMagazineWords.containsKey(word) ? mapMagazineWords.get(word) + 1 : 1);
		}

		String[] noteWords = note.split(" ");

		for(String word : noteWords) {
			mapNoteWords.put(word, mapNoteWords.containsKey(word) ? mapNoteWords.get(word) + 1 : 1);
		}

		for(String word : mapNoteWords.keySet()) {


			if(!mapMagazineWords.containsKey(word)
					|| mapMagazineWords.get(word) < mapNoteWords.get(word)) return false;

		}

		return true;
	}

	public static void main(String[] args) {

		String magazine = "This is the magazine from a famous speech where the sentence was taken from that speech";
		String note = "This sentence was taken from the magazine";

		System.out.println(matchNoteWithMagazine(note, magazine));

	}

}
