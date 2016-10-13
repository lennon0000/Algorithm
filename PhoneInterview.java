package pocketgem;

public class PhoneInterview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AABBABA";
//		String s = "ABB";
//		String s = "A";
		
		int k = 2;
		int r = getTheMaxLength(s, k);
		System.out.println(r);
	}

	public static int getTheMaxLength(String s, int k) {
		int length = 0;
		int t = 0;
		for (int i = 0; i < s.length(); i++) {
			t = k;
			char tmp = s.charAt(i);
			int j = 0;
			while (t >= 0 && i+j < s.length()) {
				if (s.charAt(i + j) == tmp) {
					j++;
				} else {
					t--;
					j++;
				}
			}
			if(t < 0){
				j --;
			}
			length = Math.max(length, j);
		}
		
		for (int i = s.length()-1; i >= 0; i--) {
			t = k;
			char tmp = s.charAt(i);
			int j = 0;
			while (t >= 0 && i-j >= 0) {
				if (s.charAt(i - j) == tmp) {
					j++;
				} else {
					t--;
					j++;
				}
			}
			if(t < 0){
				j --;
			}
			length = Math.max(length, j);
		}

		return length;
	}

}
