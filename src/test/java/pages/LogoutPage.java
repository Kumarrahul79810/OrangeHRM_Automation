package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement profileMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutButton;

    public void logout() {

        System.out.println("\n========== LOGOUT ==========");

        System.out.println("Opening User Menu...");

        click(profileMenu);

        System.out.println("Clicking Logout...");

        click(logoutButton);

        System.out.println("Waiting For Login Page...");

        waitUntilVisible(By.name("username"));

        System.out.println("Logout Successful");

    }

    public boolean isLogoutSuccessful() {

        boolean status = driver.getCurrentUrl().contains("/auth/login");

        if (status) {

            System.out.println("Login Page Displayed");

        } else {

            System.out.println("Logout Failed");

        }

        return status;

    }

}