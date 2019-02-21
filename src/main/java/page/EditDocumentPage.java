package page;

import commonComponent.CommonPageComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditDocumentPage extends BasePage {

    @FindBy(name = "cards:0:panel:editor:extension.editor:form:template:extension.left:view:1:item:view:1:item:value:widget")
    private WebElement title;

    @FindBy(name = "cards:0:panel:editor:extension.editor:form:template:extension.left:view:2:item:view:1:item:value:widget")
    private WebElement introduction;

    @FindBy(css = "#cke_1_contents > div")
    private WebElement content;

    @FindBy(name = "cards:0:panel:editor:extension.editor:form:template:extension.right:view:2:item:view:1:item:value:widget")
    private WebElement author;

    @FindBy(name = "cards:0:panel:editor:extension.editor:form:template:extension.right:view:3:item:view:1:item:value:widget")
    private WebElement source;

    @FindBy(id = "cards:0:panel:editor:extension.editor:form:template:extension.right:view:4:item:view:1:item:value:widget")
    private WebElement location;

    @FindBy(className = "hippo-datepicker-reset")
    private WebElement setToNow;

    @FindBy(xpath = "//div[@class='hippo-editor-toolbar']//li[@class='menu-item'][.//span[@title='Save & Close']]")
    private WebElement saveAndClose;

    public EditDocumentPage(WebDriver driver) {
        super(driver);

        //Assert main page elements
        Assert.assertTrue(title.isDisplayed(), "Title input field is not present on the Edit document page");
        Assert.assertTrue(introduction.isDisplayed(), "Introduction input field is not present on the Edit document page");
        Assert.assertTrue(content.isDisplayed(), "Content input field is not present on the Edit document page");
        Assert.assertTrue(source.isDisplayed(), "Source input field is not present on the Edit document page");
        Assert.assertTrue(saveAndClose.isDisplayed(), "Save and close button is not present on the toolbar menu");

        CommonPageComponent.getLeftBar().validate();
    }

    //set date now via click on button
    public EditDocumentPage setDateNow() {
        setToNow.click();
        return this;
    }

    //set document title
    public EditDocumentPage setTitle(String text) {

        title.sendKeys(text);
        return this;
    }

    //click save & close button
    public void saveAndClose() {
        saveAndClose.click();
    }

//    TODO: implement the rest of fields

}
