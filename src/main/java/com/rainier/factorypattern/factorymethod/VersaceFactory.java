package com.rainier.factorypattern.factorymethod;

import com.rainier.factorypattern.simple.Coat;
import com.rainier.factorypattern.simple.VersaceCoat;

public class VersaceFactory implements Factory {
    @Override
    public Coat createCoat() {
        return new VersaceCoat();
    }
}
