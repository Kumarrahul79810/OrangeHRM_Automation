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

        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");

        Assert.assertTrue(login.isLoginSuccessful());

        String firstName = "Rahul" + System.currentTimeMillis() % 10000;

        String lastName = "Kumar";

        AddEmployeePage employee = new AddEmployeePage(driver);

        employee.openAddEmployeePage();

        employee.enterFirstName(firstName);

        employee.enterLastName(lastName);

        employee.getEmployeeId();

        employee.enableLoginDetails();

        employee.generateUsername();

        employee.setPassword("Rahul@123");

        employee.clickSave();

        Assert.assertTrue(employee.isEmployeeCreated());

        EmployeeSearchPage search = new EmployeeSearchPage(driver);

        search.openEmployeeList();

        search.searchEmployee(firstName);

        Assert.assertTrue(search.isEmployeePresent(firstName));

        DeleteEmployeePage delete = new DeleteEmployeePage(driver);

        delete.openEmployeeList();

        delete.searchEmployee(firstName);

        delete.deleteEmployee();

        Assert.assertTrue(delete.isEmployeeDeleted());

    }

}