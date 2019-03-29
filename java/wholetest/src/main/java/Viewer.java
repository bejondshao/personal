/******************************************************************************
 *  Compilation:  javac Viewer.java
 *  Execution:    java Viewer -d:<folder>
 *  Dependencies: Picture.java https://introcs.cs.princeton.edu/java/31datatype/Picture.java.html
 *  Data files:   images in images folder
 *
 *  Show images with fade transition. In case of Picture doesn't have a close
 *  method, so just create new Frame each time.
 *
 *
 *
 ******************************************************************************/

import java.awt.Color;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Viewer {

	private static String COLON = ":";

	private static String COMMA = ",";

	private static String[] folders = new String[]{"images"};

	private static Map<String, DoubleLinkedList> doubleLinkedListHashMap = new HashMap<>();

	private static void callMethod(String command, String secondPart) throws Exception {
		switch (command) {
			case "-d":
				listContentsInFolder(secondPart);
				break;

			case "-f":
				listContents(secondPart);
				break;

			case "-r":
				reverseSlideshow(secondPart);
				break;

			default:
				throw new Exception("Command is not valid. Only \"-d\", \"-f\" or \"-r\" is allowed.");
		}

	}

	private static void listContentsInFolder(String folder) throws Exception {
		if (folder == null) {
			throw new Exception("Folder is required. E.g. -d:images");
		}

		DoubleLinkedList doubleLinkedList = getDoubleLinkedList(folder);
		slideshow(doubleLinkedList, 0, doubleLinkedList.size - 1);
	}

	private static void listContents(String range) throws Exception {

		int start = 0;

		// get the default list
		DoubleLinkedList doubleLinkedList = getDefaultDoubleLinkedList();
		int end = doubleLinkedList.getSize() - 1;

		if (range != null) {
			int[] ints = convertRange2Ints(range);
			start = ints[0] - 1; // as index starts from 0, so start minus 1
			end = ints[1] - 1;
		}

		slideshow(doubleLinkedList, start, end);
	}

	private static int[] convertRange2Ints(String range) throws Exception {
		int[] ints = new int[2];
		if (range.contains(COMMA)) {
			String[] splitResult = range.split(COMMA);
			try {
				ints[0] = Integer.parseInt(splitResult[0].trim());
				ints[1] = Integer.parseInt(splitResult[1].trim());
			} catch (NumberFormatException e) {
				throw new Exception("Wrong slideshow argument, number is required, e.g. -f:1,3");
			}
		} else {
			throw new Exception("Wrong delimiter. Only \",\" is valid, e.g. -f:1,3");
		}
		return ints;
	}

	/**
	 * Show images from start to end, start can be 0, end can be size of list
	 *
	 * @param doubleLinkedList
	 * @param start
	 * @param end
	 */
	private static void slideshow(DoubleLinkedList doubleLinkedList, int start, int end) throws Exception {

		if (start < 0) {
			throw new Exception("Index should not be less than 1.");
		}

		if (start > end) {
			throw new Exception("Start should not bigger than end.");
		}

		if (end >= doubleLinkedList.size) {
			throw new Exception("Index is out of bound of image counts.");
		}

		preDeal(doubleLinkedList, start, end);

		for (int i = start; i < end; i++) {
			Node node = doubleLinkedList.getNode(i);
			String file1 = node.getItem().getFile().getPath();
			String file2 = node.getNext().getItem().getFile().getPath();
			System.out.println("Showing from " + file1 + " to " + file2);
			fade(110, file1, file2);
		}
	}

	private static void preDeal(DoubleLinkedList doubleLinkedList, int start, int end) throws Exception {

		if (doubleLinkedList.size == 1 || start == end) {
			File image = doubleLinkedList.getNode(start).getItem().getFile();
			System.out.print("Showing " + image.getName());
			Picture picture = new Picture(image);
			picture.show();
			return;
		}
	}


	private static void reverseSlideshow(String range) throws Exception {

		DoubleLinkedList doubleLinkedList = getDefaultDoubleLinkedList();
		doubleLinkedList.reverse();
		int start = doubleLinkedList.getSize() - 1;
		int end = 0;

		if (range != null) {
			int[] ints = convertRange2Ints(range);
			start = ints[0] - 1;
			end = ints[1] - 1;
		}

		// get the default list
		reverseSlideshow(doubleLinkedList, start, end);
	}

	/**
	 * loop from tail to start, just find the prev
	 * @param start
	 * @param end
	 */
	private static void reverseSlideshow(DoubleLinkedList doubleLinkedList, int start, int end) throws Exception {

		if (end < 0) {
			throw new Exception("Index should not be less than 1");
		}
		if (start < end) {
			throw new Exception("Start should not smaller than end.");
		}

		if (start >= doubleLinkedList.size) {
			throw new Exception("Index is out of bound of image counts.");
		}

		preDeal(doubleLinkedList, start, end);
		for (int i = start; i > end; i--) {
			Node node = doubleLinkedList.getNode(i);
			String file1 = node.getItem().getFile().getPath();
			String file2 = node.getPrev().getItem().getFile().getPath();
			System.out.println("Showing from " + file1 + " to " + file2);
			fade(110, file1, file2);
		}
	}

	/**
	 * Init linked list, put all images file name into list.
	 */
	private static void init() {
		File folder;
		File[] listFiles;
		for (String folderName : folders) {
			DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
			folder = new File(folderName);
			listFiles = folder.listFiles();
			Item item;
			System.out.println("Adding images from folder \"" + folderName + "\". Please pay attention to the list of the images. Might not be the alphabet order.");
			for (File file : listFiles) {
				if (file.isFile()) {
					System.out.println(file.getName());
					item = new Item(file);
					doubleLinkedList.addTailNode(item);
				}
			}
			System.out.println("Head: " + doubleLinkedList.getHead().getItem().getName());
			System.out.println("Tail: " + doubleLinkedList.getTail().getItem().getName());
			doubleLinkedListHashMap.put(folderName, doubleLinkedList);
			System.out.println("==============================================");
		}
	}

	public static void main(String[] args) {

		init();
		if (args.length == 1) {
			// this is the first argument of args
			String argument = args[0];
			String secondPart = null;
			String command = argument;

			// check if argument contains ":", if not, we just put the argument into next step
			if (argument.contains(COLON)) {
				String[] parameters = argument.split(COLON);
				if (parameters.length < 2) {
					System.out.println("Lack of parameter.");
					return;
				}
				command = parameters[0];
				secondPart = parameters[1];
			}
			try {
				callMethod(command, secondPart);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else if (args.length > 1) {
			System.out.println("Only one argument is allowed.");
		} else {
			System.out.println("Please enter argument.");
		}
	}

	private static Color combine(Color c1, Color c2, double alpha) {
		int r = (int) (alpha * c1.getRed() + (1 - alpha) * c2.getRed());
		int g = (int) (alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
		int b = (int) (alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
		return new Color(r, g, b);
	}

	private static void fade(int n, String begin, String end) {
		Picture picture1 = new Picture(begin);   // begin picture
		Picture picture2 = new Picture(end);   // end picture
		int width = picture1.width();
		int height = picture1.height();
		Picture picture = new Picture(width, height);
		for (int k = 0; k <= n; k++) {
			double alpha = 1.0 * k / n;
			for (int col = 0; col < width; col++) {
				for (int row = 0; row < height; row++) {
					Color c1 = picture1.get(col, row);
					Color c2 = picture2.get(col, row);
					picture.set(col, row, combine(c2, c1, alpha));
				}
			}
			picture.show();
		}
	}

	/**
	 * Add this function to check non exist folder
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static DoubleLinkedList getDoubleLinkedList(String key) throws Exception {

		DoubleLinkedList doubleLinkedList = doubleLinkedListHashMap.get(key);
		if (doubleLinkedList == null) {
			throw new Exception("Folder is not found, please check again.");
		}

		if (doubleLinkedList.size == 0) {
			throw new Exception("Folder is empty. Please put some images in it.");
		}

		return doubleLinkedList;
	}

	private static DoubleLinkedList getDefaultDoubleLinkedList() throws Exception {

		String key = folders[0];
		return getDoubleLinkedList(key);
	}

	private static class Item {

		private String name;

		private File file;

		// other attributes

		public Item(File file) {
			this.file = file;
			this.name = file.getName();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}
	}

	private static class Node {

		private Item item;

		private Node next; // reference to the successor node

		private Node prev; // reference to the predecessor node

		public Node(Item item) {
			this.item = item;
		}

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}

	/**
	 * Since we need to put all code in Viewer.java, so all inner class has to be static so that we
	 * can use them in main() method
	 */
	private static class DoubleLinkedList {

		private Node head; // head of doubleLinkedList, head.prev is always null

		private Node tail; // tail of doubleLinkedList, tail.next is always null

		private int size;

		private DoubleLinkedList() {
			head = null;
			tail = null;
			size = 0;
		}

		/**
		 * Add current item to tail of doubleLinkedList
		 *
		 * @param item
		 * @return tail node of doubleLinkedList, the item is current item
		 */
		public Node addTailNode(Item item) {
			Node newNode = new Node(item);

			// when adding the first node
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				// when adding the second node
				if (head.next == null) {
					head.next = newNode;
					newNode.prev = head;
				} else {
					// when adding the third or more node
					tail.next = newNode;
					newNode.prev = tail;
				}
				tail = newNode;
			}

			this.size++;

			return newNode;
		}

		/**
		 * Get node from doubleLinkedList, index starts from 0
		 *
		 * @param index
		 * @return
		 */
		public Node getNode(int index) {
			Node node = head;
			if (index >= size) {
				throw new IndexOutOfBoundsException("Index is out of bound.");
			}
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}

		/**
		 * reverse the double linked list
		 * @return
		 */
		public void reverse() {

			// temp to save previous node
			Node temp = null;
			// current move one by one
			Node current = head;

			while (current != null) {
				// temp save current previous node, then current previous node can change to next node
				temp = current.prev;
				current.prev = current.next;
				current.next = temp;

				// current move to next one
				current = current.prev;
			}
			/**
			 * Before changing head, check for the cases like empty list and list with only one node
			 *
			 */
			if (temp != null) {
				tail = head;
				head = temp.prev;
			}

			System.out.println("Printing out reversed double linked list:");
			for(int i = 0; i < size; i++) {
				System.out.println(getNode(i).getItem().getName());
			}
			System.out.println("Head: " + head.getItem().getName());
			System.out.println("Tail: " + tail.getItem().getName());
		}

		public Node getHead() {
			return head;
		}

		public void setHead(Node head) {
			this.head = head;
		}

		public Node getTail() {
			return tail;
		}

		public void setTail(Node tail) {
			this.tail = tail;
		}

		public int getSize() {
			return size;
		}

	}

}
