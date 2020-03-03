package queue;

public class Queue<E> {
	
	private static class Node<F> {
		// data fields
		private F data;
		private Node<F> next;
		
		// Constructors
		
		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}
		public Node(F data) {
			super();
			this.data = data;
			this.next = null;
		}
		
		public int toInt() {
			return (int) this.data;
		}
		
	}
	// date fields
	private Node<E> front;
	private Node<E> rear;
	private int size;
	
	// Constructor
	Queue() {
		front=null;
		rear=null;
		size=0;
	}
	
	// Methods
	
	/**
	 * Adds a new element to the rear of the queue
	 * @param item to be added
	 * @return item that was added
	 */
	public E offer(E item) {
		if(front==null) {
			front = new Node<>(item);
			rear = front;
		} else {
			rear.next = new Node<>(item);
			rear = rear.next;
		}
		
		size++;
		
		return item;
		
	}
	
	
	public E priorityOffer(E item) {
		if(front==null) {
			front = new Node<>(item);
			rear = front;
		} else {
			
			Node<E> current = front;
			while(current != null) {
				if((int)item < current.toInt())  {
					Node<E> temp = current;
					current.next = new Node<>(item);
					current.next.next = temp.next; 
					//return item;
				}
				current = current.next;
				
			}
			
		}
		
		size++;
		
		return item;
		
	}
	
	
	/**
	 * Inspects the item at the front
	 * @return the element at the front
	 * @throws IllegalStateException if the queue is empty
	 */
	public E peek() {
		
		if(size == 0) {
			throw new IllegalStateException("fart");
		}
		
		return front.data;
		
	}
	
	/** 
	 * Inspects and removes the item at the front
	 * @return the item at the front
	 * @throws IllegalStateException if the queue is empty 
	 */
	public E poll() {
		
		if(size == 0) {
			throw new IllegalStateException("fart");
		}
		
		Node<E> polled = front;
		
		front = polled.next;
		size--;
		
		return polled.data;
		
	}
	
	/**
	 * Size of the queue
	 * @return
	 */
	public int size() {
		return size;
	}
	

	
	public String toString() {
		Node<E> current = front;
		String builder = "";
		while(current!=null) {
			builder += " " + current.data;
			current=current.next;
		}
		return builder;
	}
	
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		q.offer(5);
		q.offer(4);
		q.offer(2);
		//q.priorityOffer(3);
		System.out.println(q.toString());
	}
	
}
