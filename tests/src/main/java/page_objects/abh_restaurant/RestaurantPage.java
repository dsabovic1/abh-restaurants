package page_objects.abh_restaurant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.PageBase;

public class RestaurantPage extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurant\\d*";
    final static private String PERSONS_DROPDOWN_CSS = "form[class = 'reservation-form'] select";
    final static private String DATE_INPUT_CSS = "form[class = 'reservation-form'] input[type='date']";
    final static private String TIME_INPUT_CSS = "form[class = 'reservation-form'] input[type='time']";
    final static private String FIND_TABLE_BUTTON_CSS = "form[class = 'reservation-form'] button[type='submit']";
    final static private String MAP_CSS = "iframe[class='restaurant-map']";

    public RestaurantPage(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(css = FIND_TABLE_BUTTON_CSS)
    private WebElement findTableButton;

    @FindBy(css = DATE_INPUT_CSS)
    private WebElement dateInput;

    @FindBy(css = TIME_INPUT_CSS)
    private WebElement timeInput;

    @FindBy(css = PERSONS_DROPDOWN_CSS)
    private WebElement personsDropdown;

    @FindBy(css = MAP_CSS)
    private WebElement map;

    public WebElement getFindTableButton() {
        return findTableButton;
    }

    public WebElement getDateInput() {
        return dateInput;
    }

    public WebElement getTimeInput() {
        return timeInput;
    }

    public WebElement getPersonsDropdown() {
        return personsDropdown;
    }

    public WebElement getMap() {
        return map;
    }

    public RestaurantPage findTable(Integer numberOfPersons, String date, String time) {
        getDateInput().sendKeys(date);
        getTimeInput().sendKeys(time);
        getFindTableButton().click();
        return new RestaurantPage(getDriver());
    }

    public Boolean isMapDisplayed() {
        return map.isDisplayed();
    }
}
