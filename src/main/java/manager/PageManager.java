package manager;

import org.openqa.selenium.WebDriver;
import page.*;

public class PageManager {

    private WebDriver driver;

    private ContentPage contentPage;
    private DashboardPage dashboardPage;
    private EditDocumentPage editDocumentPage;
    private LoginPage loginPage;
    private ViewDocumentPage viewDocumentPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public ContentPage getContentPage() {

        return contentPage == null ? contentPage = new ContentPage(driver) : contentPage;
    }

    public DashboardPage getDashboardPage() {

        return dashboardPage == null ? dashboardPage = new DashboardPage(driver) : dashboardPage;

    }

    public EditDocumentPage getEditDocumentPage() {

        return editDocumentPage == null ? editDocumentPage = new EditDocumentPage(driver) : editDocumentPage;
    }

    public LoginPage getLoginPage() {

        return loginPage == null ? loginPage = new LoginPage(driver) : loginPage;
    }

    public ViewDocumentPage getViewDocumentPage() {

        return viewDocumentPage == null ? viewDocumentPage = new ViewDocumentPage(driver) : viewDocumentPage;

    }
}
