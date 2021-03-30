package algo.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayCombinationInRecursive {
	public static void main(String[] args) {
		int r = 3;
		int[] input = { 1, 2, 3, 4 };
		List<int[]> result = new ArrayList<>();
		searchCombination(result, input, r, 0);
		result.stream().forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	private static void searchCombination(List<int[]> result, int[] input, int size, int index) {

		if (index < input.length) {
			int[] subArr = Arrays.copyOfRange(input, index, index + size - 1);
			for (int i = index + size - 1; i < input.length; i++) {
				int[] finalArr = Arrays.copyOf(subArr, size);
				finalArr[size - 1] = input[i];
				result.add(finalArr);
			}
			searchCombination(result, input, size, index+1);
		} else {
			return;
		}

	}
}
