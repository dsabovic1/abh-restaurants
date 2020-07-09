package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import page_objects.abh_restaurant.RestaurantPage;
import page_objects.abh_restaurant.Restaurants;
import testUtils.TestBase;

public class CheckoutRestaurantInfo extends TestBase {
    private static final String HEADER_TEXT = "Make a free reservation";

    @Test(priority = 0)
    public void checkIfHomePage() {
        Assert.assertTrue(new HomePage(driver)
                .checkMainText(HEADER_TEXT));
    }

    @Test(priority = 1)
    public void openRestaurantsPage() {
        new HomePage(driver)
                .openRestaurantsPage(1);
    }

    @Test(priority = 2)
    public void openRestaurantDetailsPage() {
        new Restaurants(driver)
                .clickReserveNowButton();
    }

    @Test(priority = 3)
    public void checkIfMapExists() {
        Assert.assertTrue(new RestaurantPage(driver)
                .isMapDisplayed());
    }
}
