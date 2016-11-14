package org.bejond;

import org.bejond.model.User;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bejond on 2016/11/11.
 */
public class TestGeneric {

	@Test
	public void testMinMax() {

		User user1 = new User(1, "Adam", 20);
		User user2 = new User(2, "Bejond", 28);
		User user3 = new User(3, "Carl", 19);
		User user4 = new User(4, "Dash", 26);

		List<User> users = new LinkedList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);

		Pair<User> userPair = ListAlg.minMax(users);

		System.out.println("First: " + userPair.getFirst().getName());
		System.out.println("Second: " + userPair.getSecond().getName());
	}
}
