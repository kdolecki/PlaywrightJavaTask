package com.example.PlaywrightJavaTask.pageobjects;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String username, String password) {
        page.navigate("https://www.demoblaze.com/index.html");
        page.locator("a:has-text('Log in')").click();
        page.locator("#loginusername").click();
        page.locator("#loginusername").fill(username);
        page.locator("#loginpassword").click();
        page.locator("#loginpassword").fill(password);
        page.locator("button:has-text('Log in')").click();
    }
}