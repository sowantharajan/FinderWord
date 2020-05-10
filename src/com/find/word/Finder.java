package com.find.word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Finder {

	String[] inputArgs = null;

	public Finder(String[] wordArgs) {
		inputArgs = wordArgs;
	}

	public String[] find(String word) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		for (String arrElement : inputArgs) {
			String sortedKey = sortedWord(arrElement);
			List<String> list = new ArrayList<String>();
			list.add(arrElement);
			if (map.containsKey(sortedKey)) {
				map.get(sortedKey).add(arrElement);
			} else {
				map.put(sortedKey, list);
			}
		}
		List results=map.get(sortedWord(word));
		//System.out.println("Arrays of matched words: " + results);
		String[] resultsArr = new String[results.size()];
		return map.get(sortedWord(word)).toArray(resultsArr);
	}

	public String sortedWord(String value) {
		char[] arr = value.toCharArray();
		Arrays.sort(arr);
		String sortedKey = new String(arr);
		return sortedKey;
	}

	public static void main(String[] args) throws Exception {
		String[] thisIsAStringArray = new String[5];
		thisIsAStringArray[0] = "asd";
		thisIsAStringArray[1] = "asdd";
		thisIsAStringArray[2] = "sdda";
		thisIsAStringArray[3] = "glk";
		thisIsAStringArray[4] = "ads";

		Finder finder = new Finder(thisIsAStringArray);
		//finder.find("sad");
		for (String foundWord: finder.find("sad")) {
            System.out.println("Each matched words in the arrays: " + foundWord);
        }
	}
}
