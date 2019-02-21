package page;

import commonComponent.CommonPageComponent;
import commonComponent.LeftBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "p::submit")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);

        //Assert main page elements
        Assert.assertTrue(usernameField.isDisplayed(),"Username field is not present on the Login page");
        Assert.assertTrue(passwordField.isDisplayed(),"Password field is not present on the Login page");
        Assert.assertTrue(submitButton.isDisplayed(),"Submit button is not present on the Login page");
    }

    //enter username and password and click submit
    public void login(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        submitButton.submit();

        CommonPageComponent.setLeftBar(new LeftBar(driver));
    }
}
