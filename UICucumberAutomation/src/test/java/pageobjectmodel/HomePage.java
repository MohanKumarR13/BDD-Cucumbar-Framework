package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class HomePage {
	
	
	private static HomePage homeInstance;

	private HomePage() {

	}

	public static HomePage getHomeInstance() {
		if (homeInstance == null) {
			homeInstance = new HomePage();
		}
		return homeInstance;
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='Directory']")
private  WebElement directory;

	@FindBy(xpath = "//span[normalize-space()='Time']")
	private  WebElement timeSlot;

	
	public WebElement getTimeSlot() {
		return timeSlot;
	}

	public WebElement getDirectory() {
		return directory;
	}
	public void clickDirectory() {
		CommonUtils.getcommonUtilsInstance().highlightElements(directory);

		directory.click();
	}
	
	public void clickTime() throws InterruptedException {
		CommonUtils.getcommonUtilsInstance().highlightElements(timeSlot);

		timeSlot.click();
		Thread.sleep(3000);
	}
}
