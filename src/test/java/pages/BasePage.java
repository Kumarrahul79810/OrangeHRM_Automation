package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // ===========================
    // Wait Methods
    // ===========================

    protected void waitForVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected void waitForClickable(WebElement element) {

        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    protected void waitForPageToLoad() {

        wait.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));

    }

    protected void waitForLoader() {

        try {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(

                    By.xpath("//div[contains(@class,'oxd-form-loader')]")

            ));

        } catch (Exception ignored) {

        }

    }

    // ===========================
    // Element Actions
    // ===========================

    protected void click(WebElement element) {

        waitForLoader();

        waitForClickable(element);

        element.click();

    }

    protected void jsClick(WebElement element) {

        waitForLoader();

        waitForClickable(element);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);

    }

    protected void type(WebElement element, String text) {

        waitForVisibility(element);

        element.clear();

        element.sendKeys(text);

    }

    protected String getText(WebElement element) {

        waitForVisibility(element);

        return element.getText();

    }

    protected String getValue(WebElement element) {

        waitForVisibility(element);

        return element.getAttribute("value");

    }

    protected boolean isDisplayed(WebElement element) {

        try {

            waitForVisibility(element);

            return element.isDisplayed();

        }

        catch (Exception e) {

            return false;

        }

    }

    // ===========================
    // Scroll
    // ===========================

    protected void scrollIntoView(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(

                "arguments[0].scrollIntoView({block:'center'});",

                element

        );

    }

    // ===========================
    // Generic Wait
    // ===========================

    protected void waitUntilInvisible(By locator) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

    }

    protected void waitUntilVisible(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

}