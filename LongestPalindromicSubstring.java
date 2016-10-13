package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Brute force 
	 * public String longestPalindrome(String s) { String result =
	 * ""; for(int i = 0; i < s.length(); i++){
	 * 
	 * char cur = s.charAt(i); String tmp = ""; for(int j = i; j < s.length(); j
	 * ++ ){ tmp += s.charAt(j); if(palindrome(tmp)){ result = (result.length()
	 * < tmp.length())?tmp:result; } } }
	 * 
	 * return result; } public static boolean palindrome(String tmp){ int i = 0;
	 * int j = tmp.length()-1; while(tmp.charAt(i) == tmp.charAt(j) && i<j){ i
	 * ++; j --; } if(i-j ==1 || i == j){ return true; } return false; }
	 */

//	public String longestPalindrome(String s) {
//		String result = s.substring(0, 1);
//		for (int i = 0; i < s.length(); i++) {
//
//			String tmp = getPalindrome(s, i,i);
//			result = (result.length() < tmp.length()) ? tmp : result;
//			tmp = getPalindrome(s, i,i+1);
//			result = (result.length() < tmp.length()) ? tmp : result;
//			
//		}
//
//		return result;
//	}
//
//	private String getPalindrome(String s, int i,int j) {
//		int start = i;
//		int end = j;
//		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
//			start--;
//			end ++;
//		}
//		return s.substring(start+1, end);
//	}
	
	public String longestPalindrome(String s) {
		String result = s.substring(0, 1);
		for (int i = 0; i < s.length(); i++) {

			String tmp = getPalindrome(s, i,i);
			result = (result.length() < tmp.length()) ? tmp : result;
			tmp = getPalindrome(s, i,i+1);
			result = (result.length() < tmp.length()) ? tmp : result;
			
		}

		return result;
	}

	private String getPalindrome(String s, int i,int j) {
		int start = i;
		int end = j;
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end ++;
		}
		return s.substring(start+1, end);
	}
}
