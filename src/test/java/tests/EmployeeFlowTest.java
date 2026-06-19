package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddEmployeePage;
import pages.DeleteEmployeePage;
import pages.EmployeeSearchPage;
import pages.LoginPage;

public class EmployeeFlowTest extends BaseClass {

    @Test
    public void employeeLifeCycleTest() {

        // Login as Admin
        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");

        Assert.assertTrue(login.isLoginSuccessful());

        // Create Test Data
        String firstName = "Rahul" + System.currentTimeMillis() % 10000;
        String lastName = "Kumar";

        // Open Add Employee Page
        AddEmployeePage employee = new AddEmployeePage(driver);

        employee.openAddEmployeePage();

        // Enter Employee Details
        employee.enterFirstName(firstName);
        employee.enterLastName(lastName);

        // Store Generated Employee ID
        String employeeId = employee.generateEmployeeId();

        // Enable Employee Login Detail
        employee.enableLoginDetails();

        // Generate Unique Username
        employee.generateUsername();

        // Set Employee Password
        employee.setPassword("Rahul@123");

        // Save Employee
        employee.clickSave();

        Assert.assertTrue(employee.isEmployeeCreated());

        // Search Newly Created Employee
        EmployeeSearchPage search = new EmployeeSearchPage(driver);

        search.openEmployeeList();

        search.searchEmployee(firstName);

        Assert.assertTrue(search.isEmployeePresent(firstName));

        // Delete Employee
        DeleteEmployeePage delete = new DeleteEmployeePage(driver);

        delete.openEmployeeList();

        delete.searchEmployee(firstName);

        delete.deleteEmployee();

        Assert.assertTrue(delete.isEmployeeDeleted());

    }

}