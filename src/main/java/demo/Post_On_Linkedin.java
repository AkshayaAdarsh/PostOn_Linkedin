package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Post_On_Linkedin {
    ChromeDriver driver;

    public Post_On_Linkedin() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        // Open URL https://in.linkedin.com/
        driver.get("https://in.linkedin.com/");
        Thread.sleep(5000);
        // sendKeys("23.akshaya") Using Locator "ID" "session_key"
        WebElement emaid = driver.findElementById("session_key");
        emaid.sendKeys("23.akshaya@gmail.com");
        // sendKeys("**********") Using Locator "ID" "session_password"
        WebElement pwd = driver.findElementById("session_password");
        pwd.sendKeys("******");
        // Click on Sign in Button Using Locator "XPath" (//button[contains(text(),'Sign
        // in')])[1]
        WebElement sig = driver.findElementByXPath("(//button[contains(text(),'Sign in')])[1]");
        sig.click();
        // //Print the count of `Who's viewed your profile` Using Locator XPath
        // (//span[@class='feed-identity-widget-item__stat']/strong)[1]
        WebElement countOfProfile = driver
                .findElementByXPath("(//span[@class='feed-identity-widget-item__stat']/strong)[1]");
        System.out.println("The count of `Who's viewed your profile`  " + countOfProfile.getText());
        // Print the `Impressions of your post` Using Locator XPath
        // (//span[@class='feed-identity-widget-item__stat']/strong)[2]
        WebElement impPost = driver.findElementByXPath("(//span[@class='feed-identity-widget-item__stat']/strong)[2]");
        System.out.println("`Impressions of your post` " + impPost.getText());
        // Click on "Start a Post" Using Locator "XPath" //span[text()='Start a post']
        driver.findElementByXPath("//span[text()='Start a post']").click();

        // click on dropDown Using Locator ClassName
        // "share-unified-settings-entry-button__chevron-icon"

        WebElement dropDown = driver.findElementByClassName("share-unified-settings-entry-button__chevron-icon");
        dropDown.click();
        // click on "connections only" Using Locator "XPath"
        // (//label[@class='sharing-shared-generic-list__radio-label'])[2]
        WebElement cl = driver.findElementByXPath("//button[@id='CONNECTIONS_ONLY']");
        cl.click();
        // click on "Done" Using Locator "XPath" //span[text()='Done']
        WebElement done = driver.findElementByXPath("//span[text()='Done']");
        done.click();
        // sendKeys("Hello") Using Locator "XPath" //div[@role='textbox']
        driver.findElementByXPath("//div[@role='textbox']").sendKeys("Hello");
        // click on "Post" Using Locator "XPath" //span[text()='Post']
        WebElement post = driver.findElementByXPath("//span[text()='Post']");
        post.click();
        // Validate that Post is successfully posted Using Locator "XPath"
        // //span[text()='Post successful.']
        WebElement po = driver.findElementByXPath("//span[text()='Post successful.']");
        System.out.println("Post is successfully displayed" + po.isDisplayed());

    }

}
