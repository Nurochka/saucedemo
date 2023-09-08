package test;

import driver.DriverSingleton;
import model.User;
import org.testng.annotations.AfterClass;
import service.LoginPageService;

public class BaseTest {

    protected LoginPageService loginPageService;
    protected User user;

   /* @AfterClass
    public void stopBrowser() {

        DriverSingleton.getInstance().closeDriver();
    }*/
}
