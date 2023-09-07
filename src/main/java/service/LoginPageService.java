package service;

import model.User;
import page.LoginPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

    private LoginPage loginPage = new LoginPage();   // + неявно super конструктор из Page, который проинициализирует все эелементы;

    public InventoryPageService login(User user){
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInUserName(user.getName())
                .fillInPassword(user.getPassword())
                .clickLoginButton(); //вызываются цепочкой, т.к. в методах есть return this и они опрокидываюся дальше
        return new InventoryPageService();
    }

}
