package tests.aysePractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q2 {

    /*
    - Birbirine bagimli testler olusturun.
    - beforeClass olusturup setUp ayarlarini yapin.
    - Birbirine bagimli testler olusturarak ;
        =>ilk once facebook'a gidin
        =>sonra facebook'a bagimli olarak google'a gidin
        =>daha sonra google'a bagimli olarak amazon'a gidin
    - driver'i kapatin.
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test()
    public void facebook(){
        driver.get("https://www.facebook.com");
        wait(1);
    }

    @Test(dependsOnMethods = "facebook")
    public void google()
    {
        driver.get("https://www.google.com");
        wait(1);
    }

    @Test(dependsOnMethods = "google")
    public void amazon()
    {
        driver.get("https://www.amazon.com");
        wait(1);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    public void wait (int sure){
        try {
            Thread.sleep(sure*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
