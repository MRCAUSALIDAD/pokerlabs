package com.pokerlabs;

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
    
}
