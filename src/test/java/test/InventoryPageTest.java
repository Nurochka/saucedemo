package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.InventoryPageService;
import service.LoginPageService;

public class InventoryPageTest extends BaseTest {

    private int productIndex;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test
    public void checkAddToCartButtonChangeItsNameAfterClickingTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 4;
        //String initialButtonName = inventoryPageService.getButtonNameByIndex(productIndex);
        String clickedButtonName = inventoryPageService.clickAddToCartButtonByIndex(productIndex).getButtonNameByIndex(productIndex);
        Assert.assertEquals(clickedButtonName, "Remove");
    }
}
