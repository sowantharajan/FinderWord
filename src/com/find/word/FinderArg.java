package com.find.word;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FinderArg {

	String[] inputArgs = null;

	FinderArg(String[] wordArgs) {
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
		List results = map.get(sortedWord(word));
		System.out.println("Arrays of matched words: " + results);
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

		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Send your searching input word: ");
			String inputWord = in.nextLine();
			System.out.println("Send your collection of string input filepath: ");
			String filePath = in.nextLine();
			Path path = new File(filePath).toPath();
			List<String> lines = Files.readAllLines(path);
			String[] thisIsAStringArray = lines.toArray(new String[lines.size()]);
			FinderArg finder = new FinderArg(thisIsAStringArray);
			finder.find(inputWord);
			for (String foundWord : finder.find(inputWord)) {
				// Printed output values
				System.out.println("Each matched words in the arrays: " + foundWord);
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
