package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
	@Before(order = 1)
	public void before() {
		System.out.println("Open Browser");
	}

	@After(order = 1)
	public void after() {
		System.out.println("Logout Application");

	}

	@Before(order = 0)
	public void appBeReady() {
		System.out.println("Application Be ready");
	}

	@After(order = 0)
	public void closeBrowser() {
		System.out.println("Close Browser");

	}
}
