package com.pokerlabs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.pokerlabs.domain.Card;
import com.pokerlabs.domain.Rank;
import com.pokerlabs.domain.Suit;

public class CardTest {

    @Test
    public void cardsWithSameRankAndSuitShouldBeEqual() {
        // ARRANGE: preparo los objetos necesarios para el test
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.SPADES);

        // ACT: ejecuto el comportamiento que quiero comprobar
        boolean result = card1.equals(card2);

        // ASSERT: compruebo que el resultado es el esperado
        // assertEquals(true, result);
        // Como result es un boolean, normalmente sería más expresivo
        assertTrue(result);
    }

    @Test(expected=IllegalArgumentException.class)
    public void cardWithNullRankShouldThrowIllegalArgumentException(){
        Card card1 = new Card(null, Suit.SPADES);
    }

    @Test(expected=IllegalArgumentException.class)
    public void cardWithNullSuitShouldThrowIllegalArgumentException(){
        Card card1 = new Card(Rank.ACE, null);
    }

    @Test
    public void cardsWithDifferentRanksShouldNotBeEqual(){
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.KING, Suit.SPADES);

        assertFalse(card1.equals(card2));

    }

    @Test
    public void cardsWithDifferentSuitsShouldNotBeEqual(){
        Card card1 = new Card(Rank.ACE, Suit.SPADES);
        Card card2 = new Card(Rank.ACE, Suit.HEARTS);

        assertFalse(card1.equals(card2));

    }
    
}
