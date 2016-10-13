package string;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a =    "0";
		String b = "1";
		String r = addBinary(a, b);
		System.out.println(r);

	}

	public static String addBinary(String a, String b) {

		String result = "";
		String shorts = a;
		String longs = b;
		shorts = a.length()<= b.length()?a:b;
		longs =a.length()> b.length()?a:b;
				
		int diff = a.length()-b.length();
		int dif = (diff>0?diff:diff*-1);
		
//		int length = (a.length() <= b.length() ? a.length() : b.length());
		boolean addOne = false;
		int j = longs.length() -1 ; 
		for (int i = shorts.length()-1; i >= 0; i--) {
			char aChar = shorts.charAt(i);
			char bChar = longs.charAt(j) ;
			j--;
			
			if(aChar == bChar){
				if(aChar == '1'){
					if(addOne){
						result = '1'+ result;
					} else{
						result = '0'+ result;
					}
					addOne = true;
				} else{
					if(addOne){
						result = '1'+ result;
					} else{
						result = '0'+ result;
					}
					addOne = false;
				}
				
			} else{
				if(addOne){
					result = '0'+ result;
					addOne = true;//
				} else{
					result = '1'+ result;
					addOne = false;
				}
			}
		}
		if(a.length() != b.length()){
			String r = a.length() > b.length()?a:b;
			
			
			for(int i = dif-1 ;i >= 0; i-- ){
				char rChar = r.charAt(i);
				if(addOne){
					if(rChar == '0'){
						result = '1' + result;
						addOne = false;
					}else{
						result = '0' + result;
						addOne = true;
					}
				}else{
					result = r.substring(0, i+1) + result;
					break;
				}
			}
		}
		
		if(addOne){
			result = '1' + result;
			addOne = false;
		}

		return result;
	}

}
