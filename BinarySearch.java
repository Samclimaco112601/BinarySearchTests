package Search;
/**
 * @author samclimaco
 * @version spring 2024
 * BinarySeach algorithm
 */
public class BinarySearch {
	 public static int binarySearch(int[] array, int target) {
	        int min = 0; 
	        int max = array.length - 1; 

	        while (min <= max) {
	            int mid = min + (max - min) / 2; 

	            if (array[mid] == target) {
	                return mid;
	            } else if (array[mid] < target) {
	                min = mid + 1; 
	            } else {
	                max = mid - 1;
	            }
	        }

	        return -1; 
	    }

}
