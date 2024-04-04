package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    String url = "http://automationexercise.com";

    WebDriver driver = null;

    @Given("user launches the browser")
    public void user_launches_the_browser() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");

        // Initialise Chrome driver and set driver size
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }


    @When("user navigates to url {string}")
    public void user_navigates_to_url(String url) {
        driver.navigate().to(url);
    }


    @Then("user verifies that home page is visible successfully")
    public void user_verifies_that_home_page_is_visible_successfully() {
        WebElement homepage = driver.findElement(By.xpath(Locators.FEATURED_ITEMS));
        Assert.assertTrue("Homepage is not visible.", homepage.isDisplayed());
    }


    @Then("user adds products to cart")
    public void user_adds_products_to_cart() {
        WebElement elementToHover = driver.findElement(By.xpath(Locators.ITEM_MODAL));
        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Hover over the element
        actions.moveToElement(elementToHover).perform();

        // Find the element to click after hover
        WebElement elementToClick = driver.findElement(By.xpath(Locators.ADD_TO_CART));
        elementToClick.click();
    }


    @Then("user clicks 'Cart' button")
    public void user_clicks_button() {
        //We start by closing modal that said "item added to shopping cart successfully
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Wait up to 5 seconds

        // Find the element to wait for
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.CONTINUE_SHOPPING_BUTTON)));
        element.click();

        //Navigate to shopping cart page
        driver.findElement(By.xpath(Locators.SHOPPING_CART_PAGE)).click();

    }


    @Then("user verifies that cart page is displayed")
    public void user_verifies_that_cart_page_is_displayed() {
        WebElement homepage = driver.findElement(By.xpath(Locators.SHOPPING_CART_PAGE_ASSERTION));
        Assert.assertTrue("Shopping cart page is not visible.", homepage.isDisplayed());
    }


    @Then("user clicks Proceed To Checkout")
    public void user_clicks_proceed_to_checkout() {
        driver.findElement(By.xpath(Locators.PROCEED_TO_CHECKOUT_BUTTON)).click();
    }


    @Then("user clicks 'Register Login' button")
    public void user_clicks_Register_Login_button(){
        driver.findElement(By.xpath(Locators.REGISTER_LOGIN_BUTTON)).click();
    }


    @Then("user fills all details in Signup and creates account")
    public void user_fills_all_details_in_signup_and_creates_account() {
        // Fill in registration form

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locators.NAME_INPUT)));

        driver.findElement(By.xpath(Locators.NAME_INPUT)).sendKeys(AccountData.NAME);
        driver.findElement(By.xpath(Locators.EMAIL_INPUT)).sendKeys(AccountData.EMAIL);

        driver.findElement(By.xpath(Locators.SIGNUP_BUTTON)).click();

        //input the rest of information required for creating an account
        driver.findElement(By.xpath(Locators.PASSWORD)).sendKeys(AccountData.PASSWORD);
        driver.findElement(By.xpath(Locators.FIRST_NAME)).sendKeys(AccountData.NAME);
        driver.findElement(By.xpath(Locators.LAST_NAME)).sendKeys(AccountData.LAST_NAME);
        driver.findElement(By.xpath(Locators.ADDRESS)).sendKeys(AccountData.ADDRESS);
        driver.findElement(By.xpath(Locators.STATE)).sendKeys(AccountData.STATE);
        driver.findElement(By.xpath(Locators.CITY)).sendKeys(AccountData.CITY);
        driver.findElement(By.xpath(Locators.ZIPCODE)).sendKeys(AccountData.ZIPCODE);
        driver.findElement(By.xpath(Locators.PHONE_NUMBER)).sendKeys(AccountData.PHONE_NUMBER, Keys.ENTER);
    }


    @Then("user verifies ACCOUNT CREATED! and clicks Continue button")
    public void user_verifies_account_created_and_clicks_continue_button() {
        WebElement verification = driver.findElement(By.xpath(Locators.SUCCESSFUL_REGISTRATION_VERIFICATION));
        Assert.assertTrue("Verification of registration is not visible.", verification.isDisplayed());

        driver.findElement(By.xpath(Locators.CONTINUE_BUTTON)).click();
    }


    @Then("user verifies account name at top")
    public void user_verifies_account_name_at_top() {
        WebElement element = driver.findElement(By.xpath(Locators.ACCOUNT_NAME));
        String visibleAccountName = element.getText();

        Assert.assertEquals(visibleAccountName, AccountData.NAME);
    }

    @Then("user clicks 'Cart' button again")
    public void user_clicks_cart_button_again() {
        driver.findElement(By.xpath(Locators.SHOPPING_CART_PAGE)).click();
    }

    @Then("user clicks 'Proceed To Checkout' button")
    public void user_clicks_proceed_to_checkout_button(){
        driver.findElement(By.xpath(Locators.PROCEED_TO_CHECKOUT_BUTTON)).click();
    }

    @Then("user verifies Address Details and Review Your Order")
    public void user_verifies_address_details_and_review_your_order() {
        WebElement deliveryName = driver.findElement(By.xpath(Locators.DELIVERY_NAME));
        String visibleDeliveryName = deliveryName.getText();

        WebElement deliveryAddress = driver.findElement(By.xpath(Locators.DELIVERY_ADDRESS));
        String visibleDeliveryAddress = deliveryAddress.getText();

        WebElement deliveryCityStateZip = driver.findElement(By.xpath(Locators.DELIVERY_CITY_STATE_ZIP));
        String visibleDeliveryCityStateZip = deliveryCityStateZip.getText();

        WebElement deliveryPhoneNumber = driver.findElement(By.xpath(Locators.DELIVERY_PHONE_NUMBER));
        String visibleDeliveryPhoneNumber = deliveryPhoneNumber.getText();


        Assert.assertEquals(visibleDeliveryName, AccountData.NAME + " " + AccountData.LAST_NAME);
        Assert.assertEquals(visibleDeliveryAddress, AccountData.ADDRESS);
        Assert.assertEquals(visibleDeliveryCityStateZip, AccountData.CITY + " " + AccountData.STATE + " " + AccountData.ZIPCODE);
        Assert.assertEquals(visibleDeliveryPhoneNumber, AccountData.PHONE_NUMBER);

    }


    @Then("user enters description in comment text area and clicks Place Order")
    public void user_enters_description_in_comment_text_area_and_clicks_place_order() {
        driver.findElement(By.xpath(Locators.ORDER_DETAILS)).sendKeys("Please ship as soon as possible");
        driver.findElement(By.xpath(Locators.PLACE_ORDER_BUTTON)).click();
    }


    @Then("user enters payment details: Name on Card, Card Number, CVC, Expiration date")
    public void user_enters_payment_details_name_on_card_card_number_cvc_expiration_date() {
        driver.findElement(By.xpath(Locators.CARD_OWNER_NAME)).sendKeys(AccountData.CARD_NAME);
        driver.findElement(By.xpath(Locators.CARD_NUMBER)).sendKeys(AccountData.CARD_NUMBER);
        driver.findElement(By.xpath(Locators.CVC)).sendKeys(AccountData.CVC);
        driver.findElement(By.xpath(Locators.CARD_EXPIRATION_MONTH)).sendKeys(AccountData.CARD_EXPIRATION_MONTH);
        driver.findElement(By.xpath(Locators.CARD_EXPIRATION_YEAR)).sendKeys(AccountData.CARD_EXPIRATION_YEAR);

        driver.findElement(By.xpath(Locators.PAY_AND_CONFIRM_ORDER_BUTTON)).click();
    }


    @Then("user verifies success message Your order has been placed successfully!")
    public void user_verifies_success_message() {
        WebElement orderResult = driver.findElement(By.xpath(Locators.ORDER_VERIFICATION));
        String paymentOutput = orderResult.getText();

        Assert.assertEquals("Order Placed!", paymentOutput);
    }


    @And("user clicks 'Delete Account' button")
    public void user_clicks_Delete_Account_button(){
        driver.findElement(By.xpath(Locators.DELETE_ACCOUNT_BUTTON)).click();
    }

    @Then("user verifies 'ACCOUNT DELETED!' and clicks 'Continue' button")
    public void user_verifies_ACCOUNT_DELETED_and_clicks_Continue_button(){
        WebElement deleteAccountResult = driver.findElement(By.xpath(Locators.DELETE_ACCOUNT_VERIFICATION));
        String deleteAccountOutput = deleteAccountResult.getText();

        Assert.assertEquals("Account Deleted!", deleteAccountOutput);

        driver.findElement(By.xpath(Locators.CONTINUE_BUTTON)).click();
    }

}
