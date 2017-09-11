package org.bejond.designpattern.iterator;

public class NameRepository implements Container {

	private int index;

	private String[] names;

	public void setNames(String[] names) {

		this.names = names;
	}

	@Override
	public Iterator getIterator() {

		return new NameIterator();
	}

	private class NameIterator implements Iterator {

		@Override
		public boolean hasNext() {

			return index < names.length;
		}

		@Override
		public Object next() {

			return names[index++];
		}
	}
}
