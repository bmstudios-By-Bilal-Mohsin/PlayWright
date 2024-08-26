import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

	protected Properties properties;
	protected Playwright playwright;
	protected Browser browser;
	protected Page page;


	public void setUp() {

		loadConfig();
		startPlay();
	}

	private void loadConfig() {
		properties = new Properties();

		try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
			properties.load(fis);
			System.out.println("Configuration file loaded");
		} catch (IOException e) {
			System.out.println("config failed");
		}
	}

	public void startPlay() {

		playwright = Playwright.create();
		String browserOpen = properties.getProperty("browser");

		if (browserOpen.equalsIgnoreCase("chromium")) {
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(
					Boolean.parseBoolean(properties.getProperty("remoteRun"))));
		}

		page = browser.newPage();
		page.navigate(properties.getProperty("url"));
	}

	public void tearDown() {

		browser.close();
		playwright.close();
	}
}
