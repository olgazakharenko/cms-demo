package commonComponent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import page.BasePage;
import page.ContentPage;
import page.DashboardPage;

public class LeftBar extends BasePage {

    @FindBy
    WebElement leftbar;

    @FindBy(className="hippo-perspective-dashboardperspective")
   private WebElement dashboard;

    @FindBy(className = "hippo-perspective-channelmanagerperspective")
    private WebElement channels;

    @FindBy(className = "hippo-perspective-browserperspective")
    private WebElement content;

    @FindBy(className = "hippo-perspective-reportsperspective")
    private WebElement reports;

    @FindBy(className = "hippo-perspective-adminperspective")
    private WebElement admin;

    public LeftBar(WebDriver driver) {
        super(driver);
        validate();
    }

    public void goToChannels(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", channels);
    }

    public DashboardPage goToDashboard(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", dashboard);
        return new DashboardPage(driver);

    }

    public ContentPage goToContent(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", content);

        return new ContentPage(driver);
    }

    //TODO: return Reports page
    public void goToReports(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", reports);
    }

    //TODO: return Admin page
    public void goToAdmin(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", admin);
    }

    public void validate() {
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard element is not present on the left bar");
        Assert.assertTrue(channels.isDisplayed(), "Channels element is not present on the left bar");
        Assert.assertTrue(content.isDisplayed(), "Contents element is not present on the left bar");
        Assert.assertTrue(reports.isDisplayed(), "Reports element is not present on the left bar");
        Assert.assertTrue(admin.isDisplayed(), "Admin element is not present on the left bar");
    }
}
