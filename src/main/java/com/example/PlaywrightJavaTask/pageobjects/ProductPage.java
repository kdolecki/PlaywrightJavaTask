package com.example.PlaywrightJavaTask.pageobjects;

import com.microsoft.playwright.Page;

public class ProductPage {
    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void selectRandomPhone() {
        page.waitForSelector("a.hrefch[href='prod.html?idp_=2']");
        page.click("a.hrefch[href='prod.html?idp_=2']");
    }

    public void addToCart() {
        page.waitForSelector("a.btn.btn-success.btn-lg:has-text('Add to cart')");
        
        try {
            page.click("a.btn.btn-success.btn-lg:has-text('Add to cart')");
        } catch (Exception e) {
            throw new RuntimeException("Add to Cart button not found", e);
        }
    }
}