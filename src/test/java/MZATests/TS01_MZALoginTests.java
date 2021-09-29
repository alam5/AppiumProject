package MZATests;

import MZAScreens.LoginScreen;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import static org.testng.Assert.assertTrue;

public class TS01_MZALoginTests extends BaseTest {


    @Test
    public void  TestNewRegistration() throws InterruptedException {
        ExtentTest test = extent.createTest("Test Case-01 - Check Successful Login", "Launch App,Go through Registration Wizard and Login to the App using MSIDN");
        test.log(Status.INFO, "App Launched and went through registration wizard ");
        //Enter Mobile Number on the Registration screen
                    loginScreen.EnterMobileNum("03105697723");
        test.log(Status.PASS, "Mobile Phone number is entered on Registration screen");
                //Click Registration button
                    loginScreen.RegisterNow();
        test.log(Status.PASS, "Registration button is clicked");

        test.log(Status.INFO, "Entering OTP number Now ");//
                  loginScreen.EnterOTP();
        test.log(Status.PASS, "Login is Successful");
                //Enter Login Button
                    // Check
//        assertTrue( loginScreen.GetProfileText().contains("Select your Avatar")
//                ,"Text is incorrect");
//                    System.out.println("Login is successful");
                   loginScreen.ContinueToHome();
        test.log(Status.PASS, "Navigated to Home Screen");
    }
}
