
public class SearchForARange {
	 /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {9,10,100,101,1002,10203};
		int target = 10203;
		int[] r = searchRange(A,target);
		System.out.println(r);
	}
	public static int[] searchRange(int[] A, int target) {
        // write your code here
		int s = -1;
		int e = -1;
		
		int[] result = {s,e};
		if(A.length == 0 || A == null){
			return result;
		}
		
		int start = 0;
		int end = A.length -1;
		int mid = 0;
		
		while(start +1 < end){
			mid = start + (end - start)/2;
			
			if (target>A[mid]) {
				start = mid;
			} 
			if(target <= A[mid]){
				end = mid;
			}
		}
		if(A[end] == target){
			s = end;
		}
		if (A[mid] == target) {
			s = mid;
		}
		if(A[start] == target){
			s = start; 
		}
		
		
		int start2 = 0;
		int end2 = A.length -1;
		int mid2 = 0;
		while(start2 +1 < end2){
			mid2 = start2 + (end2 - start2)/2;
			
			if (target >= A[mid2]) {
				start2 = mid2;
			} 
			if(target < A[mid2]){
				end2 = mid2;
			}
		}
		if(A[start2] == target){
			e = start2; 
		}
		if (A[mid2] == target) {
			e = mid2;
		}
		
		if(A[end2] == target){
			e = end2;
		}
		
		int[] result2 = {s,e};
		
		return result2;
    }
}
