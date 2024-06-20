package com.example.PlaywrightJavaTask.steps;

import com.microsoft.playwright.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import com.example.PlaywrightJavaTask.pageobjects.*;

public class PurchaseSteps {
    private Page page;
    private Browser browser;
    private BrowserContext context;
    private LoginPage loginPage;
    private HomePage homePage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        Playwright playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        productPage = new ProductPage(page);
        cartPage = new CartPage(page);
        checkoutPage = new CheckoutPage(page);
    }

    @After
    public void tearDown() {
        context.close();
        browser.close();
    }

    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        page.navigate("https://www.demoblaze.com/index.html");
        homePage.clickLoginButton();
        loginPage.login("rimohe6704@lisoren.com", "BZ%8E:.yx_a3^b7");
    }

    @When("the user selects a smartphone to purchase")
    public void theUserSelectsASmartphoneToPurchase() {
        productPage.selectRandomPhone();
    }

    @And("the user adds the smartphone to the cart")
    public void theUserAddsTheSmartphoneToTheCart() {
        productPage.addToCart();
    }

    @And("the user completes the checkout process")
    public void theUserCompletesTheCheckoutProcess() {
        cartPage.proceedToCheckout();
        checkoutPage.enterDetailsAndSubmit();
    }

    @Then("the user should see a confirmation message")
    public void theUserShouldSeeAConfirmationMessage() {
        checkoutPage.verifyConfirmationMessage();
    }
}