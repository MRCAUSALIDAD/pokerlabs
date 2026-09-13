package com.pokerlabs.domain;

public enum HandCategory {
    SUITED, // suited: Las dos cartas son del mismo palo (A♥ K♥)
    OFFSUIT, // offsuit: Las cartas son de distinto palo (A♥ K♣)
    POCKETPAIR, // pocket pair: Pareja de mano (8♥ 8♣)
    SUITEDCONNECTOR, // suited connector: Consecutivas y del mismo palo (8♥ 7♥)
    OFFSUITCONNECTOR, // offsuit connector: Consecutivas de distinto palo (8♥ 7♣)
    SUITEDONEGAPPER, // suited one-gapper: Mismo palo con un rango de separación (9♥ 7♥)
    SUITEDTWOGAPPER, // suited two-gapper: Mismo palo con dos rangos de separación (T♥ 7♥)
    BROADWAY, // broadway: Cartas de T a A (AK, KQ, QJ, JT...)
    SUITEDACE, // suited ace: As acompañado por carta del mismo palo (A♥ 5♥)
    OFFSUITACE, // offsuit ace: As + otra carta de distinto palo (A♥ 5♣)
    SUITEDKING, // suited king: Rey + carta del mismo palo (K♠ 9♠)
    PREMIUM, // premium: Manos preflop especialmente fuertes (AA, KK, QQ, AK... según definición)
    TRASHORJUNK, // trash / junk: Manos muy débiles (como 72o)
    COMBO, // combo: Una combinación concreta de cartas (A♠K♠ es 1 combo de AKs)
    HANDCLASS, // hand class: Clase abstracta de mano (AKs, AKo, QQ)
    RANGE // range: Conjunto de manos posibles (AA, KK, QQ, AKs...)
}
