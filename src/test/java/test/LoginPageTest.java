package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.InventoryPageService;
import service.LoginPageService;

public class LoginPageTest extends BaseTest {

    @BeforeClass
    public void setUp() {
    loginPageService = new LoginPageService();
    user = new User(); //можно инициализировать и в тестовом методе
    }

    @Test
    public void checkSuccessfulLoginTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        String actualTextOfMainPageSection = inventoryPageService.getActualNameOfMainPageSection();
        String expectedTextOfMainPageSection = "Products";
        Assert.assertEquals(actualTextOfMainPageSection, expectedTextOfMainPageSection, "Login failed!" +
                " Actual name doesn't match expected");

    }
}
