package tests;

import model.Document;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.*;
import utils.Utils;

import java.io.IOException;

public class DocumentTest extends BaseTest {

    private Document document;

    //get document test data from file
    @BeforeClass
    public void getDocumentTestData() throws IOException {
        document = Utils.createDocumentFromFile();
    }

    @AfterClass
    public void cleanUp() {
        //Delete the document after the test
        pageManager.getViewDocumentPage().openDocumentMenuItem().deleteDocument().accept();
    }

    @Test
    public void documentTitleIsDisplayedOnPreview() {

        //Login as admin user
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));

        //navigate to Content Page from dashboard page
        DashboardPage dashboard = pageManager.getDashboardPage();
        dashboard.gotoContent();

        //Create new document in News section
        ContentPage contentPage = pageManager.getContentPage();
        contentPage.expandProjectFolder().openNewsItemMenu().addNewNewsItem().setText("name-url:name", document.getTitle()).accept();
        EditDocumentPage doc = new EditDocumentPage(getDriver());

        //Set Date Now, Document Title, Save & Close
        doc.setDateNow().setTitle(document.getTitle()).saveAndClose();
        ViewDocumentPage viewDoc = pageManager.getViewDocumentPage();

        //Verify the title on the preview page
        Assert.assertTrue(viewDoc.getTitle().equals(document.getTitle()));
    }

}