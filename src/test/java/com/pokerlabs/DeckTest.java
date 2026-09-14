package com.pokerlabs;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.pokerlabs.domain.Card;
import com.pokerlabs.domain.Deck;

public class DeckTest {

    @Test(expected = IllegalStateException.class)
    public void emptyDeckShouldThrowExceptionWhenRequestingCard() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.draw();
        }
        deck.draw();
    }

    @Test
    public void deckShouldContain52UniqueCards() {
        Deck deck = new Deck();
        Set<Card> drawnCards = new HashSet<>();

        assertEquals(52, deck.size());

        for (int i = 0; i < 52; i++) {
            Card card = deck.draw();
            drawnCards.add(card);
        }

        assertEquals(52, drawnCards.size());
    }

    @Test
    public void drawingACardReducesTheSizeTo51() {
        Deck deck = new Deck();
        deck.draw();
        assertEquals(51, deck.size());
    }

    @Test
    public void shuffledDeckShouldContain52UniqueCards() {
        Deck deck = new Deck();
        deck.shuffle();
        Set<Card> drawnCards = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            drawnCards.add(deck.draw());
        }

        assertEquals(52, drawnCards.size());
    }
}
