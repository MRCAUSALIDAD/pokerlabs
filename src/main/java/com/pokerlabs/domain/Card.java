package com.pokerlabs.domain;

/* cantidad de cartas  
    4 cartas del mismo numero con diferentes palos * 13 = 52 cartas.
    Antes de recibir cartas ((52 * 51) / 2): 1.326 combos posibles de 2 cartas.
    Después de ver la primera: 51 combos posibles que contienen esa carta.
    Después de recibir la segunda: tienes exactamente 1 combo físico concreto.
 */
public final class Card {

    private final Rank rank;
    private final Suit suit;
   
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
       
    }

    // getters para poder leer fuera de la clase Card
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

}
