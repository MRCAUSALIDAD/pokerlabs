package com.pokerlabs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Deck {
    List<Card> deck;
    public Deck(){
        this.deck = this.generateDeck();
    }

    public List<Card> generateDeck(){
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

    public Card getRandomCard(){
        Random random = new Random();
        Card card = this.deck.get(random.nextInt(this.deck.size()));
        this.deck.remove(card);
        return card;
    }
}
