package string;

import org.omg.PortableInterceptor.INACTIVE;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String v1 = "1.1.1";
		String v2 = "1.1";
		int r = compareVersion(v1, v2);
		System.out.println(r);
	}

	public static int compareVersion(String version1, String version2) {
		String[] v1s = version1.split("\\.");
		String[] v2s = version2.split("\\.");

		for (int i = 0; i < v1s.length && i < v2s.length; i++) {
			String v1 = v1s[i];
			String v2 = v2s[i];
			int t1 = Integer.parseInt(v1);
			int t2 = Integer.parseInt(v2);
			if (t1 > t2) {
				return 1;
			}
			if (t1 < t2) {
				return -1;
			}

		}
		
		if (v1s.length > v2s.length) {
			for(int i = v2s.length; i < v1s.length; i++){
				String t = v1s[i];
				int value = Integer.parseInt(t);
				if(value != 0){
					return 1;
				}
			}
			return 0;
			
		}
		if (v1s.length < v2s.length) {
			for(int i = v1s.length; i < v2s.length; i++){
				String t = v2s[i];
				int value = Integer.parseInt(t);
				if(value != 0){
					return -1;
				}
			}
			return 0;
		}

		return 0;

	}
}
