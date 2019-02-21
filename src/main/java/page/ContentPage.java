package page;

import commonComponent.CommonPageComponent;
import commonComponent.ModalWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContentPage extends BasePage {

    @FindBy(className = "hippo-browser-documents-small-folders")
    private WebElement documentsFoldersNavigator;

    @FindBy(className = "hippo-browser-documents-small-files")
    private WebElement documentsFilesNavigator;

    public ContentPage(WebDriver driver) {
        super(driver);

        //Assert main page elements
        Assert.assertTrue(documentsFoldersNavigator.isDisplayed(), "Folders navigator is not present on the Content page");
        Assert.assertTrue(documentsFilesNavigator.isDisplayed(), "Files navigator is not present on the Content page");
        CommonPageComponent.getLeftBar().validate();
    }

    //expand project folder
    public ContentPage expandProjectFolder() {
        WebElement expandProject = driver.findElement(By.cssSelector("a.hippo-tree-node-link[title^='My Hippo']"));
        expandProject.click();

        return this;
    }

    //open news menu
    public ContentPage openNewsItemMenu() {
        //get news row
        WebElement newsRow = driver.findElement(By.xpath("//div[@class='row'][.//a[@title='news']]"));
        waitVisibility(newsRow);

        //click on item menu
        WebElement dropDown = newsRow.findElement(By.cssSelector(".hippo-tree-dropdown-icon-container"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", dropDown);

        return this;
    }

    //click add new news item in menu
    public  ModalWindow addNewNewsItem () {

        //click on Add new news item in Item menu
        WebElement addNewNewsItem = driver.findElement(By.xpath("//div[@id='context-menu-container']//a[.//span[@title='Add new news item...']]"));
        click(addNewNewsItem);

        return new ModalWindow(driver);
    }
}
