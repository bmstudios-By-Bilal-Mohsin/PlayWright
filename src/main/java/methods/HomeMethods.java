package methods;

import com.microsoft.playwright.Page;

public class HomeMethods {

	private final Page page;

	public HomeMethods(Page page) {

		this.page = page;
	}

	public void getGoogleTitle() {

		System.out.println(page.title());
	}

}
