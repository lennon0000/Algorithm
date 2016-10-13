package string;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String reverseString(String s) {
		char[] ss = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			char tmp = ss[start];
			ss[start] = ss[end];
			ss[end] = tmp;
			start++;
			end--;
		}
		String result = new String(ss);
		return result;
	}
}
