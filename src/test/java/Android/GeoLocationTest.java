package Android;

import io.appium.java_client.Location;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GeoLocationTest {

    public AndroidDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        String appiumServerUrl = "http://127.0.0.1:4723";
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "UiAutomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);


    }
    @Test
    public  void test(){

       Location location = driver.getLocation();
       System.out.println("Current Geo Location: " +"Latitude = "+ location.getLatitude() +", "
               +"Longitude = "+ location.getLongitude() +", "+"Altitude = "+ location.getAltitude());
       driver.setLocation(new Location(100, 200, 10.0));
    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}