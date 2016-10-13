package string;

public class MyAtoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2147483648";
		int r = myAtoi(str);
	}

	public static int myAtoi(String str) {
		double result = 0;
		int neg = 1;
		String target = str.trim();
		if (target.length() == 0) {
			return 0;
		}
		for (int i = 0; i < target.length(); i++) {
			char ch = target.charAt(i);

			if (Character.isDigit(ch)) {
				result *= 10;
				result += ch - '0';
			} else if (ch == '-' && i == 0) {
				neg = -1;
			} else if (ch == '+' && i == 0) {
				neg = 1;
			} else{
				break;
			}

		}

		result = result * neg;
		if(result > Integer.MAX_VALUE){
			result = Integer.MAX_VALUE;
		}
		if(result < Integer.MIN_VALUE){
			result = Integer.MIN_VALUE;
		}
		return (int)result;
	}

}
