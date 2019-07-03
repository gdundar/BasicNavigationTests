package warmUp;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Test1 {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test1() throws Exception {

        driver.navigate().to("https://amazon.com");
        Thread.sleep(2000);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Goksel" + Keys.ENTER);

        String title = driver.getTitle();

        if (title.contains("Goksel")){
            System.out.println("Passed" + "Goksel");
        } else {
            System.out.println("Failed");
        }


        //driver.quit();
    }
}
/*
TEST 1
go to amazon
enter any search term
click on search button
verify title contains search term
 */