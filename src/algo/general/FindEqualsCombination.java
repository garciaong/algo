package algo.general;

import java.util.Arrays;
import java.util.TreeSet;

public class FindEqualsCombination {
	public static void main(String[] args) {
		int[] input = { 10, 2, 20, 5, 8, 15 };
		int r = input.length/2;
		int [] result = new int[r];
		int sum = Arrays.stream(input).sum()/2;
		result = searchEqualsGroup(result, input, r, 0, sum);
		printResult(result,input);
		
	}
	
	private static int [] searchEqualsGroup(int [] result, int[] input, int size, int index, int targetSum) {

		if (index < input.length) {
			int[] subArr = Arrays.copyOfRange(input, index, index + size - 1);
			int sum = 0;
			for(int subItem:subArr) {
				sum += subItem;
			}
			for (int i = index + size - 1; i < input.length; i++) {
				if(sum + input[i] == targetSum) {
					result = Arrays.copyOf(subArr, size);
					result[size-1] = input[i];
					return result;
				}
				
			}
			result = searchEqualsGroup(result, input, size, index+1, targetSum);
		} else {
			return result;
		}
		return result;

	}
	
	private static void printResult(int [] result, int[] input) {
		TreeSet<Integer> set1 = new TreeSet<Integer>();
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		String resultStr = Arrays.toString(result);
		String output = "";
		for(int item:input) {
			if(resultStr.contains(String.valueOf(item))) {
				set1.add(item);
			} else {
				set2.add(item);
			}
		}
		if(set1.first() < set2.first()) {
			output = set1.toString().concat(", ").concat(set2.toString())
					.replaceAll("\\[", "").replaceAll("\\]", "");
		} else {
			output = set2.toString().concat(", ").concat(set1.toString())
					.replaceAll("\\[", "").replaceAll("\\]", "");
		}
		System.out.println(output);
	}
}
