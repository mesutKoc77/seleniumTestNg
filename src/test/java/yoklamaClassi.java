import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class yoklamaClassi extends TestBase {

    @Test
    public void test01() throws InterruptedException {

                WebDriverManager.chromedriver().setup();
                WebDriver driver=new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.get("https://docs.google.com/forms/d/e/1FAIpQLSd5_I3e-wir0s68TFyY3Cj3Th4vjusJ4xv1aUET0Y4i-sY9cQ/viewform");
                driver.findElement(By.xpath("(//input[@jsname=\"YPqjbf\"])[1]")).sendKeys("Mesut KOÇ");
                driver.findElement(By.xpath("(//input[@jsname=\"YPqjbf\"])[2]")).sendKeys("mkoc1367@gmail.com");
                driver.findElement(By.xpath("(//div[@class=\"AB7Lab Id5V1\"])[1]")).click();
                driver.findElement(By.xpath("(//span[@class=\"NPEfkd RveJvd snByac\"])[2]")).click();
                String wishToSee="Yanıtınız kaydedildi.";
                Assert.assertTrue(driver.getPageSource().contains(wishToSee));
                Thread.sleep(2000);
                driver.close();

    }

}
