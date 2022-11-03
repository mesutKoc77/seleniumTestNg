package tests.day14_dependsOnMethods_softAssert;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {
    /*
    iki test methodu dependsOn method ile birbirine baglandıysa sadece baglanan methodu çalıştırmak istersek
    dependsOn method ozelligi tanımlı oldugundan once baglı olunan methodu çalıştırır.
    o test passt olursa baglı olan testi de çalıştırır.

    Ancak baglı olan testler ikiden fazla ise ikinci testten sonraki test methodlarını çalıştırmak istersek
    no tests were found hatası verir vve hiçbir testi çalıştırmaz.
     */

    @Test
    public void test01(){
        System.out.println("1. test calıstı");
    }


    @Test (dependsOnMethods ="test01" )
    public void test02(){
        System.out.println("2. test calıstı");
    }



    @Test(dependsOnMethods = "test02")
    public void test03(){
        System.out.println("3. test calıstı");
    }



}
