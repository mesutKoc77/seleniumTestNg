package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver () {
        /*
        singleton pattern konsepti ile driver class ından obje oluşturmayı engellmeke için bu
        constructor ı oluşturduk.
         */
    }
    static WebDriver driver;
    public static WebDriver getdriver(String valueOfBrowser){

        valueOfBrowser= valueOfBrowser==null ? ConfigReader.getProperty("browser") :valueOfBrowser;
        //bunun meniyet subabı olması için koyduk yani driver i yollarlarken valueofbrowser yazılmazsa boş
        //donmesin diye

        if (driver==null)//method ilk çagrıldıgında driver a deger atnamdıgından yeni bir chrome penceresi açılacak
            // ama sonrakiler tabii k i yeni pencere açamayacak.
        {

            switch (valueOfBrowser){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();
            }
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
