/******************************************************************************
 *  Compilation:  javac BST.java
 *  Execution:    java BST
 *  Dependencies: Queue.java
 *  Data files:   https://introcs.cs.princeton.edu/44st/tinyST.txt
 *
 *  A symbol table implemented with a binary search tree.
 *
 ******************************************************************************/

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *  The {@code BST} class represents an ordered symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides ordered methods for finding the <em>minimum</em>,
 *  <em>maximum</em>, <em>floor</em>, <em>select</em>, <em>ceiling</em>.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}; setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses an (unbalanced) binary search tree. It requires that
 *  the key type implements the {@code Comparable} interface and calls the
 *  {@code compareTo()} and method to compare two keys. It does not call either
 *  {@code equals()} or {@code hashCode()}.
 *  The <em>put</em>, <em>contains</em>, <em>remove</em>, <em>minimum</em>,
 *  <em>maximum</em>, <em>ceiling</em>, <em>floor</em>, <em>select</em>, and
 *  <em>rank</em>  operations each take
 *  linear time in the worst case, if the tree becomes unbalanced.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/44st">Section 4.4</a> of
 *  <i>Computer Science: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *  For other implementations, see {@link ST}, {@link BinarySearchST},
 *  {@link SequentialSearchST}, and {@link HashST}.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;             // root of BST

	private class Node {
		private final Key key;       // sorted by key
		private Value val;           // associated data
		private Node left, right;    // left and right subtrees
		private int size;            // number of nodes in subtree

		public Node(Key key, Value val, int size) {
			this.key = key;
			this.val = val;
			this.size = size;
		}
	}

	/**
	 * Initializes an empty symbol table.
	 */
	public BST() {
	}

	/**
	 * Returns true if this symbol table is empty.
	 * @return {@code true} if this symbol table is empty; {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Returns the number of key-value pairs in this symbol table.
	 * @return the number of key-value pairs in this symbol table
	 */
	public int size() {
		return size(root);
	}

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null) return 0;
		else return x.size;
	}

	/**
	 * Does this symbol table contain the given key?
	 *
	 * @param  key the key
	 * @return {@code true} if this symbol table contains {@code key} and
	 *         {@code false} otherwise
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public boolean contains(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	/**
	 * Returns the value associated with the given key.
	 *
	 * @param  key the key
	 * @return the value associated with the given key if the key is in the symbol table
	 *         and {@code null} if the key is not in the symbol table
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}

	/**
	 * Inserts the specified key-value pair into the symbol table, overwriting the old
	 * value with the new value if the symbol table already contains the specified key.
	 * Deletes the specified key (and its associated value) from this symbol table
	 * if the specified value is {@code null}.
	 *
	 * @param  key the key
	 * @param  val the value
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void put(Key key, Value val) {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");
		if (val == null) {
			delete(key);
			return;
		}
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		x.size = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * Removes the smallest key and associated value from the symbol table.
	 *
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public void deleteMin() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * Removes the largest key and associated value from the symbol table.
	 *
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public void deleteMax() {
		if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}

	/**
	 * Removes the specified key and its associated value from this symbol table
	 * (if the key is in this symbol table).
	 *
	 * @param  key the key
	 * @throws IllegalArgumentException if {@code key} is {@code null}
	 */
	public void delete(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to delete() is null");
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) return null;

		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = delete(x.left,  key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			if (x.right == null) return x.left;
			if (x.left  == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.size = size(x.left) + size(x.right) + 1;
		return x;
	}


	/**
	 * Returns the smallest key in the symbol table.
	 *
	 * @return the smallest key in the symbol table
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public Key min() {
		if (isEmpty())
			throw new NoSuchElementException("called min() with empty symbol table");
		return min(root).key;
	}

	private Node min(Node x) {
		if (x.left == null) return x;
		else                return min(x.left);
	}

	/**
	 * Returns the largest key in the symbol table.
	 *
	 * @return the largest key in the symbol table
	 * @throws NoSuchElementException if the symbol table is empty
	 */
	public Key max() {
		if (isEmpty())
			throw new NoSuchElementException("called max() with empty symbol table");
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) return x;
		else                 return max(x.right);
	}

	/**
	 * Returns all keys in the symbol table as an {@code Iterable}.
	 * To iterate over all of the keys in the symbol table named {@code st},
	 * use the foreach notation: {@code for (Key key : st.keys())}.
	 *
	 * @return all keys in the symbol table
	 */
	public Iterable<Key> keys() {
		return rangeSearch(min(), max());
	}

	/**
	 * Returns all keys in the symbol table in the given range,
	 * as an {@code Iterable}.
	 *
	 * @return all keys in the sybol table between {@code lo}
	 *         (inclusive) and {@code hi} (exclusive)
	 * @throws IllegalArgumentException if either {@code lo} or {@code hi}
	 *         is {@code null}
	 */
	public Iterable<Key> rangeSearch(Key lo, Key hi) {
		if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
		if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

		Queue<Key> queue = new Queue<Key>();
		keys1(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) keys(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if (cmphi > 0) keys(x.right, queue, lo, hi);
	}

	private void keys1(Node x, Queue<Key> queue, Key lo, Key hi) {
		Map<Key, Node> visitedMap = new HashMap<>(); // save the visited node

		// to be visited list
		LinkedList<Node> keyLinkedList = new LinkedList<>();
		if (x == null) {
			return;
		}
		keyLinkedList.addFirst(x);
		while (keyLinkedList.size() > 0) {
			Node node = keyLinkedList.getFirst();
			while (node.left != null) { // if we haven't visited the left node, visit left node first
				if (visitedMap.get(node.left.key) != null) { // we have visited the node, skip
					break;
				}

				keyLinkedList.addFirst(node.left);
				node = node.left;
			}

			node = keyLinkedList.getFirst();
			keyLinkedList.removeFirst();
			if (lo.compareTo(node.key) <= 0 && hi.compareTo(node.key) >= 0) {
				queue.enqueue(node.key); // put the key into queue
			}
			visitedMap.put(node.key, node);
			if (node.right != null) {
				// put right node into linkedList
				keyLinkedList.addFirst(node.right);
			}
		}
	}


	/**
	 * Returns the height of the BST (for debugging).
	 *
	 * @return the height of the BST (a 1-node tree has height 0)
	 */
	public int height() {
		return height(root);
	}
	private int height(Node x) {
		if (x == null) return -1;
		return 1 + Math.max(height(x.left), height(x.right));
	}

	/**
	 * Returns the keys in the BST in level order (for debugging).
	 *
	 * @return the keys in the BST in level order traversal
	 */
	public Iterable<Key> levelOrder() {
		Queue<Key> keys = new Queue<Key>();
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node x = queue.dequeue();
			if (x == null) continue;
			keys.enqueue(x.key);
			queue.enqueue(x.left);
			queue.enqueue(x.right);
		}
		return keys;
	}


	/**
	 * Unit tests the {@code BST} data type.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BST<String, Integer> st = new BST<String, Integer>();

		for (int i = 0; in.hasNext(); i++) {
			String key = in.next();
			if (key.equals("exit")) {
				break;
			}
			st.put(key, i);
		}

		System.out.println("--- level order ---");
		for (String s : st.levelOrder())
			System.out.println(s + " " + st.get(s));

		System.out.println("--- key order ---");

		for (String s : st.keys())
			System.out.println(s + " " + st.get(s));

		System.out.println("--- range search ---");

		for (String s: st.rangeSearch("E", "P"))
			System.out.println(s + " " + st.get(s));
	}
}