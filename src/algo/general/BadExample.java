package algo.general;

public class BadExample {

	public static void main(String[] args) {
		String[] inputs = { "baseballs", "a,all,b,balls,bas,base,cat,code,d,e,quit,z" };
		System.out.print(wordSearch(inputs));
	}

	public static String wordSearch(String[] strArr) {
		// code goes here
		String result = "not possible";
		String input = strArr[0];
		String splitInput = "";
		String[] dictionaries = strArr[1].split(",");
		int size = dictionaries.length;
		for (int i = 0; i < size; i++) {
			String check = dictionaries[i];
			if (input.indexOf(check) != -1) {
				splitInput = input.substring(check.length());
				for (int j = 0; j < size; j++) {
					String check2 = dictionaries[j];
					if (!check2.equals(check) && check2.equals(splitInput)) {
						return check.concat(",").concat(splitInput);
					}
				}
			}

		}
		return result;
	}
}
