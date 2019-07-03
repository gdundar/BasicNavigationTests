package locatorsHomeWork;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Google results title1.Open browser
2.Go tohttps://google.com
3.Search for one of the strings the list searchStrs given below
4.In the results pages, capture the url right below the first results
5.Click on the first result
6.Verify that url is equal to the value from step 4
7.Navigate back
8.Repeat the same steps for all search items in the
listList<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
 */

public class GoogleResults {
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) throws Exception{


        String [] str = {"Java", "JUnit", "REST Assured"};
        for(int i=0; i< str.length; i++) {
            driver.manage().window().maximize();
            driver.get("https://google.com");

            driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(str[i]);
            Thread.sleep(3000);
            driver.findElement(By.className("gNO89b")).click();
            Thread.sleep(3000);
            String expected = driver.findElement(By.xpath("//cite[@class='iUh30']")).getText();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
            Thread.sleep(3000);
            String actual = driver.getCurrentUrl();
            Thread.sleep(3000);

            if(expected.equals(actual))
                System.out.println("Passed");
            else
                System.out.println("Failed");

            System.out.println();
        }

        driver.close();

    }
}
