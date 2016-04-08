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

	@Test
	public void testValueOf() {
		Province liaoning = Enum.valueOf(Province.class, "LIAONING");
		// when we know the type of Enum and the name(a String) of constant, we can use
		// valueOf() to get the value of the constant.
		// That is, get value with name.

		System.out.println(liaoning);

		ProvinceDescription provinceDescription =
			liaoning.getProvinceDescription();

		System.out.println(provinceDescription);
	}

	@Test
	public void testenumValueOf() {
		String province = "Liaoning"; // suppose we get this value from another method

		province = province.toUpperCase();

		Enum e = Province.valueOf(province); // This method only needs one
		// parameter, so if you have known the enum type, you should use this one instead of Enum.valueOf(,).

		System.out.print(e);
	}

	@Test
	public void testGetEnumConstants() {
		Enum e0 = Province.HEILONGJIANG;
		// e0.values(); // this is wrong
		for (Enum e : e0.getClass().getEnumConstants()) { // See, we can get values even though we just know one of values
			System.out.println(e.name());
		}

		for (Enum e : Province.values()) { // they are the same
			System.out.println(e);
		}
	}

	@Test
	public void testEnumItem() {
		Item item0 = Item.Computer.DELL;
		Item item1 = Item.Phone.NOKIA;
		Item item2 = Item.Car.BMW;
	}
}
