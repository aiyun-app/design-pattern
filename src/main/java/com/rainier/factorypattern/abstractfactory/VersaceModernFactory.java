package com.rainier.factorypattern.abstractfactory;

import com.rainier.factorypattern.simple.Coat;
import com.rainier.factorypattern.simple.VersaceCoat;

public class VersaceModernFactory implements ModernFactory {
    @Override
    public Coat createCoat() {
        return new VersaceCoat();
    }

    @Override
    public Shose createShose() {
        return new VersaceShose();
    }
}
