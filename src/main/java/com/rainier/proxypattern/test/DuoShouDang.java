package com.rainier.proxypattern.test;

import com.rainier.proxypattern.*;
import com.rainier.proxypattern.dynamicproxy.GalaxyMall;
import com.rainier.proxypattern.dynamicproxy.UniverseMall;
import com.rainier.proxypattern.staticproxy.Tmall;

public class DuoShouDang {

    public static void main(String[] args) {
        testStatic();
        testJDK();
        testCglib();
    }

    private static void testStatic(){
        Tmall tmall = new Tmall(new Versace(), new LV());
        tmall.SaleCoat("XL");
        tmall.SaleBag("Red");
    }

    private static void testJDK(){

        GalaxyMall galaxyMall = new GalaxyMall();

        CoatSeller coatSeller = (CoatSeller) galaxyMall.getProxy(new Versace());
        coatSeller.SaleCoat("XL");

        BagSeller bagSeller = (BagSeller)galaxyMall.getProxy(new LV());
        bagSeller.SaleBag("Red");

//        System.out.println(coatSeller.getClass());
//        try {
//            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{CoatSeller.class});
//            FileOutputStream os = new FileOutputStream("/test/$Proxy0.class");
//            os.write(bytes);
//            os.close();
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//        }
    }

    private static void testCglib(){
        UniverseMall universeMall = new UniverseMall();
        CoatSeller coatSeller = (CoatSeller) universeMall.getProxy(Versace.class);
        coatSeller.SaleCoat("XL");
    }
}
