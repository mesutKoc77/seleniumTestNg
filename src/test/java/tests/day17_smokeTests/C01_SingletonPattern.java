package tests.day17_smokeTests;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {
    /*
    singleton pattern bir classtan bir obje oluşturulmasını engellyen veya sınırlandıran bir
    konseptir.
     */
    @Test
    public void test01(){
          //amazon anasyafaya gidin
         //Driver.getdriver().get(ConfigReader.getProperty("amazonUrl"));

       /*
       tum class lardan yapabildigimiz gibi driver class ıdnan da obje oluşturabilir ve oradaki
        class uyelerini kullanabiliriz. Bu durumda driver class ında yaptıgımız tercihler by pass
       edilmiş olur.
       Bu tur kullanımın önune gecebilmek için java dan singletonPattern konsepti uygulanır.

       Driver class ından obje oluşturulmasını engellemek için
       Driver class ından obje oluşturup kullanabilmek için driver constructor ına ihtyiac vardır
       eger bu constructor ı erişillemez yaparsak kimse constuct ora erişemez ve kimse
       driver class ından obje oluşturamaz.

       Bunun için gorunur gorunur parmaetresiz constructor oluşturup bunun private yaparız.
       buna singleton pattern denir.
        */
    }

}
