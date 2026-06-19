package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.ProfilePicturePage;

import java.nio.file.Paths;

public class ProfilePictureUploadTest extends BaseClass {

    @Test
    public void uploadProfilePictureTest() throws InterruptedException {

        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");

        Assert.assertTrue(login.isLoginSuccessful());

        ProfilePicturePage picture = new ProfilePicturePage(driver);

        picture.openMyInfo();

        picture.openPhotoPage();

        String imagePath = Paths.get(
                        "src",
                        "test",
                        "resources",
                        "images",
                        "PROFILE.jpg")
                .toAbsolutePath()
                .toString();

        picture.uploadPhoto(imagePath);

        picture.clickSave();

        Assert.assertTrue(picture.isPhotoUploaded());

    }

}