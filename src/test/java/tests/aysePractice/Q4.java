package tests.aysePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q4 extends TestBase {
    /*
     * Navigate to https://www.saucedemo.com/
     * Enter the username as standard_user
     * Enter the password as secret_sauce
     * Click on login button
     *    Test1 : Choose price low to high
     *    Test2 : Verify item prices are sorted from low to high with soft Assert
     */
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void test01() {
        driver.get("https://www.saucedemo.com/");
        Actions action = new Actions(driver);
        bekle(1);
        WebElement mail = driver.findElement(By.id("user-name"));
        bekle(1);
        action.click(mail).sendKeys("standard_user").sendKeys(Keys.TAB).sendKeys("secret_sauce")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        bekle(1);
        Select select=new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        bekle(2);
        select.selectByVisibleText("Price (low to high)");
        bekle(2);

        String actualText=driver.findElement(By.xpath("//span[text()='Price (low to high)']")).getText();
        String expectedText="PRICE (LOW TO HIGH)";

        softAssert.assertEquals(actualText,expectedText,"price low to high yazisi istedigimiz gibi degil");
        softAssert.assertAll();


    }
    @Test ()
    public void test02(){

        driver.get("https://www.saucedemo.com/");
        Actions action = new Actions(driver);
        bekle(1);
        WebElement mail = driver.findElement(By.id("user-name"));
        bekle(1);
        action.click(mail).sendKeys("standard_user").sendKeys(Keys.TAB).sendKeys("secret_sauce")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        bekle(1);
        Select select=new Select(driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]")));
        bekle(2);
        select.selectByVisibleText("Price (low to high)");
        bekle(2);


        List<WebElement> tumFiyatlar=driver.findElements(By.className("inventory_item_price"));
        ArrayList<Integer> actualisayiYaptik=new ArrayList<>();
        for (WebElement each:tumFiyatlar
             ) {
            String yeniFiyat=each.getText().replaceAll("\\D","");
            int sayiYaptik=Integer.parseInt(yeniFiyat);
            actualisayiYaptik.add(sayiYaptik);
        }
        System.out.println("actual : "+actualisayiYaptik);

        ArrayList<Integer> karsilastirma=new ArrayList<>(actualisayiYaptik);
        System.out.println("ilki karsilarstima : "+karsilastirma);
        Collections.sort(karsilastirma);
        System.out.println("ikinci karsilarstima : "+karsilastirma);

        softAssert.assertEquals(actualisayiYaptik,karsilastirma,"esit degiller");

        softAssert.assertAll();

    }
}
