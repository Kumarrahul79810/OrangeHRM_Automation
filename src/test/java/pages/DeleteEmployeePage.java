package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class DeleteEmployeePage extends BasePage {

    public DeleteEmployeePage(WebDriver driver) {

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

    @FindBy(xpath = "//i[contains(@class,'bi-trash')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(@class,'oxd-button--label-danger')]")
    private WebElement confirmDeleteBtn;

    // ===========================
    // Navigation
    // ===========================

    public void openEmployeeList() {

        System.out.println("Opening PIM Module...");

        click(pimMenu);

        System.out.println("PIM Opened");

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

        employeeName.sendKeys(Keys.ARROW_DOWN);

        employeeName.sendKeys(Keys.ENTER);

        click(searchBtn);

        waitForLoader();

        System.out.println("Search Completed");

    }

    // ===========================
    // Delete Employee
    // ===========================

    public void deleteEmployee() {

        System.out.println("Clicking Delete Button...");

        click(deleteBtn);

        System.out.println("Delete Popup Opened");

        click(confirmDeleteBtn);

        System.out.println("Delete Confirmed");

        waitForLoader();

        System.out.println("Delete Process Completed");

    }

    // ===========================
    // Validation
    // ===========================

    public boolean isEmployeeDeleted() {

        try {

            waitUntilVisible(By.xpath("//p[text()='Success']"));

            System.out.println("Employee Deleted Successfully");

            return true;

        } catch (Exception e) {

            System.out.println("Employee Delete Failed");

            return false;

        }

    }

}