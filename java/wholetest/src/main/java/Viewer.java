import java.io.File;

/******************************************************************************
 *  Compilation:  javac Viewer.java
 *  Execution:    java Viewer -d:<folder>
 *  Data files:   images in images folder
 *
 *
 *
 ******************************************************************************/
public class Viewer {

	private static String COLON = ":";

	private static String COMMA = ",";

	private static String[] folders = new String[]{"images", "images2"};

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

	}

	private static void listContents(String range) throws Exception {
		int[] ints = convertRange2Ints(range);
		int start = ints[0];
		int end = ints[1];
		if (start > end) {
			throw new Exception("Start should not bigger than end.");
		}
		slideshow(start, end);
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

	private static void slideshow(int start, int end) {

	}

	private static void reverseSlideshow(String range) throws Exception {
		int[] ints = convertRange2Ints(range);
		int start = ints[0];
		int end = ints[1];
		if (start < end) {
			throw new Exception("Start should not smaller than end.");
		}

		reverseSlideshow(start, end);
	}

	private static void reverseSlideshow(int start, int end) {

	}

	/**
	 * Init linked list, put all images file name into list.
	 *
	 */
	private static void init() {
		for(String folderName : folders) {
			File folder = new File(folderName);
			File[] listFiles = folder.listFiles();
			for (File file : listFiles) {
				if (file.isFile()) {

				}
			}
		}
	}

	public static void main(String[] args) {
		if (args.length == 1) {
			// this is the first argument of args
			String argument = args[0];
			String secondPart = null;
			String command = argument;

			// check if argument contains ":", if not, we just put the argument into next step
			if (argument.contains(COLON)) {
				String[] parameters = argument.split(COLON);
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

	private class Item {

		private String name;

		// other attributes

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private class Node {

		private Item item;

		private Node next; // reference to the successor node

		private Node prev; // reference to the predecessor node

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

	private class LinkedList {

	}

}
