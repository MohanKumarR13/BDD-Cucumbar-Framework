package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BackgroundHooks {
	@Before(order = 1)
	public void before() {
		System.out.println("This will run before all scenario");
	}

	@After(order = 1)
	public void after() {
		System.out.println("This will run after all scenario");

	}
}
