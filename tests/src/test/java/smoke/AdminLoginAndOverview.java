package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.*;
import testUtils.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminLoginAndOverview extends TestBase {
    private static final String EMAIL = "admin@example.com";
    private static final String PASSWORD = "admin";
    private static final String HEADER_TEXT = "Make a free reservation";

    @Test(priority = 0)
    public void openLoginPage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 1)
    public void login() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmm");
        Date date = new Date();
        new LoginPage(driver)
                .login(EMAIL, PASSWORD);
    }

    @Test(priority = 2)
    public void checkUserIsRegistered(){
        Assert.assertTrue(new HomePage(driver)
                .checkMainText(HEADER_TEXT));
    }

    @Test(priority = 3)
    public void openUserDetails() {
        new HomePage(driver)
                .clickAdminPage(2);
    }
}
