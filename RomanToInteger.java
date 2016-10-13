package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "MMMDLXXXVI";
		int r = romanToInt(s);
		System.out.println(r);

	}
	/*
	 * I = 1 V = 5 X = 10 L = 50 C = 100 D = 500 M = 1000
	 * 1 1 5 10 
	 */

	public static int romanToInt(String s) {
		int preV = 0;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char curC = s.charAt(i);
			int curV = getValue(curC);
			if(curV <= preV){
				sum += curV;
			} else{
				sum = sum + curV- 2*preV;
			}
			preV = curV;
		}
		return sum;
	}

	private static int getValue(char cur) {
		int value = 0;
		switch (cur) {
		case 'I':
			value = 1;
			break;
		case 'V':
			value = 5;
			break;
		case 'X':
			value = 10;
			break;
		case 'L':
			value = 50;
			break;
		case 'C':
			value = 100;
			break;
		case 'D':
			value = 500;
			break;
		case 'M':
			value = 1000;
			break;
		default:
			break;
		}
		return value;
	}

}
