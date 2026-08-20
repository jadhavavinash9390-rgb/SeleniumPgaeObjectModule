package Easycalculation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginEasyCal {
    WebDriver driver;
    public LoginEasyCal(WebDriver driver) {
        this.driver = driver;
    }
    
    @FindBy(id="log_email")
    WebElement email;

    @FindBy(id="log_password")
    WebElement password;

    @FindBy(xpath="//input[contains(@name,'log_submit')]")
    WebElement loginButton;

    public void loginToEasyCal(String uname, String pass) {
        email.sendKeys(uname);
        password.sendKeys(pass);
        loginButton.click();

    }

}
