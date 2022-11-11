package tests.aysePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;
import utilities.TestBaseClass;

import java.util.Collections;
import java.util.List;

public class Q3 extends TestBase {
     /*
- go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
- Task 1 - Find Dropdown on Multi Selection
- Task 2 - Find all Dropdown Elements
- Task 3 - Printout Dropdown Elements' number
- Task 4 - Choose all Dropdown elements and printout Dropdown elements' name on Multi Selection
- Task 5 - Check until choice 5
 */

    @Test
    public void test01(){
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        bekle(1);
        WebElement DD=driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        bekle(1);
        DD.click();
        List<WebElement> dropList=driver.findElements(By.className("ComboTreeItemChlid"));

        for (WebElement each:dropList
             ) {

            System.out.println("textleri : "+each.getText()+" ");
        }
        System.out.println("uzunlugu"+dropList.size());

    }

}
