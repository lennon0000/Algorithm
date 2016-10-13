import java.util.ArrayList;

public class Segment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8,2,4};
		int x = 2;
		 int r = findTheMax(x, arr);
		 System.out.println(r);
		
	}
	public static int findTheMax(int x, int[] arr){
		int result = Integer.MIN_VALUE;
		if (x == 0) {//what should be returned 
			return result;
		}
		ArrayList<Integer> mins = new ArrayList<Integer>(); 
		for(int i = 0;i<=arr.length-x;i++){
			int tmp = Integer.MAX_VALUE;
			for (int j = i; j < i+x; j++) {
				if (arr[j]<tmp) {
					tmp = arr[j];
				}
			}
			mins.add(tmp);
			if (result < tmp) {
				result = tmp;
			}
		}
		
		return result;
	}

}
