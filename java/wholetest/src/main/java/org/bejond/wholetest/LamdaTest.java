package org.bejond.wholetest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LamdaTest {

	@Test
	public void testCompare() {

		List<Pilot> pilots = new ArrayList<>();
		pilots.add(new Pilot("a", 3));
		pilots.add(new Pilot("b", 4));
		pilots.add(new Pilot("c", 8));
		pilots.add(new Pilot("d", 1));
		pilots.add(new Pilot("e", 6));
		Collections.sort(pilots, (p1, p2) -> p2.age - p1.age);

		for ( Pilot pilot : pilots )
		{
			System.out.println(pilot.name + pilot.age);
		}
		Collections.sort(pilots, (p1, p2) -> p2.name.compareTo(p1.name));

		for ( Pilot pilot : pilots )
		{
			System.out.println(pilot.name + pilot.age);
		}

		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e));

		Arrays.asList("a", "b", "c").forEach(e -> {
			e += ",";
			System.out.println(e);
		});
	}
}
