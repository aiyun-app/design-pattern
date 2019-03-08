package com.rainier.factorypattern.abstractfactory;

import com.rainier.factorypattern.simple.NikeCoat;
import com.rainier.factorypattern.simple.Coat;

public class NikeModernFactory implements ModernFactory {

    @Override
    public Coat createCoat() {
        return new NikeCoat();
    }

    @Override
    public Shose createShose() {
        return new NikeShose();
    }
}
