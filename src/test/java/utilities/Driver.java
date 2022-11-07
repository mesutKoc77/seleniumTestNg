package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tests.day15_pageObjectModel.C04_PagesKullanimi;

import java.time.Duration;

public class Driver {
    static WebDriver driver;


    public static WebDriver getdriver(){
        WebDriverManager.chromedriver().setup();

        if (driver==null){//method ilk agrıldıgında driver a deger atnamdıgından yeni bir chrome penceresi açılacak ama
            //sonrakiler tabii ki yeni pencere açamayacak.
            driver =new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        return driver;
    }

 public static void closeDriver(){
       if (driver!=null){

           driver.close();
           driver=null;
       }

 }

}
