package page;

import commonComponent.CommonPageComponent;
import commonComponent.ModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ViewDocumentPage extends BasePage {

    @FindBy(className = "hippo-toolbar-menu")
    private WebElement toolbarMenu;

    @FindBy(xpath = "//div[@class='hippo-preview-document-wrapper']//div[@class='hippo-editor-field-value-container'][1]")
    WebElement title;

    public ViewDocumentPage(WebDriver driver) {
        super(driver);

        Assert.assertTrue(title.isDisplayed(), "Title input field is not present on the Edit document page");

        CommonPageComponent.getLeftBar().validate();
    }

    //check the offline label is displayed on document preview
    public boolean isOffline() {
        WebElement offline = driver.findElement(By.cssSelector(".hippo-toolbar-status .hippo-toolbar-status-labels .menu-action-text span[title='Offline']"));

        return offline.isDisplayed();
    }

    //get document title from preview
    public String getTitle() {
        return title.getText().trim();
    }

    //open Document menu in tool bar
    public ViewDocumentPage openDocumentMenuItem() {
        click(toolbarMenu.findElement(By.cssSelector("ul > li:nth-child(3)")));

        return this;
    }

    //Delete document in document menu
    public ModalWindow deleteDocument() {
        driver.findElement(By.xpath("//li//a[@class='hippo-toolbar-menu-item-button'][.//span[@title='Delete...']]")).click();

        return new ModalWindow(driver);
    }

//    TODO: implement the rest of menu items
}
