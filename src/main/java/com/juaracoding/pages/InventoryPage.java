package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    //homepage
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement txtAppLogo;

    //add produk
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBtnToCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement txtCartBadge;

    //Assertion
    public boolean isAppLogoDisplayed(){
        return txtAppLogo.isDisplayed();
    }

    public void setAddBtnToCart(){
        addBtnToCart.click();
    }

    public void setCartBtn(){
        cartBtn.click();
    }
    public String getTxtCartBadge(){
        return txtCartBadge.getText();
    }
}
