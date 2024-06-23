    package com.juaracoding.pages;

    import com.juaracoding.drivers.DriverSingleton;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

    public class CheckoutPage {
        private WebDriver driver;

        public CheckoutPage(){
            this.driver = DriverSingleton.getDriver();
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//button[@id='checkout']")
        private WebElement checkoutBtn;

        @FindBy(xpath = "//input[@id='first-name']")
        private WebElement firstName;

        @FindBy(xpath = "//input[@id='last-name']")
        private WebElement lastName;

        @FindBy(xpath = "//input[@id='postal-code']")
        private WebElement postalCode;

        @FindBy(xpath = "//input[@id='continue']")
        private WebElement continueBtn;

        @FindBy(xpath = "//button[@id='finish']")
        private WebElement finishBtn;

        @FindBy(xpath = "//span[@class='title']")
        private WebElement txtCheckoutOverviewTitle;

        @FindBy(xpath = "//h2[@class='complete-header']")
        private WebElement txtCompleteHeader;


        public void setCheckoutBtn(){
            checkoutBtn.click();
        }

        public void checkout(String firstName, String lastName, String postalCode){
            this.firstName.sendKeys(firstName);
            this.lastName.sendKeys(lastName);
            this.postalCode.sendKeys(postalCode);
        }

        public void setContinueBtn(){
            continueBtn.click();
        }

        public String getTxtCheckoutOverviewTitle(){
            return txtCheckoutOverviewTitle.getText();
        }

        public void setFinishBtn(){
            finishBtn.click();
        }

        public String getTxtCompleteHeader(){
            return txtCompleteHeader.getText();
        }

    }
