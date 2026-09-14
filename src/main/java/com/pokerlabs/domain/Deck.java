package com.pokerlabs.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Deck {

    private final List<Card> deck;

    public Deck() {
        this.deck = this.generateDeck();
    }

    private List<Card> generateDeck() {
        List<Card> cards = new ArrayList<>();
        Suit[] suits = Suit.values(); // 4 
        Rank[] ranks = Rank.values(); // 13

        for (Suit suit : suits) {
            for (Rank rank : ranks) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int size(){
        return this.deck.size();
    }

    public Card draw(){
        if(this.deck.isEmpty()){
            throw new IllegalStateException("No hay más cartas en la baraja");
        }
        Card card = this.deck.removeFirst();
        return card;
    }

}
