package testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class Node2 {   
    WebDriver driver;
    String nodeUrl;
  @Test
  public void f() {
        try {
            //configuration
            nodeUrl= "http://172.16.56.245:5555/wd/hub";
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
           
            //test scripts
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
            driver.get("https://www.google.com/");
        } 
        catch (MalformedURLException e) {       
            e.printStackTrace();           
        }
  }
}