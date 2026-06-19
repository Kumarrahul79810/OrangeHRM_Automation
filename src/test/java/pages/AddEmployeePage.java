package pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AddEmployeePage extends BasePage {

    public AddEmployeePage(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);

    }

    // ===========================
    // Locators
    // ===========================

    @FindBy(xpath = "//span[text()='PIM']")
    private WebElement pimMenu;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployeeMenu;

    @FindBy(name = "firstName")
    private WebElement txtFirstName;

    @FindBy(name = "lastName")
    private WebElement txtLastName;

    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement txtEmployeeId;

    @FindBy(xpath = "//span[contains(@class,'oxd-switch-input')]")
    private WebElement loginDetailsToggle;

    @FindBy(xpath = "//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement txtUsername;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement txtPassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personalDetailsHeader;

    // ===========================
    // Variables
    // ===========================

    private String employeeId;
    private String username;
    private String password;

    // ===========================
    // Navigation
    // ===========================

    public void openAddEmployeePage() {

        System.out.println("\n========== ADD EMPLOYEE ==========");

        System.out.println("Opening PIM Module...");

        click(pimMenu);

        System.out.println("PIM Module Opened");

        click(addEmployeeMenu);

        System.out.println("Add Employee Page Opened");

        waitForPageToLoad();

    }

    // ===========================
    // Employee Details
    // ===========================

    public void enterFirstName(String firstName) {

        System.out.println("Entering First Name : " + firstName);

        type(txtFirstName, firstName);

    }

    public void enterLastName(String lastName) {

        System.out.println("Entering Last Name : " + lastName);

        type(txtLastName, lastName);

    }

    public String getEmployeeId() {

        employeeId = getValue(txtEmployeeId);

        System.out.println("Generated Employee ID : " + employeeId);

        return employeeId;

    }

    // ===========================
    // Login Details
    // ===========================

    public void enableLoginDetails() {

        System.out.println("Enabling Login Details...");

        click(loginDetailsToggle);

        System.out.println("Login Details Enabled");

    }

    public void generateUsername() {

        username = "emp" + UUID.randomUUID().toString().substring(0, 6);

        System.out.println("Generated Username : " + username);

        type(txtUsername, username);

    }

    public void setPassword(String password) {

        this.password = password;

        System.out.println("Entering Password...");

        type(txtPassword, password);

        type(txtConfirmPassword, password);

        System.out.println("Password Entered Successfully");

    }

    // ===========================
    // Save
    // ===========================

    public void clickSave() {

        System.out.println("Clicking Save Button...");

        click(btnSave);

        System.out.println("Waiting for Employee to be Created...");

        // Loader khatam hone ka wait
        waitForLoader();

        // Page load complete hone ka wait
        waitForPageToLoad();

        // Personal Details page visible hone ka wait
        waitUntilVisible(By.xpath("//h6[text()='Personal Details']"));

        System.out.println("Employee Saved Successfully");
    }

    public boolean isEmployeeCreated() {

        boolean status = isDisplayed(personalDetailsHeader);

        if (status) {

            System.out.println("Personal Details Page Displayed");

        } else {

            System.out.println("Personal Details Page NOT Displayed");

        }

        return status;

    }

    // ===========================
    // Getters
    // ===========================

    public String getGeneratedUsername() {

        return username;

    }

    public String getGeneratedPassword() {

        return password;

    }

    public String getGeneratedEmployeeId() {

        return employeeId;

    }

}