package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import page_objects.PageBase;

public class AdminPage extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/admin\\d*";


    public AdminPage(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }
}
