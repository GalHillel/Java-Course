package EX3;

import java.util.ArrayList;

/**
 * Assignment 3: String Processing and Rational Numbers
 * 
 * This class provides string processing utilities for:
 * - Parsing sentences into word arrays
 * - Building sorted dictionaries of unique words from text
 * 
 * @author University Assignment
 * @version 1.0
 */
public class EX3 {

	/**
	 * Parses a sentence into an array of words.
	 * 
	 * Splits the input string on spaces, periods, and commas,
	 * extracting individual words while preserving their original case.
	 * 
	 * @param sentence Input string to parse
	 * @return Array of words extracted from the sentence
	 */
	public static String[] sentence(String sentence) {
		ArrayList<String> words = new ArrayList<String>();
		String currentWord = "";

		// Extract words by splitting on delimiters
		for (int index = 0; index < sentence.length(); index++) {
			char character = sentence.charAt(index);
			if (character != ' ' && character != '.' && character != ',') {
				currentWord += character;
			} else {
				if (currentWord.length() > 0) {
					words.add(currentWord);
					currentWord = "";
				}
			}
		}

		// Add the last word if present
		words.add(currentWord);

		// Convert ArrayList to array
		String[] wordArray = new String[words.size()];
		for (int i = 0; i < words.size(); i++) {
			wordArray[i] = words.get(i);
		}
		return wordArray;
	}

	/**
	 * Builds a sorted dictionary of unique words from a text string.
	 * 
	 * This method:
	 * 1. Extracts words from the input (splitting on spaces, periods, commas)
	 * 2. Converts all words to lowercase
	 * 3. Sorts words alphabetically
	 * 4. Removes duplicates
	 * 
	 * @param text Input string to process
	 * @return Sorted array of unique lowercase words
	 */
	public static String[] dictionary(String text) {
		ArrayList<String> allWords = new ArrayList<String>();
		ArrayList<String> uniqueWords = new ArrayList<String>();
		String currentWord = "";

		// Extract and lowercase all words
		for (int index = 0; index < text.length(); index++) {
			char character = text.charAt(index);
			if (character != ' ' && character != '.' && character != ',') {
				currentWord += character;
				currentWord = currentWord.toLowerCase();
			} else {
				if (currentWord.length() > 0) {
					allWords.add(currentWord);
					currentWord = "";
				}
			}
		}
		allWords.add(currentWord);

		// Convert to array for sorting
		String[] sortedWords = new String[allWords.size()];
		for (int i = 0; i < allWords.size(); i++) {
			sortedWords[i] = allWords.get(i);
		}

		// Bubble sort alphabetically
		for (int i = 0; i < sortedWords.length - 1; i++) {
			for (int j = i + 1; j < sortedWords.length; j++) {
				if (sortedWords[i].compareTo(sortedWords[j]) > 0) {
					String temp = sortedWords[i];
					sortedWords[i] = sortedWords[j];
					sortedWords[j] = temp;
				}
			}
		}

		// Remove duplicates
		uniqueWords.add(sortedWords[0]);
		for (int i = 1; i < sortedWords.length - 1; i++) {
			if (sortedWords[i].compareTo(sortedWords[i + 1]) != 0 &&
					sortedWords[i].compareTo(sortedWords[i - 1]) != 0) {
				uniqueWords.add(sortedWords[i]);
			}
			if (i == sortedWords.length - 2) {
				uniqueWords.add(sortedWords[i + 1]);
			}
		}

		// Convert unique words to array
		String[] uniqueWordArray = new String[uniqueWords.size()];
		for (int i = 0; i < uniqueWords.size(); i++) {
			uniqueWordArray[i] = uniqueWords.get(i);
		}
		return uniqueWordArray;
	}
}
