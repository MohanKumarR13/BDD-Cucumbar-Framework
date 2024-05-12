package pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class TimeSheetPage {

	private static TimeSheetPage timeInstance;

	private TimeSheetPage() {

	}
	public static TimeSheetPage gettimeInstance() {
		if (timeInstance == null) {
			timeInstance = new TimeSheetPage();
		}
		return timeInstance;
	}

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement employeeName;

	public void enterEmployeeName(String name) throws Exception {
		CommonUtils.getcommonUtilsInstance().highlightElements(employeeName);

		employeeName.click();
		employeeName.sendKeys(name);
		Thread.sleep(3000);
		employeeName.sendKeys(Keys.DOWN, Keys.ENTER);

	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement viewBtn;

	public void clickView() {
		CommonUtils.getcommonUtilsInstance().highlightElements(viewBtn);

		viewBtn.click();
	}

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	private WebElement message;

	public String messageView() {
		CommonUtils.getcommonUtilsInstance().highlightElements(message);

		return message.getText();
	}
}
