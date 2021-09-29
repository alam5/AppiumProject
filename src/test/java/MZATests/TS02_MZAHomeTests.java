package MZATests;

import MZAScreens.HomeScreen;
import MZAScreens.LoginScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class TS02_MZAHomeTests extends BaseTest {

    ExtentTest test;
    @Test(priority = 1)
    public void VerifyMSISDNHomeScreen() throws InterruptedException {
        test = extent.createTest("Test Case-02 - Verify MSISDN on MZA Home Screen", "This script will check the phone number on home screen should be matched with entered on Login Screen");
        assertTrue( homeScreen.GetMSISDNFromHome().contains("0310 5697723"), "Text is incorrect");
        test.log(Status.PASS, "Home screen number is matched with entered number on Login screen ");

    }
    @Test(priority = 2)
    public void ViewMoreHomeTrayItems() throws InterruptedException {
        test = extent.createTest("Test Case-03 Verify View More button and Click it", "Click on View More Button On Home Tray Card");
        homeScreen.ViewMoreTrayItems();
        test.log(Status.INFO, "View more button is clicked");
    }
    @Test(priority = 3)
    public void CheckHomeTrayItems() throws InterruptedException {
        test = extent.createTest("Test Case-04 Verify that Home Tray Element should exist as expected on Home Screen", "Count and Verify Home Tray Items names");
        homeScreen.CheckHomeTrayItems();
        test.log(Status.PASS, "Home Tray items are checked and verified");
    }

//    public void ClickViewAllOffers() throws InterruptedException {
//
//        homeScreen.ClickViewAllOffersBtn();
//    }
    @Test(priority = 4)
    public void SubscribeHotOffers() throws InterruptedException {
        test = extent.createTest("Test Case-05 Verify that Hot Offers exists on Home Screen", "Count and Verify Hot Offers names and Subscribed one");
       homeScreen.ChecknSubscribeHotOffers();
        test.log(Status.PASS, "Hot Offers Details are as expected and subscribing successfully");
    }



//    @AfterTest
//    public void teardown(){
//        if(null != driver){
//            driver.quit();
//        }
//
//    }


}
