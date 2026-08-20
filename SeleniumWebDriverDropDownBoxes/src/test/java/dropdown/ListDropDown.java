package dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ListDropDown {

    WebDriver driver;
    String url = "https://testautomationpractice.blogspot.com/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    @Test
    public void testDropDown() throws Exception {

        // Locate Country dropdown
        WebElement country_DropDown = driver.findElement(By.id("country"));

        // Create Select object
        Select country_list = new Select(country_DropDown);

        // Select by index
        country_list.selectByIndex(3);
        Thread.sleep(2000);

        // Select by visible text
        country_list.selectByVisibleText("India");
        Thread.sleep(2000);

        // Get selected option
        WebElement option = country_list.getFirstSelectedOption();
        String countryName = option.getText();

        System.out.println("Selected country is: " + countryName);

        // Get all options
        List<WebElement> c_list = country_list.getOptions();

        // Count options
        int country_count = c_list.size();

        System.out.println("Total number of countries in the list are: " + country_count);

        // Print all country names
        for (WebElement country : c_list) {
            String countryname = country.getText();
            System.out.println("Country name is: " + countryname);
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}