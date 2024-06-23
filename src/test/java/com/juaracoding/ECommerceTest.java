package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.InventoryPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ECommerceTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        checkoutPage = new CheckoutPage();
        cartPage = new CartPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        return new Object[][] {
                {"standard_user", "secret_sauce"},
        };
    }

    @Test(dataProvider = "loginData")
    public void testAddProductToCart(String username, String password){
        // precondition
        loginPage.login(username, password);
        // steps-assert
        inventoryPage.setAddBtnToCart();
        Assert.assertEquals(inventoryPage.getTxtCartBadge(),"1");
        inventoryPage.setCartBtn();
        Assert.assertEquals(cartPage.getTxtItemName(),"Sauce Labs Backpack");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
        checkoutPage.setCheckoutBtn();
        checkoutPage.checkout("Mochamad Zien Hasan","Zen","40181");
        checkoutPage.setContinueBtn();
        checkoutPage.setFinishBtn();
    }
}