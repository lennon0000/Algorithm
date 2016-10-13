package array;

public class PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {9,9};
		int[] b = plusOne(a);
		System.out.println(b);
	}

	public static int[] plusOne(int[] digits) {
		int addOne = 1;
		for (int i = digits.length-1; i >= 0 ; i++) {
			int digit = digits[i];
			int sum = digit +addOne;
			if(sum > 9){
				digits[i] = 0;
				if(i == 0){
					return clone(digits);
				}
			}else{
				digits[i] = sum;
				break;
			}
		}
		return digits;
	}

	private static int[] clone(int[] digits) {
		int[] result = new int[digits.length+1];
		result[0] = 1;
		for(int i = 1; i<= digits.length;i++){
			result[i] = digits[i-1];
		}
		return result;
	}

}
