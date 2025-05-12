package com.lambdatest.tests;

import com.lambdatest.pages.JqueryDownloadProgressBarPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JqueryprogressBarTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    JqueryDownloadProgressBarPage JqueryProgressBarPage = new JqueryDownloadProgressBarPage();

    @Test
    public void testJqueryProgressBarPercentage(){
        JqueryProgressBarPage = homePage.clickJqueryDownloadProgressBar();
        JqueryProgressBarPage.clickStartDownloadButton();
        String actualMessage = JqueryProgressBarPage.getCompletedMessage();
        String expectedMessage = "Complete!";
        softAssert.assertEquals(actualMessage, expectedMessage,
                "\n The Message Is Not Complete Or Correct \n");
        softAssert.assertAll();
    }
}
