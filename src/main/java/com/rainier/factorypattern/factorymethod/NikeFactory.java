package com.rainier.factorypattern.factorymethod;

import com.rainier.factorypattern.simple.NikeCoat;
import com.rainier.factorypattern.simple.Coat;

public class NikeFactory implements Factory {
    @Override
    public Coat createCoat() {
        return new NikeCoat();
    }
}
