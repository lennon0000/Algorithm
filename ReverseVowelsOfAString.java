package string;

import java.util.HashSet;

//345. Reverse Vowels of a String
public class ReverseVowelsOfAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String r = reverseVowels(s);
		System.out.println(r);
	}

	/*
	 * 未优化版，用hashset，速度比较慢，可以用一个string v来存储10个元音字母，然后用v.indexOf(c)的返回值，判断当前char
	 * c是不是元音，这样速度会快一些
	 *
	 */
	// public static String reverseVowels(String s) {
	//
	// HashSet<Character> vowels = new HashSet<Character>();
	// vowels.add('a');
	// vowels.add('e');
	// vowels.add('i');
	// vowels.add('o');
	// vowels.add('u');
	// vowels.add('A');
	// vowels.add('E');
	// vowels.add('I');
	// vowels.add('O');
	// vowels.add('U');
	// int start = 0;
	// int end = s.length()-1;
	// char[] ss = s.toCharArray();
	// while(start < end){
	// Boolean flag1= false;
	// Boolean flag2 = false;
	// char tt = ss[start];
	// if(!vowels.contains(ss[start])){
	// start ++;
	//
	// }else{
	// flag1 = true;
	// }
	// if(!vowels.contains(ss[end])){
	// end --;
	// }else{
	// flag2 = true;
	// }
	// if(flag1 && flag2){
	// char tmp = ss[start];
	// ss[start] = ss[end];
	// ss[end] = tmp;
	// start ++;
	// end --;
	// flag1 = false;
	// flag2 = false;
	// }
	//
	// }
	// String result = new String(ss);
	// return result;
	// }

	public static String reverseVowels(String s) {
		// 用一个string v来存储10个元音字母，然后用v.indexOf(c)的返回值，判断当前char c是不是元音，这样速度会快一些
		String vowels = "aeiouAEIOU";
		int start = 0;
		int end = s.length() - 1;
		char[] ss = s.toCharArray();
		while (start < end) {
			Boolean flag1 = false;
			Boolean flag2 = false;
			char tt = ss[start];
			if (vowels.indexOf(ss[start]) == -1) {
				start++;
			} else {
				flag1 = true;
			}
			if (vowels.indexOf(ss[end]) == -1) {
				end--;
			} else {
				flag2 = true;
			}
			if (flag1 && flag2) {
				char tmp = ss[start];
				ss[start] = ss[end];
				ss[end] = tmp;
				start++;
				end--;
				flag1 = false;
				flag2 = false;
			}

		}
		String result = new String(ss);
		return result;
	}
}
