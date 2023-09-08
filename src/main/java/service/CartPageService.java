package service;

import page.CartPage;
import page.InventoryPage;

import java.util.List;

public class CartPageService {

    private CartPage cartPage = new CartPage();

    public String[] getProductNamesInCart() {
        int numberOfProductNames = cartPage.getNumberOfProductNamesInCart();
        String[] productNamesInCart = new String[numberOfProductNames];
        for (int i = 0; i < numberOfProductNames; i++) {
            productNamesInCart[i] = cartPage.getListOfProductNamesInCart().get(i).getText();
        }
        return productNamesInCart;
    }

    public int getCartCounterValue() {
        int cartCounterValue = Integer.parseInt(cartPage.getCartCounter().getText());
        return cartCounterValue;
    }

    public CartPageService RemoveFirstProductInCart() {
        cartPage.getListOfRemoveButtonsInCart().get(0).click();
        return this;
    }


}
