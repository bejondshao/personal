package com.bejond.wholetest;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * Created by bejond on 4/7/16.
 */
public class TestAll {
	@Test
	public void testEnum() {
		for (Note note : Note.values()) {
			System.out.println(note + " " + note.ordinal());
		}
	}

	@Test
	public void testEnumSwitch() {
		Note fen = Note.FEN;
		Note yuan = Note.YUAN;
		Note shi = Note.SHI;
		Note bai = Note.BAI;

		Money money1 = new Money(fen);
		Money money2 = new Money(yuan);
		Money money3 = new Money(shi);
		Money money4 = new Money(bai);

		List<Money> moneyList = new ArrayList<Money>();

		moneyList.add(money1);
		moneyList.add(money2);
		moneyList.add(money3);
		moneyList.add(money4);

		for (Money money : moneyList) {
			System.out.print(Enum.valueOf(
				Note.class, money.getNote().name()) + ". ");

			money.describe();
		}

	}
}
