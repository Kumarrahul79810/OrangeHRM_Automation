package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class EmployeeSearchPage extends BasePage {

    public EmployeeSearchPage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    // ===========================
    // Locators
    // ===========================

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//a[text()='Employee List']")
    private WebElement employeeListMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElement employeeName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchBtn;

    // ===========================
    // Navigation
    // ===========================

    public void openEmployeeList() {

        System.out.println("\n========== EMPLOYEE SEARCH ==========");

        System.out.println("Opening PIM Module...");

        click(pimMenu);

        System.out.println("PIM Module Opened");

        click(employeeListMenu);

        System.out.println("Employee List Opened");

        waitForPageToLoad();

    }

    // ===========================
    // Search Employee
    // ===========================

    public void searchEmployee(String empName) {

        System.out.println("Searching Employee : " + empName);

        type(employeeName, empName);

        waitUntilVisible(By.xpath("//div[@role='listbox']"));

        System.out.println("Suggestion List Displayed");

        employeeName.sendKeys(Keys.ARROW_DOWN);
        employeeName.sendKeys(Keys.ENTER);

        System.out.println("Employee Selected");

        click(searchBtn);

        System.out.println("Search Button Clicked");

        waitForLoader();

        waitUntilVisible(By.xpath("//div[contains(@class,'oxd-table-body')]"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Search Completed");
    }

    // ===========================
    // Validation
    // ===========================

    public boolean isEmployeePresent(String empName) {

        try {

            System.out.println("Verifying Employee Presence...");

            waitUntilVisible(By.xpath("//div[contains(@class,'oxd-table-body')]"));

            boolean status = !driver.findElements(
                            By.xpath("//div[contains(@class,'oxd-table-body')]//*[contains(normalize-space(),'"
                                    + empName + "')]"))
                    .isEmpty();

            if (status) {

                System.out.println("Employee Found Successfully");

            } else {

                System.out.println("Employee NOT Found");

            }

            return status;

        } catch (Exception e) {

            System.out.println("Error While Searching Employee");

            e.printStackTrace();

            return false;

        }

    }

}