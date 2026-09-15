package com.pokerlabs;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.pokerlabs.domain.Card;
import com.pokerlabs.domain.Deck;
import com.pokerlabs.domain.Player;
import com.pokerlabs.domain.Rank;
import com.pokerlabs.domain.Suit;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void createPlayer() {
        new Player(null, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void receiveCardNull() {
        Player player = new Player("Gabriel", 200);
        player.receiveCard(null);
    }

    @Test
    public void newPlayerShouldStartWithNoCards() {
        Player player = new Player("Gabriel", 200);

        assertEquals(0, player.getHand().size());
    }

    @Test
    public void playerShouldReceiveOneCard() {
        Player player = new Player("Gabriel", 200);
        Card card = new Card(Rank.ACE, Suit.SPADES);

        player.receiveCard(card);

        assertEquals(1, player.getHand().size());
        assertEquals(card, player.getHand().get(0));
    }

    @Test
    public void playerShouldReceiveTwoCards() {
        Player player = new Player("Gabriel", 200);

        player.receiveCard(new Card(Rank.ACE, Suit.SPADES));
        player.receiveCard(new Card(Rank.KING, Suit.HEARTS));

        assertEquals(2, player.getHand().size());
    }

    @Test(expected = IllegalStateException.class)
    public void playerShouldNotReceiveMoreThanTwoCards() {
        Player player = new Player("Gabriel", 200);

        player.receiveCard(new Card(Rank.ACE, Suit.SPADES));
        player.receiveCard(new Card(Rank.KING, Suit.HEARTS));
        player.receiveCard(new Card(Rank.QUEEN, Suit.CLUBS));
    }

    @Test
    public void dealingTwoCardsShouldReduceDeckTo50() {
        Deck deck = new Deck();
        Player player = new Player("Gabriel", 200);

        Card firstCard = deck.draw();
        Card secondCard = deck.draw();

        player.receiveCard(firstCard);
        player.receiveCard(secondCard);

        assertEquals(50, deck.size());
        assertEquals(2, player.getHand().size());

        assertEquals(firstCard, player.getHand().get(0));
        assertEquals(secondCard, player.getHand().get(1));
    }

    @Test
    public void dealCards() {
        Deck deck = new Deck();
        deck.shuffle();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Player player = new Player("Jugador " + i, 200);
            players.add(player);
        }

        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                Card card = deck.draw();
                player.receiveCard(card);
                System.out.println(player.getName() + " recibe: " + card.getRank() + " " + card.getSuit());
            }
        }

        for (Player player : players) {
            assertEquals(2, player.getHand().size());
        }

    }
}
