package page;

import commonComponent.CommonPageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    @FindBy(className = "left-body")
    WebElement leftBody;

    @FindBy(className = "right-body")
    WebElement rightBody;

    @FindBy(className = "center-body")
    WebElement centerBody;

    @FindBy(className = "goto-block")
    WebElement gotoContent;

    public DashboardPage(WebDriver driver) {
        super(driver);

        //Assert main page elements
        Assert.assertTrue(leftBody.isDisplayed(), "Left body is not present on the Dashboard page");
        Assert.assertTrue(rightBody.isDisplayed(), "Right body is not present on the Dashboard page");
        Assert.assertTrue(centerBody.isDisplayed(), "Center body is not present on the Dashboard page");
        CommonPageComponent.getLeftBar().validate();
    }

    //go to content page by clicking on content folder
    public void gotoContent() {
        gotoContent.click();
    }


}
