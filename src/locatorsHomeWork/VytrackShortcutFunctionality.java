package locatorsHomeWork;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Vytrack shortcut functionality
1.Open browser
.Go to Vytrack login page
3.Login as a sales manager
4. Verify Dashboard page is open
5.Click on Shortcuts icon
6.Click on link See full list
7.Click on link Opportunities
8. Verify Open opportunities page is open
9.Click on Shortcuts icon
10.Click on link Vehicle Service Logs
11.Verify error message text is You do not have permission to perform this action.
12.Verify Open opportunities page is still open
 */
public class VytrackShortcutFunctionality {

        static WebDriver driver= BrowserFactory.getDriver("chrome");

        public static void main(String[] args) throws Exception{

            openTheWebsite("http://qa2.vytrack.com/user/login");
            test1();
            driver.quit();

        }

        public static void openTheWebsite(String Website){
            driver.get(Website);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        }
        public static void test1() throws Exception {

            driver.findElement(By.id("prependedInput")).sendKeys("salesmanager261");
            driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
            Thread.sleep(3000);


            if(driver.getTitle().equals("Dashboard")) System.out.println("Test1 (Verify Dashboard page is open) Pass");
            else System.out.println("Test1 (Verify Dashboard page is open) Fail\nTitle is "+driver.getTitle());


            driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
            Thread.sleep(3000);
            driver.findElement(By.linkText("See full list")).click();
            Thread.sleep(3000);

            driver.findElement(By.linkText("Opportunities")).click();
            Thread.sleep(7000);


            driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
            Thread.sleep(3000);
            driver.findElement(By.linkText("See full list")).click();
            Thread.sleep(3000);


            driver.findElement(By.linkText("Vehicle Services Logs")).click();
            Thread.sleep(3000);
            List<WebElement> lst=driver.findElements(By.xpath("//div[@class='message']"));
            boolean isErrorMessageExists = lst.size()>0;

            if(driver.getTitle().startsWith("Shortcut")&&isErrorMessageExists) System.out.println("Test3 (Verify error message text & Verify Open opportunities page is still open) Pass");
            else System.out.println("Test3 (Verify error message text & Verify Open opportunities page is still open) Fail\n\tTitle is "+driver.getTitle()+" and there is no error message");

            Thread.sleep(3000);

        }

    }

