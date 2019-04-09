import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*************************************************************************
 *  Compilation:  javac Queue.java
 *  Execution:    java Queue < input.txt
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *
 *  A generic queue, implemented using a linked list.
 *
 *************************************************************************/

public class Queue<Item> implements Iterable<Item> {
	private int N;         // number of elements on queue
	private Node first;    // beginning of queue
	private Node last;     // end of queue

	// helper linked list class
	private class Node {
		private Item item;
		private Node next;
	}

	public Queue() {  // an empty queue
		first = null;
		last = null;
		N = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public Item peek() { // look at the first item without removing
		if (isEmpty())
			throw new RuntimeException("Queue underflow");
		return first.item;
	}

	public void enqueue(Item item) {  // add the item to the queue
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}

	public Item dequeue() { // remove and return the longest-resident item on the queue
		if (isEmpty())
			throw new RuntimeException("Queue underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty())
			last = null;   // to avoid loitering
		return item;
	}

	/**
	 * Returns an iterator to this list that iterates through the items from first to last.
	 */
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class QueueIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public String toString() { //     Return a string representation
		StringBuilder s = new StringBuilder();
		Node ptr = first;
		// reference chasing
		while (ptr != null) {
			s.append(ptr.item + " ");
			ptr = ptr.next;
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Queue<String> q = new Queue<String>();
		while (in.hasNext()) {
			String item = in.nextLine();
			if (!item.equals("-")) q.enqueue(item);
			else if (!q.isEmpty()) System.out.print(q.dequeue() + " ");
		}
		System.out.println("(" + q.size() + " left on queue)");
	}
}