package string;

public class ImplementStrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "miss";
		String needle = "a";
		int r = strStr(haystack, needle);
System.out.println(r);
	}

	public static int strStr(String haystack, String needle) {
		int result = -1;
		if(haystack.equals(needle)){
			return 0;
		}
		int needLength = needle.length();
		int haystackLength = haystack.length();
		for(int i = 0; i <=  haystackLength - needLength; i++ ){
			if(haystack.charAt(i) == needle.charAt(0)){
				if(haystack.substring(i, i+needLength).equals(needle)){
					return i;
				}
			}
		}

		return result;
	}

}
