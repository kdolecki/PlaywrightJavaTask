package com.example.PlaywrightJavaTask.pageobjects;

import com.microsoft.playwright.Page;

public class CartPage {
    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public void proceedToCheckout() {
        page.click("a[href='cart.html']");
        page.click("button[data-target='#orderModal']");
    }
}