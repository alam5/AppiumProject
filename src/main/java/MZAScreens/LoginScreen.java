package MZAScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen {

    private AppiumDriver driver;

    public LoginScreen(AppiumDriver driver){
        this.driver = driver;
    }


    private By wizardcontinue  =By.id("com.zong.customercare.dev:id/btnContinue");
    private By MISDNtextbox = By.id("com.zong.customercare.dev:id/etMobileNumber");
    private By registerbutton = By.id("com.zong.customercare.dev:id/btnRegister");

    private By OPT1 = By.id("com.zong.customercare.dev:id/etP1");
    private By OPT2 = By.id("com.zong.customercare.dev:id/etP2");
    private By OPT3 = By.id("com.zong.customercare.dev:id/etP3");
    private By OPT4 = By.id("com.zong.customercare.dev:id/etP4");
    private By OPT5 = By.id("com.zong.customercare.dev:id/etP5");
    private By OPT6 = By.id("com.zong.customercare.dev:id/etP6");

    private By loginbutton = By.id("com.zong.customercare.dev:id/btnLogin");
    private By profiletext = By.id("com.zong.customercare.dev:id/lblSelectAvatar");
    private By ContinueBtn = By.id("com.zong.customercare.dev:id/btnContinue");



    public void EnterMobileNum(String number){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated( wizardcontinue));
        driver.findElement(wizardcontinue).click();
        wait.until(ExpectedConditions.presenceOfElementLocated( MISDNtextbox));
        driver.findElement(MISDNtextbox).sendKeys(number);

    }
    public void RegisterNow (){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated( registerbutton));
        driver.findElement(registerbutton).click();

    }

    public void EnterOTP (){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated( OPT1));
        driver.findElement(OPT1).sendKeys("1");
        driver.findElement(OPT2).sendKeys("1");
        driver.findElement(OPT3).sendKeys("1");
        driver.findElement(OPT4).sendKeys("1");
        driver.findElement(OPT5).sendKeys("1");
        driver.findElement(OPT6).sendKeys("1");

    }

    public void TapLoginButton (){
        driver.findElement(loginbutton).click();
    }

    public String GetProfileText() {
        return driver.findElement(profiletext).getText();
    }

    public HomeScreen ContinueToHome (){
        WebDriverWait wait = new WebDriverWait(driver,35);
        wait.until(ExpectedConditions.presenceOfElementLocated( ContinueBtn));
        driver.findElement(ContinueBtn).click();
        return new HomeScreen(driver);
    }


}
