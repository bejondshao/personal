Compile:
	Mac:
javac -cp .:assignment/jsoup.jar assignment6/EPIC.java

	Windows:
javac -cp .;assignment6/jsoup.jar assignment6/EPIC.java

Run:
	Mac:
java -cp .:assignment6/jsoup.jar assignment6/EPIC -uhttps://introcs.cs.princeton.edu/java/33design/ -q"public interface" -m10

	Windows:
java  -cp .;assignment6/jsoup.jar assignment6/EPIC -uhttps://introcs.cs.princeton.edu/java/33design/ -q"public interface" -m10
