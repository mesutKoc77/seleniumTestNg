package mainPractice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class practice02_TestCase2 extends TestBase {
    /*
    1. Browser starten
2. Navigieren Sie zur URL „http://automationexercise.com“.
3. Überprüfen Sie, ob die Startseite erfolgreich sichtbar ist
4. Klicken Sie auf die Schaltfläche „Anmelden/Anmelden“.
5. Vergewissern Sie sich, dass „Bei Ihrem Konto anmelden“ angezeigt wird
6. Geben Sie die richtige E-Mail-Adresse und das richtige Passwort ein
7. Klicken Sie auf die Schaltfläche „Anmelden“.
8. Vergewissern Sie sich, dass „Angemeldet als Benutzername“ sichtbar ist
9. Klicken Sie auf die Schaltfläche „Konto löschen“.
10. Vergewissern Sie sich, dass 'KONTO GELÖSCHT!' ist sichtbar
     */

    @Test
    public void practice02_TestCase2(){
        driver.navigate().to("http://automationexercise.com");
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        WebElement nameBox=driver.findElement(By.xpath("//input[@placeholder='Name']"));
        bekle(1);
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        String mail=faker.internet().emailAddress();
        System.out.println("mail: "+mail);
        bekle(1);
        actions.click(nameBox).sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).
                sendKeys(mail).perform();
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        WebElement title=driver.findElement(By.xpath("//input[@id='id_gender1']"));
        actions.click(title).sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys("Mehmet")
                .sendKeys(Keys.TAB).sendKeys("8")
                .sendKeys(Keys.TAB).sendKeys("April")
                .sendKeys(Keys.TAB).sendKeys("1989").perform();
        driver.findElement(By.xpath("//input[@id=\"newsletter\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"optin\"]")).click();
        bekle(1);

      String password=driver.findElement(By.id("password")).getText();
        System.out.println("password : "+password);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State,
        // City, Zipcode, Mobile Number
        WebElement firstName=driver.findElement(By.id("first_name"));
        actions.click(firstName).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().title()).sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).perform();
        WebElement DDM2=driver.findElement(By.id("country"));
        Select select=new Select(DDM2);
        select.selectByValue("United States");
        select.getFirstSelectedOption().click();
        WebElement state=driver.findElement(By.xpath("//input[@name='state']"));

        actions.click(state).sendKeys(faker.country().capital()).sendKeys(Keys.TAB).
                sendKeys(faker.address().city()).sendKeys(faker.phoneNumber().phoneNumber()).perform();
        bekle(2);
        driver.findElement(By.id("zipcode")).sendKeys("222");
        driver.findElement(By.id("mobile_number")).sendKeys("22222222");
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        bekle(1);
        bekle(1);
        driver.navigate().to("http://automationexercise.com");
        SoftAssert softassert=new SoftAssert();
        WebElement homePage=driver.findElement(By.xpath("//a[text()=' Home'] [@style=\"color: orange;\"]"));
        softassert.assertTrue(homePage.isDisplayed(),"das Homepage is nicht richtig Sichtbar");
        softassert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed(),"Angemeldet als Benutzername is nicht sichtbar");
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        softassert.assertAll();

    }
}
