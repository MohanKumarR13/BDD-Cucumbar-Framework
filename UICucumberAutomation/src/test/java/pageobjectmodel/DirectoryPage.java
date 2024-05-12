package pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonUtils;

public class DirectoryPage {

	private static DirectoryPage directoryInstance;

	private DirectoryPage() {

	}

	public static DirectoryPage getDirectoryInstance() {
		if (directoryInstance == null) {
			directoryInstance = new DirectoryPage();
		}
		return directoryInstance;
	}

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement hintEmp;
	@FindBy(xpath = "//button[normalize-space()='Search']")

	private WebElement search;

	@FindBy(xpath = "(//div)[50])")
	private WebElement location;

	@FindBy(xpath = "//div[@class='oxd-table-filter-area']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")
	private WebElement filter;

	public WebElement getFilter() {
		return filter;
	}

	public void setFilter(WebElement filter) {
		this.filter = filter;
	}

	@FindBy(xpath = "//p[normalize-space()='John Doe']")
	private WebElement name;

	public WebElement getHintEmp() {
		return hintEmp;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getName() {
		return name;
	}

	public void clickHint(String empName) throws InterruptedException {
		CommonUtils.getcommonUtilsInstance().highlightElements(hintEmp);

		hintEmp.sendKeys(empName);
		Thread.sleep(5000);

		hintEmp.sendKeys(Keys.DOWN, Keys.ENTER);

	}

	public void clickSearch() {
		CommonUtils.getcommonUtilsInstance().highlightElements(search);

		search.click();
	}

	public String getSearchedNameText() {
		CommonUtils.getcommonUtilsInstance().highlightElements(name);

		return name.getText();
	}
	
	@FindBy(name = "country")
	private WebElement countryDropdown;

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public void setCountryDropdown(WebElement countryDropdown) {
		this.countryDropdown = countryDropdown;
	}

	
}
