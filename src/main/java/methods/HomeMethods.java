package methods;

import body.GoogleBody;
import com.microsoft.playwright.Page;

public class HomeMethods {

	private final Page page;

	public HomeMethods(Page page) {

		this.page = page;
	}

	public void getGoogleTitle() {

		System.out.println(page.title());
	}

	public void searchGoogle(String text) {

		page.locator(GoogleBody.searchBar).fill("Bilal Mohsin");
	}

}
