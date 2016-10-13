
public class SearchInRotatedSortedArray {
	/** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int search(int[] A, int target) {
        // write your code here
		int start = 0;
		int end = A.length-1;
		int mid = 0;
		
		if(A.length == 0){
			return -1;
		}
		
		while(start+1 < end){
			mid = start + (end- start)/2;
			if (A[start] < A[mid]) {
				if (A[mid] >= target && target >= A[start]) {
					end = mid;
				} else{
					start = mid;
				}
			} else{
				if (A[mid] <= target && A[end] >= target ) {
					start = mid;
				} else{
					end = mid;
				}
			}
		}
		if(A[mid] == target){
			return mid;
		}
		if(A[start] == target){
			return start;
		}
		if(A[end] == target){
			return end;
		}
		
		return -1;
    }

}
