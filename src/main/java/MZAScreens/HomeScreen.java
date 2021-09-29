package MZAScreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class HomeScreen {
    private AppiumDriver driver;


    private By MobileNum = By.id("com.zong.customercare.dev:id/tvMobileNumber");
    private By ViewMoreBtn = By.id("com.zong.customercare.dev:id/viewMoreBtn");
    private By ViewAllOffersBtn = By.id("com.zong.customercare.dev:id/tvViewAllOffers");
    private By HomeTrayItems = By.id("com.zong.customercare.dev:id/rvHomeTray");
    private By TrayItemName = By.id("com.zong.customercare.dev:id/tvName");
    private By wholetrayitem = By.id("com.zong.customercare.dev:id/root");
    private By loader = By.id("com.zong.customercare.dev:id/loader_loader");
    private By Hotoffers = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
    private By HotofferName = By.id("com.zong.customercare.dev:id/tvBundleTitle");
    private By HotofferDesc = By.id("com.zong.customercare.dev:id/tvTotal");
    private By HotofferPrice = By.id("com.zong.customercare.dev:id/tvPrice");
    private By HotofferActivateBtn = By.id(" com.zong.customercare.dev:id/sw_activate");
    private By HotofferTitle = By.id("com.zong.customercare.dev:id/tvHotTitle");





    public HomeScreen(AppiumDriver driver ){
        this.driver = driver;

    }

    public String GetMSISDNFromHome(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated( MobileNum));
        String msisdn =  driver.findElement(MobileNum).getText();
        System.out.println(msisdn);
        return msisdn;
    }

    public void ViewMoreTrayItems(){
        try {
            WebDriverWait wait = new WebDriverWait(driver,60);
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loader)));
            wait.until(ExpectedConditions.presenceOfElementLocated((wholetrayitem)));

            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));
        } catch (InvalidSelectorException e) {
            // ignore
        }
        driver.findElement(ViewMoreBtn).click();
    }

    public void CheckHomeTrayItems(){
        List<MobileElement> TrayelementTexts = (List<MobileElement>) driver.findElements(TrayItemName);
        HashMap<Integer,String> TrayItemNames = new HashMap<Integer,String>();
        int TrayitemNum = 1;
        System.out.println("Number of Home Tray items: "+TrayelementTexts.size());
        for (MobileElement me :TrayelementTexts)
        {
            String traytext =  me.getText();
            TrayItemNames.put(TrayitemNum,traytext);
            TrayitemNum +=1;
        }
        System.out.println(TrayItemNames);

    }


    public void ChecknSubscribeHotOffers()  {

        try {
            WebDriverWait wait = new WebDriverWait(driver,35);
            driver.findElement(MobileBy.AndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));
            wait.until(ExpectedConditions.presenceOfElementLocated( HotofferName));
        } catch (InvalidSelectorException e) {
            // ignore
            }
        List<MobileElement>  HotoffersList = (List<MobileElement>) driver.findElements(Hotoffers);
        HashMap<String,String> HotOffersDetails = new HashMap<String,String>();
        int hotofferListItems = HotoffersList.size();
        int hotoffersize = hotofferListItems-1;
        System.out.println("Number Hot offers are : "+hotoffersize);
     //   int j = 1;
        //Find element inside Viewgroup
        for (MobileElement HFgroup :HotoffersList.subList(1,6))
        {    MobileElement HFName = HFgroup.findElement(HotofferName);
            //Get text of each element
            String HFN = HFName.getText();
            System.out.println(HFN);
            //HotOffersDetails.put("HotOffer Name "+j,HFN);
             MobileElement HFDesc = HFgroup.findElement(HotofferDesc);
            String HFD = HFDesc.getText();
            System.out.println(HFD);
           // HotOffersDetails.put("HotOffer Description "+j,HFD);
             MobileElement HFPrice =HFgroup.findElement(HotofferPrice);
            String HFP = HFPrice.getText();
            System.out.println(HFP);
          //  HotOffersDetails.put("HotOffer Price "+j,HFP);
        }
     //  System.out.println(HotOffersDetails);

    }

//    public void PUllDownToRefresh(){
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.presenceOfElementLocated( ViewAllOffersBtn));
//        driver.findElement(ViewAllOffersBtn).click();
//    }
//    public void ClickViewAllOffersBtn(){
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.presenceOfElementLocated( ViewAllOffersBtn));
//        driver.findElement(ViewAllOffersBtn).click();
//    }




}
