package com.example.PlaywrightJavaTask.pageobjects;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void enterDetailsAndSubmit() {
        page.fill("#name", "Lorem Ipsum");
        page.fill("#country", "Poland");
        page.fill("#city", "Gdansk");
        page.fill("#card", "1234567812345678");
        page.fill("#month", "06");
        page.fill("#year", "2024");
        page.click("button[onclick='purchaseOrder()']");
    }

    public void verifyConfirmationMessage() {
        page.waitForSelector("h2:has-text('Thank you for your purchase!')", new Page.WaitForSelectorOptions().setTimeout(10000));
        String confirmationMessage = page.locator("h2:has-text('Thank you for your purchase!')").innerText();
        if (!"Thank you for your purchase!".equals(confirmationMessage)) {
            throw new RuntimeException("Confirmation message not found or incorrect");
        }
    }
}