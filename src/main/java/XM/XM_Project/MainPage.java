package XM.XM_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	WebDriver driver;

	public MainPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//a[@href=\"/assets/pdf/new/docs/XM-Risk-Disclosures-for-Financial-Instruments.pdf?v5\"]")
	WebElement RiskWarningLink;

	public WebElement getRiskWarningLink() {
		return RiskWarningLink;
	}

	@CacheLookup
	@FindBy(xpath = "//a[@href=\"/research/risk_warning\"]")
	WebElement HereLink;

	public WebElement getHereLink() {
		return HereLink;
	}

	@CacheLookup
	@FindBy(xpath = "//div[@class=\"inlineblock arial_11 lightgrayFont\"]")
	WebElement CheckDate;

	public WebElement getCheckDate() {
		return CheckDate;
	}

	@CacheLookup
	@FindBy(xpath = "//a[text()='This Week']")
	WebElement ThisWeekButton;

	public WebElement getThisWeekButton() {
		return ThisWeekButton;
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"research-app\"]/div[3]/div/div[1]/div/div[2]/div/iframe")
	WebElement iFrame;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Yesterday']")
	WebElement YesterdayButton;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Today']")
	WebElement TodayButton;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Tomorrow']")
	WebElement TomorrowButton;

	public WebElement getYesterdayButton() {
		return YesterdayButton;
	}

	public WebElement getTodayButton() {
		return TodayButton;
	}

	public WebElement getTomorrowButton() {
		return TomorrowButton;
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"main-nav\"]/li[4]/div/div/div[3]/div[1]/ul/li[6]/a")
	WebElement EconomicCalendarButton;

	public WebElement getEconomicCalendarButton() {
		return EconomicCalendarButton;
	}

	@CacheLookup
	@FindBy(xpath = "//*[text()= 'ACCEPT ALL']")
	WebElement AcceptButton;

	@CacheLookup
	@FindBy(xpath = "//*[text()= 'Research & Education        ']")
	WebElement ResearchEducationButton;

	public WebElement getResearchEducationButton() {
		return ResearchEducationButton;
	}

	public WebElement getAcceptButton() {
		return AcceptButton;
	}

}
