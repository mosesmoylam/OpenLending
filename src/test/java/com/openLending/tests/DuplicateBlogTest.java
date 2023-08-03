package com.openLending.tests;

import com.openLending.pages.DuplicateBlogTestPage;
import com.openLending.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DuplicateBlogTest {

    DuplicateBlogTestPage duplicateBlogTestPage;
    public String url = "https://www.google.com";
    public String keyword = "Open Lending";

    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        duplicateBlogTestPage = new DuplicateBlogTestPage();
    }

    @Test
    public void testBlogDuplicate() {
        // Step 1: User navigates to Google
        Driver.getDriver().get(url);

        // Step 2: User enters "Open Lending" in Google search box
        duplicateBlogTestPage.getSearchBox().sendKeys(keyword + Keys.ENTER);

        // Step 3: User navigates to OpenLending page in results
        duplicateBlogTestPage.getOpenLendingLink().click();

        // Step 4: User navigates to resources insights page
        duplicateBlogTestPage.getResourcesPage().click();

        // Step 5: User verifies there is no duplicate blogs
        Map<String, Integer> map = new HashMap<>();
        for (WebElement elements : duplicateBlogTestPage.getBlogsList()) {
            String readMoreText = elements.getAttribute("href");
            if (!map.containsKey(readMoreText)) {
                map.put(readMoreText, 1);
            } else {
                map.put(readMoreText, map.get(readMoreText) + 1);
            }
        }

        for (Integer value : map.values()) {
            Assert.assertTrue(value > 1, "There are duplicate blogs");
        }
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    }
}
