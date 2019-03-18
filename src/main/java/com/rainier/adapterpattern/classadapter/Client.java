package com.rainier.adapterpattern.classadapter;


import com.rainier.adapterpattern.SecurePayment;


import java.math.BigDecimal;
import java.util.ArrayList;

public class Client {
//    private static int i = 1;
//    static {
//        i = 2;
//       System.out.println(i);
//
//    }
    public static void main(String[] args) {

       //new Client().doJob();

//        try {
//            SecurePayment payment = new AliPaymentAdapter();
//            payment.pay("123456789", BigDecimal.valueOf(28900));
//        }
//        catch (Exception ex){
//            ex.printStackTrace();
//        }
    }

//    private void doJob(){
//        doJob();
//    }


    private static int test(){
        int i = 10;

        try
        {
            return i;
        }
        finally {
            i = 11;
        }
    }

}
