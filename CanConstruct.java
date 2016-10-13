package string;

import java.util.HashMap;

//383. Ransom Note
public class CanConstruct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ran = "aa";
		String maga = "aab";
		boolean r = canConstruct(ran, maga);
		System.out.println(r);
	}
	
	//第一种做法，用hashMap实现，但是会比较慢，优化一下，用int数组实现
//	public static boolean canConstruct(String ransomNote, String magazine) {
//        HashMap<Character,Integer> maga = new HashMap<Character,Integer>();
//        for(int i = 0; i < magazine.length(); i++){
//            char tmp = magazine.charAt(i);
//            if(maga.get(tmp) == null){
//                maga.put(tmp,1);
//            } else{
//            	int t = maga.get(tmp);
//                maga.replace(tmp,t+1);
//            }
//        }
//        for(int i = 0; i < ransomNote.length(); i++){
//            char tmp = ransomNote.charAt(i);
//            if(maga.get(tmp) == null || maga.get(tmp) <= 0){
//                return false;
//            } else{
//            	int t = maga.get(tmp)-1;
//                maga.replace(tmp,t);
//            }
//        }
//        return true;
//    }
	
	public static boolean canConstruct(String ransomNote, String magazine) {

		int[] mag = new int[256];
		for(int i = 0; i < magazine.length();i++ ){
			char tmp = magazine.charAt(i);
			int t = mag[tmp];
			mag[tmp] = t+1;
		}
		for(int i = 0; i < ransomNote.length();i++ ){
			char tmp = ransomNote.charAt(i);
			if(mag[tmp] == 0){
				return false;
			} else{
				int t = mag[tmp];
				mag[tmp] = t-1;
			}
		}
		
        return true;
    }

}
