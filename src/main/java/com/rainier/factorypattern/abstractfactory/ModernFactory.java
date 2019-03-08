package com.rainier.factorypattern.abstractfactory;

import com.rainier.factorypattern.simple.Coat;

public interface ModernFactory {
    Coat createCoat();
    Shose createShose();
}
