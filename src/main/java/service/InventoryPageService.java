package service;

import model.User;
import page.CartPage;
import page.InventoryPage;

public class InventoryPageService {

    private InventoryPage inventoryPage = new InventoryPage();

    public String getActualNameOfMainPageSection() {
        return inventoryPage.getTextOfNameOfMainPageSection(); //в тестовом методе нельзя взаимодействовать с page objects! д.б. сервисная прослойка
    }

    public String[] getNamesOfAllProducts() {
        int numberOfProducts = inventoryPage.getNumberOfProducts();
        String[] listOfProductsName = new String[numberOfProducts];
        for (int i = 0; i < numberOfProducts; i++) {
            listOfProductsName[i] = inventoryPage.getListOfProducts().get(i).getText();
        }
        return listOfProductsName;
    }

    public String getProductNameByIndex(int index) {
        String[] listOfProductsName = this.getNamesOfAllProducts();
        int numberOfProducts = listOfProductsName.length;
        String ProductNameByIndex = null;
        if (index < numberOfProducts && index >= 0) {
            ProductNameByIndex = listOfProductsName[index];
        }
        return ProductNameByIndex;
    }

    public InventoryPageService clickAddToCartButtonByIndex(int index) {
        int numberOfButtons = inventoryPage.getNumberOfButtons();
        if (index<numberOfButtons && index>=0){
            inventoryPage.getListOfProductButtons().get(index).click();
        }
        return this;
    }

    public String getButtonNameByIndex(int index){
        int numberOfButtons = inventoryPage.getNumberOfButtons();
        String buttonName = null;
        if (index<numberOfButtons && index>=0){
            buttonName = inventoryPage.getListOfProductButtons().get(index).getText();
        }
        return buttonName;
    }

    public CartPageService navigateToShoppingCart(){
        inventoryPage.getCartButton().click();
        return new CartPageService();
    }







}
