package commonComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class ModalWindow {

    @FindBy(className = "wicket-modal")
    private WebElement modalWindow;

    @FindBy(css = "input[value='OK']")
    private WebElement ok;

    @FindBy(css = "input[value='Cancel']")
    private WebElement cancel;

    private WebDriver driver;

    public ModalWindow (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Assert.assertTrue(modalWindow.isDisplayed(),"Expected modal window nor found");
    }

    public boolean isOpen() {
        return modalWindow.isDisplayed();
    }

    public void accept() {
        ok.click();
    }

    public void dismiss() {
        cancel.click();
    }

    public ModalWindow setText(String locatorName, String text) {
        driver.findElement(By.name(locatorName)).sendKeys(text);
        return this;
    }
}
