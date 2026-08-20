package MultipleFrames;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.Helper;

public class demo {

    @Test
    public void FrameTest() throws Exception {

        WebDriver driver = Helper.startBrowser("GC");

        try {

            // ------------------------------------------------
            // 1. Open the first page
            // ------------------------------------------------

            int totalframes = driver.findElements(By.tagName("iframe")).size();

            System.out.println("Total frames in the page are: " + totalframes);


            // Switch to iframe using name
            driver.switchTo().frame("easycalculation");

            // Open registration page inside the iframe
            driver.get("https://www.login.hiox.com/register?referrer=easycalculation.com");

            driver.findElement(By.id("log_email"))
                    .sendKeys("9390400988");

            driver.findElement(By.id("log_password"))
                    .sendKeys("YOUR_PASSWORD");

            driver.findElement(By.xpath("//input[contains(@name,'log_submit')]"))
                    .click();

            System.out.println("Title of the page is: " + driver.getTitle());


            // ------------------------------------------------
            // 2. Return to main document
            // ------------------------------------------------

            driver.switchTo().defaultContent();

            // Open local HTML page
            driver.get(
                "file:///C:/Users/engua/Desktop/testing/"
                + "SeleniumWebDriverCount%20copy/src/test/java/"
                + "MultipleFrames/demo.html"
            );

            Thread.sleep(2000);


            // ------------------------------------------------
            // 3. Switch to another iframe
            // ------------------------------------------------

            driver.switchTo().frame("My Store");

            driver.get("https://practicetestautomation.com/practice-test-login/");

            driver.findElement(By.id("username"))
                    .sendKeys("student");

            driver.findElement(By.id("password"))
                    .sendKeys("Password123");

            driver.findElement(By.id("submit"))
                    .click();

            System.out.println("Title of the page is: " + driver.getTitle());

            Thread.sleep(2000);


            // ------------------------------------------------
            // 4. Return to main document
            // ------------------------------------------------

            driver.switchTo().defaultContent();

        } finally {

            // Always close browser
            driver.quit();
        }
    }
}