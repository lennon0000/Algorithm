package string;

public class ZigZag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		int numRows = 2;
		String r = convert(s, numRows);
		System.out.println(r);
	}

	public static String convert(String s, int numRows) {
		if(numRows <= 1){
			return s;
		}
		StringBuilder[] tmps = new StringBuilder[numRows];
		for (int k = 0; k < numRows; k++) {
			tmps[k] = new StringBuilder();
		}
		int length = s.length();
		int i = 0;
		char c;
		while (i < length) {

			for (int j = 0; j < numRows; j++) {
				if (i < length) {
					c = s.charAt(i);
					tmps[j].append(String.valueOf(c));
					i++;
				}else{
					break;
				}
			}
			for (int j = numRows - 2; j > 0; j--) {
				if (i < length) {
					c = s.charAt(i);
					tmps[j].append(String.valueOf(c));
					i++;
				}else{
					break;
				}
			}
		}
		StringBuilder re = new StringBuilder();
		for (int k = 0; k < numRows; k++) {
			re.append(tmps[k]);
		}
		return re.toString();
	}

	/*
	 * 这种用string数组来存的时候，速度会比较慢一些
	 * 所以还是用stringbuilder比较快
	 * 
	public static String convert(String s, int numRows) {
		if(numRows <= 1){
			return s;
		}
		String[] tmps = new String[numRows];
		for (int k = 0; k < numRows; k++) {
			tmps[k] = new String();
		}
		int length = s.length();
		int i = 0;
		char c;
		while (i < length) {

			for (int j = 0; j < numRows; j++) {
				if (i < length) {
					c = s.charAt(i);
					tmps[j] += c;
//					tmps[j].append(String.valueOf(c));
					i++;
				}else{
					break;
				}
			}
			for (int j = numRows - 2; j > 0; j--) {
				if (i < length) {
					c = s.charAt(i);
					tmps[j] += c;
//					tmps[j].append(String.valueOf(c));
					i++;
				}else{
					break;
				}
			}
		}
		String result = "";
		for (int k = 0; k < numRows; k++) {
			result += tmps[k];
		}
		return result;
	}
	*/

}
