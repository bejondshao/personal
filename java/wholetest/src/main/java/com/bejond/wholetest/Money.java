package com.bejond.wholetest;

/**
 * Created by bejond on 4/7/16.
 */
public class Money {
	Note note;

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Money(Note note) {
		this.note = note;
	}

	public void describe() {
		switch (note) {
			case FEN:
			case JIAO:
				System.out.println("It's too little.");
				break;

			case YUAN:
			default:
				System.out.println("Not so much.");
				break;

			case SHI:
				System.out.println("Kind of.");
				break;

			case BAI:
				System.out.println("Let's go for dinner.");
		}
	}
}
