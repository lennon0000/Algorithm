package string;

import java.util.HashMap;

public class LongestSubStrWithoutReap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//最简单的方法，就是用hashset来存储，并且逐一从i=0，遍历到最后一个，
		//以下优化，是再次开始循环i的时候，不是逐一，而是，当出现重复char时，第一次出现的位置的下一个，开始循环i，然后逐一+1
		//再进行优化，就是。不逐一+1.而是，取决于上一次的hashmap里边的有效长度，来操作。
		//         0 1 2 3 4 5 6 7 8 9
		//         u m v e m j c u u k
		String s = "umvemjcuuk";
		int r = lengthOfLongestSubstring(s);
		System.out.println(r);
	}

	public static int lengthOfLongestSubstring(String s) {
		int result = 1;
		if(s.length()==0 || s == null){
			return 0;
		}
		HashMap<Character,Integer> chars = new HashMap<Character,Integer>();
		int lastIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if(chars.size() == 0){
				chars.put(cur, i);
			}
			
			for(int j = lastIndex+1; j < s.length(); j++){//优化2，改变从j=i开始的方式
				
				if(chars.get(s.charAt(j)) == null ){
					chars.put(s.charAt(j), j);
					result = Math.max(result, chars.size());
				} else{
					int t = i;
					i = chars.get(s.charAt(j)) ;// 优化1，改变i逐一增加的方式
					while(t < i+1){
						chars.remove(s.charAt(t));
						t++;
					}
					chars.put(s.charAt(j), j);
					break;
				}
				lastIndex = j;
			}
		}

		return result;
	}
	/**  O(N) TIME   O(1) SPACE  其实这个思路有点类似于上边的思路，只不过是，将hashmap改为了256个数组来标记，某个char是不是存在，不存在，则设置该char对应的数组index的值为现在char的index（char ascii编码）
	 * 
	// 			   0 1 2 3 4 5 6 7 8 9
	//         u m v e m j c u u k
	public static int lengthOfLongestSubstring(String s) {
		 int lastIndices[] = new int[256];
	        for(int i = 0; i<256; i++){
	            lastIndices[i] = -1;
	        }
	        
	        int maxLen = 0;
	        int curLen = 0;
	        int start = 0;//start value 一方面可以用来判断，该char是不是出现过，另一方面，可以实现，类似于上述方法中，删除某个hashmap对象的目的
	        for(int i = 0; i<s.length(); i++){
	            char cur = s.charAt(i);
	            if(lastIndices[cur]  < start){
	                lastIndices[cur] = i;
	                curLen++;
	            }
	            else{
	                int lastIndex = lastIndices[cur];
	                start = lastIndex+1;
	                curLen = i-start+1;
	                lastIndices[cur] = i;
	            }
	            
	            if(curLen > maxLen){
	                maxLen = curLen;
	            }
	        }
	        
	        return maxLen;
	}
*/
}
