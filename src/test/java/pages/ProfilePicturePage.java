package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePicturePage extends BasePage {

    public ProfilePicturePage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    // ===========================
    // Locators
    // ===========================

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenu;

    @FindBy(xpath = "//img[contains(@class,'employee-image')]")
    private WebElement profileImage;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//p[text()='Success']")
    private WebElement successToast;

    // ===========================
    // Methods
    // ===========================

    public void openMyInfo() {

        System.out.println("\n========== PROFILE PICTURE ==========");

        click(myInfoMenu);

        waitForPageToLoad();

        System.out.println("My Info Opened");

    }

    public void openPhotoPage() {
        click(myInfoMenu);
        waitForPageToLoad();

        click(profileImage);
        waitForPageToLoad();
    }

    public void uploadPhoto(String imagePath) {

        WebElement fileInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("input.oxd-file-input")));

        fileInput.sendKeys(imagePath);

        System.out.println("Image uploaded");
    }

    public void clickSave() {

        click(saveButton);

        waitUntilVisible(By.xpath("//p[text()='Success']"));
    }

    public boolean isPhotoUploaded() {

        return isDisplayed(successToast);

    }

}