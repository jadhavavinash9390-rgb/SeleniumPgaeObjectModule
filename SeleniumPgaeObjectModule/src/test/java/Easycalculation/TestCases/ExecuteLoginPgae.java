package Easycalculation.TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import Easycalculation.pages.LoginEasyCal;
import Helper.BrowserFactory;
import org.openqa.selenium.support.PageFactory;

public class ExecuteLoginPgae {
    @Test
    public void loginTest() {
        WebDriver driver = BrowserFactory.BrowserOptions("chrome", "https://www.login.hiox.com/login?referrer=easycalculation.com");
        LoginEasyCal loginPage = PageFactory.initElements(driver, LoginEasyCal.class);
        loginPage.loginToEasyCal("9740673180", "raghubn@gmail.com");

    }

}
