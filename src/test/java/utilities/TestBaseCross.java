package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {
    protected WebDriver driver;

    @Parameters("Browser")
    @BeforeMethod
    public void setUp(@Optional String valueOfBrowser) {
        driver = CrossDriver.getdriver(valueOfBrowser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown() {
        CrossDriver.closeDriver();
    }
}
