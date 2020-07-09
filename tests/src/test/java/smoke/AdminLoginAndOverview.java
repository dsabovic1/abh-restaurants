package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.*;
import testUtils.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminLoginAndOverview extends TestBase {
    private static final String FIRST_NAME = "Jane";
    private static final String LAST_NAME = "Doe";
    private static final String EMAIL = "jdoe@live.com";
    private static final String PHONE_NUMBER = "123456";
    private static final String ADDRESS = "Pijacna 118";
    private static final String PASSWORD = "1234";
    private static final String HEADER_TEXT = "Make a free reservation";

    @Test(priority = 0)
    public void openLoginPage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 1)
    public void openRegistrationPage() {
        new LoginPage(driver)
                .clickRegisterButton();
    }

    @Test(priority = 2)
    public void populateRegistrationForm() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMHHmm");
        Date date = new Date();
        new Registration(driver)
                .makeRegistration(FIRST_NAME, LAST_NAME, formatter.format(date)+EMAIL, PHONE_NUMBER, ADDRESS, PASSWORD, PASSWORD);
    }

    @Test(priority = 3)
    public void checkUserIsRegistered(){
        Assert.assertTrue(new HomePage(driver)
                .checkMainText(HEADER_TEXT));
    }
}
