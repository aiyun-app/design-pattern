package com.rainier.proxypattern.staticproxy;

import com.rainier.proxypattern.BagSeller;
import com.rainier.proxypattern.CoatSeller;

public class Tmall implements CoatSeller, BagSeller {

    private CoatSeller coatSeller;

    private BagSeller bagSeller;

    public Tmall(CoatSeller coatSeller, BagSeller bagSeller){
        this.coatSeller = coatSeller;
        this.bagSeller = bagSeller;
    }


    public void SaleCoat(String size) {
        System.out.println("下单之前，店小二详细讲解，不需要英语沟通");
        coatSeller.SaleCoat(size);
        System.out.println("快递到家，不满意退货");
    }

    public void SaleBag(String color) {
        System.out.println("下单之前，店小二详细讲解，不需要英语沟通");
        bagSeller.SaleBag(color);
        System.out.println("快递到家，不满意退货");
    }
}
