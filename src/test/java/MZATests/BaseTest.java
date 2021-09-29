package MZATests;

import MZAScreens.HomeScreen;
import MZAScreens.LoginScreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver driver;
    protected static LoginScreen loginScreen;
    protected static HomeScreen homeScreen;
    protected static ExtentSparkReporter spark;
    protected static ExtentReports extent;


    @BeforeSuite
    public void ReportSetup(){
        spark   = new ExtentSparkReporter("MZATestAutomationReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

    }
    @BeforeTest
    public void AndroidSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("platformVersion","10");
        caps.setCapability("deviceName","Android Emulator");
        caps.setCapability("app",System.getProperty("user.dir")+"/MyZongApp/myzong.apk");
        driver  = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
       loginScreen = new LoginScreen(driver);
         homeScreen = new HomeScreen(driver);
    }

    @AfterSuite
    public void ReportTearDown(){
        extent.flush();
    }


}
