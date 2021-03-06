package Algorithms;

import java.util.List;

/**
 * BinarySearch algorithms that require that type T implements comparable.
 * 
 * Iterative:
 *  - Time Complexity: O(log(n))
 *  - Space Complexity: O(1)
 * 
 * Recursive:
 *  - Time Complexity: O(log(n))
 *  - Space Complexity: O(log(n)) //Due to maintaining the variables on the recursion stack
 * 
 * Assumptions: Input array is a distinct sorted list.
 * 
 * I want to make a few remarks on the "? super T" syntax. It's called a wild card and is used in conjunction with "super".
 * Super in Generics is the opposite of extends. Instead of saying the comparable's generic type has to be a subclass of T, 
 * it is saying it has to be a superclass of T.
 * A List<? super Integer>, for example, includes List<Integer>, List<Number>, and List<Object>.
 * 
 * Another interesting thing I learned was about how to use Generics with static methods. Notice the <T> I place after
 * each method. What this does is allows me to specify the type at runtime and the static method (having already been
 * created) will assume that I am being honest and T will indeed extend Comparable<? super>. Otherwise i'm in crash city.
 * This is why we have to two cast warnings below when I call the compareTo method. Now I don't have to create instance
 * objects every time I want to call binary search. :)
 * 
 * Links:
 * 
 * http://stackoverflow.com/questions/8860847/how-to-call-static-method-from-a-generic-class?lq=1
 * http://stackoverflow.com/questions/936377/static-method-in-a-generic-class
 * 
 * @author Brian
 *
 * @param <T>
 */
public class BinarySearch<T extends Comparable<? super T>> {
	
	public static <T> int binarySearch(List<T> array, T key){
		if(array == null || array.size() == 0 || key == null){
			return -1;
		}
		
		int low = 0;
		int high = array.size();
		int mid;
		
		while(high >= low){
			mid = (high + low)/2;
			
			if(((Comparable<? super T>) array.get(mid)).compareTo(key) < 0){
				low = mid + 1;
			}else if(((Comparable<? super T>) array.get(mid)).compareTo(key) > 0){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		
		return -1;
	}
	
	public static <T> int binarySearchRecursive(List<T> array, T key){
		if(array == null || array.size() == 0 || key == null){
			return -1;
		}
		return binarySearch(array, key, 0, array.size());
	}
	
	private static <T> int binarySearch(List<T> array, T key, int low, int high){
		if(high < low){
			return -1;
		}
		int mid = (high + low)/2;
			
		if(((Comparable<? super T>) array.get(mid)).compareTo(key) < 0){
			return binarySearch(array, key, mid + 1, high);
		}else if(((Comparable<? super T>) array.get(mid)).compareTo(key) > 0){
			return binarySearch(array, key, low, mid - 1);
		}else{
			return mid;
		}
	}
}
