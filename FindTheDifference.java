import java.util.HashMap;
import java.util.HashSet;

public class FindTheDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public char findTheDifference(String s, String t) {
		HashMap<Character,Integer> ini = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (ini.containsKey(tmp)) {
				int times = ini.get(tmp);
				ini.replace(tmp, times+1);
			}else{
				ini.put(tmp, 1);
			}
			
		}
		HashMap<Character,Integer> tar = new HashMap<Character,Integer>();
		for (int i = 0; i < s.length(); i++) {
			char tmp = t.charAt(i);
			if (tar.containsKey(tmp)) {
				int times = ini.get(tmp);
				tar.replace(tmp, times+1);
			}else{
				tar.put(tmp, 1);
			}
			
		}
		return 0;
        
    }
}
