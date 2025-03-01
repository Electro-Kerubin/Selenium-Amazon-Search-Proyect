package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        // Sin interfaz grafica
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // driver.manage().window().maximize();
        // asd
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }
    
    public void goToLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public String textFromElement(String locator) {
        return Find(locator).getText();
    }

    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for(WebElement option : dropdownOptions) {
            values.add(option.getText());
        }
        
        return values;
    }

    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public void selectNthElement(String locator, int index) {
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }

    public boolean imagenDisplayed(String locator) {
        return Find(locator).isDisplayed();
    } 

    // Actions
    public void hoverOverElement(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        WebElement element = driver.findElement(By.xpath(locator));
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.moveToElement(element).perform();
    }

    public List<WebElement> getResultListAmazonPage(String type) {

        List<WebElement> results = new ArrayList<>();

        if(type.equals("suggestionResult")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sac-autocomplete-results-container\"]/div[1]/div[1]")));
            results = driver.findElements(By.xpath("//div[contains(@class, 's-suggestion')]"));
        } else if(type.equals("searchResult")) {
            results = driver.findElements(By.cssSelector("div.s-main-slot div.s-result-item"));
        }

        System.out.println("resultado: " + results);
        return results;
    }

}
