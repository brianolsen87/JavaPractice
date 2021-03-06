package DataStructures;

public class Stack<T>{

	private LinkedList<T> linkedList;

	public Stack(){
		this.linkedList = new LinkedList<T>();	
	}
	
	public boolean empty(){
		return this.linkedList.size() == 0;
	}
	
	public T peek(){
		if(this.linkedList.getTail() == null){
			return null;
		}
		return this.linkedList.getTail().getData();
	}
	
	public T pop(){
		if(this.empty()){
			return null;
		}
		LinkedListNode<T> val = this.linkedList.removeTail();
		return val.getData();
	}
	
	public T push(T item){
		if(item == null){
			return null;
		}
		
		this.linkedList.appendToTail(item);
		
		return item;
	}
	
	public int size(){
		return this.linkedList.size();
	}
}
