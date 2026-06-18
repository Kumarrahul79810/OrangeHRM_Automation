package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    // ===========================
    // Locators
    // ===========================

    @FindBy(name = "username")
    private WebElement txtUsername;

    @FindBy(name = "password")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboard;

    // ===========================
    // Methods
    // ===========================

    public void enterUsername(String username) {

        System.out.println("Entering Username : " + username);

        type(txtUsername, username);

    }

    public void enterPassword(String password) {

        System.out.println("Entering Password");

        type(txtPassword, password);

    }

    public void clickLogin() {

        System.out.println("Clicking Login Button...");

        click(btnLogin);

    }

    public void login(String username, String password) {

        System.out.println("\n========== LOGIN ==========");

        waitForPageToLoad();

        enterUsername(username);

        enterPassword(password);

        clickLogin();

        System.out.println("Waiting For Dashboard...");

        waitUntilVisible(By.xpath("//span[text()='Dashboard']"));

        System.out.println("Login Successful");

    }

    public boolean isLoginSuccessful() {

        boolean status = isDisplayed(dashboard);

        if (status) {

            System.out.println("Dashboard Displayed");

        } else {

            System.out.println("Dashboard NOT Displayed");

        }

        return status;

    }

}