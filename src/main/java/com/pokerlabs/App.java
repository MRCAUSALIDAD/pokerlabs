package com.pokerlabs;

import com.pokerlabs.domain.Card;
import com.pokerlabs.domain.Rank;
import com.pokerlabs.domain.Suit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Card card = new Card(Rank.ACE, Suit.SPADES);

        System.out.println("Rank: " + card.getRank() + " Suit: " + card.getSuit());
    }
}
