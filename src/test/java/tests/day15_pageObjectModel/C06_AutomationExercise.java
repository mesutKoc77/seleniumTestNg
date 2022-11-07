package tests.day15_pageObjectModel;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationExercisePage;
import utilities.Driver;
import utilities.Reusable;

public class C06_AutomationExercise {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    //9. Click 'Delete Account' button
    //10. Verify that 'ACCOUNT DELETED!' is visible//ver,fy eşittri softassert
    //     aliveli@hotmail.com
    //     aliveli


    AutomationExercisePage automationExercisePage=new AutomationExercisePage();
    SoftAssert softAssert=new SoftAssert();

@Test
public void Test01(){
    Driver.getdriver().get("http://automationexercise.com");


    String expectedUrl="https://automationexercise.com/";
    String actualUrl=Driver.getdriver().getCurrentUrl();
    softAssert.assertEquals(actualUrl,expectedUrl,"homepage'de degislsiniz");

    AutomationExercisePage automationExercisePage=new AutomationExercisePage();
    automationExercisePage.signUpLinki.click();

    softAssert.assertTrue(automationExercisePage.loginAccountElementi.isDisplayed());
    Reusable.bekle(3);

    automationExercisePage.emailKutusu.sendKeys("mesut@hotmail.com");
    automationExercisePage.passwordKutusu.sendKeys("mesut");
    Reusable.bekle(3);

    automationExercisePage.loginButonu.click();
    Reusable.bekle(3);

  boolean yaziGorunuyor=automationExercisePage.yaziGorunuyorMu.isDisplayed();
  softAssert.assertTrue(yaziGorunuyor,"login yazisi gorunmuyor");
  Reusable.bekle(3);
  automationExercisePage.hesapSilindi.click();
  Reusable.bekle(5);
  boolean silindiYazisi=automationExercisePage.gorunuyorSilindi.isDisplayed();
  Reusable.bekle(3);
  softAssert.assertTrue(silindiYazisi,"silindiyazisi gorunmuyor");

    softAssert.assertAll();
    Reusable.bekle(5);
    Driver.closeDriver();

}

}

