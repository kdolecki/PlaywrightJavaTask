package com.example.PlaywrightJavaTask.pageobjects;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickLoginButton() {
        page.click("#login2");
    }

    public void selectSmartphone() {
        page.click(".card-title a");
    }
}