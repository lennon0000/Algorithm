package string;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		String re = countAndSay(n);
		System.out.println(re);
	}

	// public static String countAndSay(int n){
	// String resource = "1";
	// for(int i = 1; i < n; i++){
	//
	// int next = 0;
	// String tmp = "";
	// for(int j = 0; j < resource.length(); j++){
	// int times = 0;
	//
	// char cur = resource.charAt(j);
	// while(resource.charAt(next) == cur && next < resource.length()){
	// next ++;
	// times++;
	// }
	// j = j + times - 1;//是否需要-1？
	//
	// tmp = tmp + String.valueOf(times) + cur;
	//
	// }
	// resource = tmp;
	// }
	// return resource;
	// }
	// 111221
	public static String countAndSay(int n) {
		String resource = "1";
		String tmp = "";
		while (n > 1) {
			int[] digits = new int[10];
			for (int i = 0; i < resource.length(); i++) {
				int index = resource.charAt(i)-48;
				if (digits[index] != 0) {
					digits[index] = digits[index] + 1;

				} else {
					if(i>0){
						
						tmp = tmp + digits[resource.charAt(i-1)-48] + resource.charAt(i-1);
						digits = new int[10];
					}
					
					digits[index] = 1;
				}
				
			}
			char t = resource.charAt(resource.length()-1);
			int lastIndex =t - 48;
			resource =  tmp + digits[lastIndex] + lastIndex;
			tmp = "";
			n--;
		}

		return resource;
	}

}
