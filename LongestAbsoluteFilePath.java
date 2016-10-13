package string;

import java.util.Stack;

public class LongestAbsoluteFilePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		String s ="dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		int r = lengthLongestPath(s);
		System.out.println(r);
		
	}
	/*
	public static int lengthLongestPath(String input) {
	    String[] paths = input.split("\n");
	    int[] stack = new int[paths.length+1];
	    int maxLen = 0;
	    for(String s:paths){
	        int lev = s.lastIndexOf("\t")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
	        if(s.contains(".")) maxLen = Math.max(maxLen, curLen-1);
	    }
	    return maxLen;
	}
	*/
	/*//将input用
	 * 用list来存储路径。而不是像之前那样，用string字符串直接保存，这种更容易来操作，出的问题也少，
	 * 
	public static int lengthLongestPath(String input){
		int result = 0;
		List<String> path = new LinkedList<String>();
		String[] inputs = input.split("\n");
		
		for(String in : inputs){
			int level = 0;
			while(in.charAt(0) == '\t'){
				level ++;
				in = in.substring(1);
			}
			if(path.size() > level){
				path = path.subList(0, level);
			}
			path.add(in);
			if(in.contains(".")){
				String res = String.join("/", path);
				result = res.length()>result?res.length():result;
			}
		}
		
		return result;
	}
	*/
	
	public static int lengthLongestPath(String input){
		int result = 0;
		
		Stack<String> path = new Stack<String>();
		
		String[] inputs = input.split("\n");
		for(String in : inputs){
			int level = 0;
			while(in.charAt(0) == '\t'){
				level ++;
				in = in.substring(1);
			}
			while(path.size() > level){
				path.pop();
			}
			path.push(in);
			if(in.contains(".")){
				String res = String.join("/", path);
				result = res.length()>result?res.length():result;
			}
		}
		
		return result;
	}
}
