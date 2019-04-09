/******************************************************************************                                        
 *  Compilation:  javac LinkedList.java                                                                                
 *  Execution:    java LinkedList                                                                                      
 *  Dependencies: Picture.java                                                                                         
 ******************************************************************************/

package assignment5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.io.File;
import java.awt.Color;

public class LinkedList<Item> { // implements Iterable<Item> { // to enable for each syntax                            
	private int n;          // number of elements
	private Node first;     // beginning of the list
	private Node last;      // end of the list

	// helper linked list class
	private class Node {
		private Item item;
		private Node next;
	}

	/** Initializes an empty list. */
	public LinkedList() {
		first = null;
		last = null;
		n = 0;
	}

	public boolean isEmpty() { return n == 0; }
	public int size() { return n; }

	/* add to beginning of list */
	public void addFirst(Item item) {
		Node oldfirst = first;
		first = new Node();
		if (last == null)
			last = first;
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	/* add to end of list */
	public void addLast(Item item) {
		Node temp = new Node();
		temp.item = item;
		if (last == null) {
			first = temp;
			last = temp;
		}
		else {
			last.next = temp;
			last = temp;
		}
		n++;
	}

	/** Removes the item at the beginning of the list. **/
	public Item removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("List empty");
		Item item = first.item;        // save item to return
		first = first.next;            // delete first node
		n--;
		return item;                   // return the saved item
	}

	/** Returns (but does not remove) the first element in the list. */
	public Item getFirst() {
		if (isEmpty())
			throw new NoSuchElementException("List empty");
		return first.item;
	}

	/**
	 * Returns an iterator to this list that traverses the items from first to last.
	 */

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// The Iterator<T> interface contains methods hasNext(), remove(), next()
	// (remove() is optional)
	public class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext()  {
			return current != null;
		}
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	/** Unit test with some pictures */
	public static void pause(int t) {     /** stops for t milliseconds */
		try {
			Thread.sleep(t);
		} catch (Exception e) {}
	}

	public static void main(String[] args) {
		// get the list of all file names
		File folder = new File("pictures/");  /** may need to change this */
		File[] listOfFiles = folder.listFiles();

		// create a collection of these objects
		LinkedList<Picture> photoStack = new LinkedList<Picture>();
		for (File f: listOfFiles)     /** array implements iterable */
			photoStack.addLast(new Picture(f));

		Picture p = photoStack.removeFirst();
		p.show();

		// The following can be used if LinkedList implements Iterator
		// Iterator<Picture> l = photoStack.iterator();
		// while (l.hasNext()) {
		//     Picture p = l.next();
		//     p.show();
		//     pause(2000);
		// }
		// This is possible if LinkedList implements Iterable
		// for (Picture p:photoStack) {
		//     p.show();
		//     pause(2000);
		// }
	}
}