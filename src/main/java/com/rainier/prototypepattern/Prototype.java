package com.rainier.prototypepattern;

public interface Prototype {

    Prototype clone();
    Prototype deepClone();
}
