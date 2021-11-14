package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HolidayclubToursPage {
    private static final String TOURS_PAGE_URL = "https://www.holiday.by/tours";
    private static final String TOUR_PRICE_START = "//*[@id=\"tour-price-start\"]";
    private static final String TOUR_PRICE_END = "//*[@id=\"tour-price-end\"]";
    private static final String TOUR_NIGHT_START = "//*[@id=\"departure_date_start\"]";
    private static final String TOUR_NIGHT_END = "//*[@id=\"departure_date_end\"]";
    private static final String CLICK_TO_SEARCH = "/html/body/div[3]/div[2]/main/div/section/div/div/div[1]/div";
    private static final String EXPECTED_RESULT_OF_SEARCH = "/html/body/div[3]/div[2]/main/div/section/div/div/div[2]/div[2]/div[1]";
    private WebDriver driver;


    public HolidayclubToursPage(WebDriver driver) {
        this.driver = driver;
    }

    public HolidayclubToursPage openPage() {
        driver.get(TOURS_PAGE_URL);
        return this;
    }

    public HolidayclubToursPage inputTourStartPrice() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOUR_PRICE_START))).sendKeys("300");
        return this;
    }


    public HolidayclubToursPage inputTourEndPrice() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOUR_PRICE_END))).sendKeys("500");
        return this;
    }

    public HolidayclubToursPage inputTourStartNights() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOUR_NIGHT_START))).sendKeys("10.08.2021");
        return this;
    }

    public HolidayclubToursPage inputTourEndNights() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOUR_NIGHT_END))).sendKeys("11.08.2021");
        return this;
    }

    public HolidayclubToursPage clickToSearch() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOUR_NIGHT_START))).click();
        return this;
    }

    public boolean isResultOfSearchEmpty() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOUR_NIGHT_START)));
        if (driver.findElement(By.xpath(EXPECTED_RESULT_OF_SEARCH)) != null)
            return true;
        else return false;
    }
}
