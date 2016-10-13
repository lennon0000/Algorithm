package string;

//125. Valid Palindrome
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a.";
		boolean r = isPalindrome(s);
		System.out.println(r);

	}

	public static boolean isPalindrome(String s) {
		if (s.length() < 2) {
			return true;
		}

		boolean result = true;
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {

			char tmp = s.charAt(start);
			while (start < end && !Character.isLetterOrDigit(tmp)) {
				start++;
				tmp = s.charAt(start);
			}

			char tmpEnd = s.charAt(end);
			while (start < end && !Character.isLetterOrDigit(tmpEnd)) {
				end--;
				tmpEnd = s.charAt(end);
			}

			if (Character.toLowerCase(tmp) != Character.toLowerCase(tmpEnd)) {// 注意：不用在开始就把所有是大写转换为小写，在这里，需要转换的时候，再转换，速度会快些
				result = false;
				break;
			} else {
				start++;
				end--;
			}
		}

		return result;
	}
}
