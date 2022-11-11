package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {
   protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

    public  void  bekle (int bekleneceksure){
        try {
            Thread.sleep(bekleneceksure*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  void tumResimCek(String resimIsmi){
        TakesScreenshot tss= (TakesScreenshot) driver;
        File kayitYeri=new File("target//screenShots//"+resimIsmi+".jpeg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciResim,kayitYeri);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
