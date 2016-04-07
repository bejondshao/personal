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

	@Test
	public void testProvinceDescription() {
		for (Province province : Province.values()) {
			System.out.println(province.getProvinceDescription());
		}
	}

	@Test
	public void testSingleton() {
		Singleton singleton0 = Singleton.CHINA;
		// Singleton singleton1 = new Singleton();
		// this is wrong, because Enum types can't be instantiated
		Singleton singleton2 = Singleton.CHINA;

		System.out.println(singleton0 == singleton2); // this is true, it means we make the type only one instance.
	}
}
