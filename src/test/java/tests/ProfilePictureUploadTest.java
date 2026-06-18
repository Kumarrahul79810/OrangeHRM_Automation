package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.ProfilePicturePage;

public class ProfilePictureUploadTest extends BaseClass {

    @Test
    public void uploadProfilePictureTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");

        Assert.assertTrue(login.isLoginSuccessful());

        ProfilePicturePage picture = new ProfilePicturePage(driver);

        picture.openMyInfo();

        picture.openPhotoPage();

        String imagePath = System.getProperty("user.dir")
                + "\\src\\test\\resources\\images\\PROFILE.jpg";

        picture.uploadPhoto(imagePath);

        picture.clickSave();

        Assert.assertTrue(picture.isPhotoUploaded());

    }

}