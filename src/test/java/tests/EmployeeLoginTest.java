package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddEmployeePage;
import pages.LoginPage;
import pages.LogoutPage;

public class EmployeeLoginTest extends BaseClass {

    @Test
    public void employeeLoginTest() {

        // Admin Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Admin Login Failed");

        // Add Employee
        AddEmployeePage addEmployee = new AddEmployeePage(driver);

        addEmployee.openAddEmployeePage();

        String firstName = "Rahul";
        String lastName = "Kumar";

        addEmployee.enterFirstName(firstName);

        addEmployee.enterLastName(lastName);

        addEmployee.getEmployeeId();

        addEmployee.enableLoginDetails();

        addEmployee.generateUsername();

        addEmployee.setPassword("Rahul@123");

        // Store credentials
        String username = addEmployee.getGeneratedUsername();
        String password = addEmployee.getGeneratedPassword();

        addEmployee.clickSave();

        Assert.assertTrue(addEmployee.isEmployeeCreated(),
                "Employee Creation Failed");

        System.out.println("Employee Created Successfully");
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);

        // Logout Admin
        LogoutPage logoutPage = new LogoutPage(driver);

        logoutPage.logout();

        Assert.assertTrue(logoutPage.isLogoutSuccessful(),
                "Logout Failed");

        // Login With Newly Created Employee
        loginPage.login(username, password);

        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "Employee Login Failed");

        System.out.println("Employee Login Successful");

    }
}