package Listeners;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void loginEmail() {
		System.out.println("Login by Email");
		Assert.assertTrue(true);
	}

	@Test
	public void loginfb() {
		System.out.println("Login by fb");
		Assert.assertTrue(false);
	}

}
