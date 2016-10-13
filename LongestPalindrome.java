package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicated"
				+ "canlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplacef"
				+ "orthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewe"
				+ "cannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfara"
				+ "boveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhe"
				+ "reItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisrath"
				+ "erforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwh"
				+ "ichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGod"
				+ "shallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		int r = longestPalindrome(s);
		System.out.println(r);
	}

	public static int longestPalindrome(String s) {
		HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
		int t = s.length();
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (chars.containsKey(tmp)) {
				int times = chars.get(tmp) + 1;
				chars.replace(tmp, times);
			} else {
				chars.put(tmp, 1);
			}
		}
		int length = 0;
		int single = 0;

		for (Map.Entry<Character, Integer> c : chars.entrySet()) {
			if (c.getValue() % 2 == 0) {
				length += c.getValue();
			} else {
				length += (c.getValue()-1);
				single = 1;
			}
		}
		length += single;
		return length;

	}

}
