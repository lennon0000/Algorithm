package string;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " ";
		int r = lengthOfLastWord(s);
		System.out.println(r);
	}

	public static int lengthOfLastWord(String s) {
		int result = 0;
		String[] ss = s.split(" ");
		if(ss.length < 1){
			return 0;
		}
		String tmp = ss[ss.length-1];
		result = tmp.length();
		return result;
	}

}
