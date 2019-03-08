package com.rainier.factorypattern.simple;

public class WorkShop {

    public static Coat createCoat(String name){
        if("耐克".equalsIgnoreCase(name)){
            return new NikeCoat();
        }
        else if("范思哲".equalsIgnoreCase(name)){
            return new VersaceCoat();
        }
        else {
            return null;
        }
    }


}
