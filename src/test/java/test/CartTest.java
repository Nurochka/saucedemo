package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.CartPageService;
import service.InventoryPageService;
import service.LoginPageService;

import java.util.Arrays;

public class CartTest extends BaseTest{

    private int productIndex;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        user = new User();
    }

    @Test
    public void checkNameOfAddedProductInCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 4;
        String nameOfAddedToCartProduct = inventoryPageService.getProductNameByIndex(productIndex);
        inventoryPageService.clickAddToCartButtonByIndex(productIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        String[] namesOfProductsInCart = cartPageService.getProductNamesInCart();
        Boolean isProductInCart = Arrays.asList(namesOfProductsInCart).contains(nameOfAddedToCartProduct);
        Assert.assertTrue(isProductInCart);
    }

    @Test
    public void checkCounterValueCorrespondsNumberOfProductsInCartTest() {
        InventoryPageService inventoryPageService = loginPageService.login(user);
        productIndex = 1;
        inventoryPageService.clickAddToCartButtonByIndex(productIndex);
        CartPageService cartPageService = inventoryPageService.navigateToShoppingCart();
        int numberOfProductsInCart = cartPageService.getProductNamesInCart().length;
        int counterValue = cartPageService.getCartCounterValue();
        Assert.assertEquals(numberOfProductsInCart, counterValue);
    }
}
