package XM.XM_Project;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInteractionsTest extends TestBase {

	@Test
	public void UserInteractionsTesting() throws InterruptedException {

		// Create a wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// HomePage go
		driver.manage().window().setSize(new Dimension(2560, 1440));
		driver.get("https://www.xm.com/");

		// Create a object of MainPage Class
		MainPage mainPage = new MainPage(driver);

		// Switch To Accept Cookies
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.AcceptButton));
		mainPage.getAcceptButton().click();

		// Main Page Control
		assertTrue(mainPage.ResearchEducationButton.isDisplayed());

		// Click the <Research and Education>
		mainPage.getResearchEducationButton().click();

		// Click <Economic Calendar>
		mainPage.getEconomicCalendarButton().click();

		// Switch to the iFrame
		driver.switchTo().frame(mainPage.iFrame);

		// Click <Yesterday> button
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.YesterdayButton));
		assertTrue(mainPage.YesterdayButton.isDisplayed());
		mainPage.getYesterdayButton().click();
		Thread.sleep(1000);

		// Check that date is correct
		String checkDateYesterday = mainPage.CheckDate.getAttribute("innerHTML").trim();
		String ActualDateYesterday = "27/07/2022 - 27/07/2022";
		Assert.assertEquals(ActualDateYesterday, checkDateYesterday, "Date is not correct!");

		// Click <Today> button
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.TodayButton));
		assertTrue(mainPage.TodayButton.isDisplayed());
		mainPage.getTodayButton().click();
		Thread.sleep(1000);

		// Check that date is correct
		String checkDateToday = mainPage.CheckDate.getAttribute("innerHTML").trim();
		String ActualDateToday = "28/07/2022 - 28/07/2022";
		Assert.assertEquals(ActualDateToday, checkDateToday, "Date is not correct!");

		// Click <Tomorrow> button
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.TomorrowButton));
		assertTrue(mainPage.TomorrowButton.isDisplayed());
		mainPage.getTomorrowButton().click();
		Thread.sleep(1000);

		// Check that date is correct
		String checkDateTomorrow = mainPage.CheckDate.getAttribute("innerHTML").trim();
		String ActualDateTomorrow = "29/07/2022 - 29/07/2022";
		Assert.assertEquals(ActualDateTomorrow, checkDateTomorrow, "Date is not correct!");

		// Click <This Week> button
		wait.until(ExpectedConditions.elementToBeClickable(mainPage.ThisWeekButton));
		assertTrue(mainPage.ThisWeekButton.isDisplayed());
		mainPage.getThisWeekButton().click();
		Thread.sleep(1000);

		// Check that date is correct
		String checkDateThisWeek = mainPage.CheckDate.getAttribute("innerHTML").trim();
		String ActualDateThisWeek = "24/07/2022 - 30/07/2022";
		Assert.assertEquals(ActualDateThisWeek, checkDateThisWeek, "Date is not correct!");

		// Switch to the Main Screen
		driver.switchTo().defaultContent();

		// Click <here> link
		String Firstlink = "https://www.xm.com/research/risk_warning";
		driver.get(Firstlink);

		// Check next page opened
		assertTrue(mainPage.RiskWarningLink.isDisplayed());

		// Click <here> link in the “Risk Warning” block at the bottom
		mainPage.getRiskWarningLink().sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

		// Switch to the new tab
		ArrayList<String> Urltabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(Urltabs.get(1));

		// Check that <Risk Disclosure> document was opened in new tab
		System.out.println(driver.getTitle());
		String ActualUrl = "https://www.xm.com/assets/pdf/new/docs/XM-Risk-Disclosures-for-Financial-Instruments.pdf?v5";
		Assert.assertEquals(ActualUrl, driver.getCurrentUrl());

	}

}
