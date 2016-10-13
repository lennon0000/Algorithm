
public class FindPeakElement {
	 /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 1, 3, 4, 5, 7, 6};
		int r= findPeak(arr);
		System.out.println(r);
	}
	
	 public static int findPeak(int[] A) {
	        // write your code here
		 int r = 0;
		 int t = A[0];
		 
		 for (int i = 0; i < A.length; i++) {
			if(A[i] < A[i+1] && A[i+1] > A[i+2]){
				return i+1;
			}
		}
		 
		 
		 return r;
	 }

}
