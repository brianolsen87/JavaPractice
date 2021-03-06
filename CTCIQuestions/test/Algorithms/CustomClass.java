package Algorithms;

/**
 * Class that is identified by two fields id1 and id2.
 * The attribute notId is a non-unique field.
 * 
 * Interesting link for comparators. Would be interesting to try this later.
 * http://stackoverflow.com/questions/14154127/collections-sortlistt-comparator-super-t-method-example
 * 
 * @author Brian
 *
 */
public class CustomClass implements Comparable<CustomClass>{
	private int id1;
	private String id2;
	private int notId;
	
	CustomClass(int id1, String id2, int notId){
		this.id1 = id1;
		this.id2 = id2;
		this.notId = notId;
	}

	/**
	 * We first sort by id1 then id2. It's crucial that we keep them in separate if statements
	 * i.e. performing compare(this.id1, that.id1) > 0 || id2.compareTo(that.id2) > 0 in the same statement doesn't work.
	 * 
	 */
	public int compareTo(CustomClass that) {
		if(Integer.compare(this.id1, that.id1) > 0){
			return 1;
		}else if(Integer.compare(this.id1, that.id1) < 0){
			return -1;
		}else if(this.id2.compareTo(that.id2) > 0){
			return 1;
		}else if(this.id2.compareTo(that.id2) < 0){
			return -1;
		}
		return 0;
	}
	
	public String toString(){
		return "([" + this.id1 + ", " + this.id2 + "], " + this.notId + ")";
	}
}
