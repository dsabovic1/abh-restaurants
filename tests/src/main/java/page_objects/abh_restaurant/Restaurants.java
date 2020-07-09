package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class Restaurants extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurants\\d*";
    final static private String RESERVE_NOW_BUTTON_CSS = "button[class*='reserve-now-button']";


    public Restaurants(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = RESERVE_NOW_BUTTON_CSS)
    private WebElement reserveNowButton;

    public WebElement getReserveNowButton(){
        return reserveNowButton;
    }

    public RestaurantPage clickReserveNowButton(){
        getReserveNowButton().click();
        return new RestaurantPage(getDriver());
    }
}
