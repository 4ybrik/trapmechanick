package test;

import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HolidayclubToursPage;

import java.io.File;


public class WebDriverHolidayclubTest<service> {
    private WebDriver driver;
    private Object service;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }
    @Test
    public void lookExpectedResultAfterSearch()throws InterruptedException {
        boolean expected = new HolidayclubToursPage(driver)
                .openPage()
                .inputTourStartPrice()
                .inputTourEndPrice()
                .inputTourStartNights()
                .inputTourEndNights()
                .clickToSearch()
                .clickToSearch()
                .isResultOfSearchEmpty();
        Assert.assertTrue(expected);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
