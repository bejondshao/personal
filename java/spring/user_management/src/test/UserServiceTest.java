package test;

import com.bejond.model.User;
import com.bejond.service.UserService;
import org.junit.Test;

/**
 * Created by bejond on 16-2-4.
 */
public class UserServiceTest {
	@Test
	public void testAdd() {
		UserService userService = new UserService();
		User user = new User();
		userService.addUser(user);
	}
}
