package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

import java.util.List;

public class AdminPage extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/admin\\d*";
    final static private String ADMIN_STATISTIC_ELEMENT_CSS = "div[class='admin-statistic']";

    @FindBy(css = ADMIN_STATISTIC_ELEMENT_CSS)
    private List<WebElement> adminStatistics;

    public AdminPage(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    public Boolean checkIfStatisticsDisplayed() {
        if (adminStatistics.size()!=4) return false;
        return true;
    }
}
