package algo.general;

import java.util.Arrays;

public class SplitWords {
	public static void main(String[] args) {
		String [] input = {"baseballs", "a,all,b,balls,bas,base,cat,code,d,e,quit,z"};
		printResult(input);
	}
	
	private static void printResult(String [] input) {
		String result = "not possible";
		String inputText = input[0];
		int inputLength = inputText.length();
		String [] dictionaries = input[1].split(",");
		//Split into exact two words?
		for(String word:dictionaries) {
			int wordLength = word.length();
			String otherWord = "";
			if(inputText.contains(word)) {
				if(inputText.indexOf(word)+wordLength <= inputLength) {
					if(inputText.indexOf(word) == 0) {
						otherWord = inputText.substring(inputText.indexOf(word)+wordLength);
						if(Arrays.binarySearch(dictionaries, otherWord)>=0) {
							result = word.concat(",").concat(otherWord);
							break;
						}
					} else if(inputText.indexOf(word) > 0 && 
							inputText.indexOf(word)+wordLength == inputLength) {
						otherWord = inputText.substring(0,inputText.indexOf(word));
						if(Arrays.binarySearch(dictionaries, otherWord)>=0) {
							result = otherWord.concat(",").concat(word);
							break;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
