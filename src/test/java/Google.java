import methods.HomeMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Google extends BasePage{

	public HomeMethods homeMethods;

	@BeforeClass
	public void setUp() {

		super.setUp();
		homeMethods = new HomeMethods(page);
	}

	@Test
	public void getTitle() {

		homeMethods.getGoogleTitle();
	}
}
