package tests.day16_pageObjectModel;

import org.testng.annotations.Test;

public class C02_XmlFiles {
    /*
    com.testNg... ye geldik directory açtık ismi xmlFiles
    daha sonra bunun içine de yeni bir sonu .xml olan bir file
    açtık.
    ve onun ilk satırına testng inin sitesindeki documentation bolumunden
    <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
     yazısını yapıştırdık ve biz testNg den dosya çalıştıracagımız belirttik
     < işareti ile suti mize her zaman oncesinden isim verecegz
     ve goruldugu gibi adım adım gidecegz ve en son da saveAll diyecegz file dan
     her tanımlamada saveAll denmeli
     methodalrda sadeece bunu calıştrı dersen include
     bunun dışındakilerin tammaını calıştır dersen de exclude dersin
     */

    @Test
    public void test01(){
        System.out.println("test 01 calıştı");
    }
    @Test(groups = "smoke")
    public void test02(){
        System.out.println("test 02 calıştı");
    }
    @Test (groups = {"smoke", "regression"})
    public void test03(){
        System.out.println("test 03 calıştı");
    }
    @Test (groups = "regression")
    public void test04(){
        System.out.println("test 04 calıştı");
    }
    @Test
    public void test05(){
        System.out.println("test 05 calıştı");
    }


}
