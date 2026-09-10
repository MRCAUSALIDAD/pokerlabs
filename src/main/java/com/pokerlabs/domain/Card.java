package com.pokerlabs.domain;

public final class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // getters para poder leer fuera de la clase Card
    public Rank getRank () {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
    
}
