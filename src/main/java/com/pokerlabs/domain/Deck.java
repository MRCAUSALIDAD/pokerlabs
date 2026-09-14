package com.pokerlabs.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public final class Deck {

    //List y Set son interfaces: definen qué operaciones y propiedades tiene ese tipo de colección.
    //ArrayList y HashSet son clases concretas que implementan esas interfaces.
    Set<Card> deck;

    public Deck() {
        this.deck = this.generateDeck();
    }

    private Set<Card> generateDeck() {
        Set<Card> cards = new HashSet<>();
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

    public Card getRandomCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("No hay más cartas en la baraja");
        }
        int randomIndex = new Random().nextInt(deck.size());

        Iterator<Card> iterator = deck.iterator();
        int i = 0;

        while (iterator.hasNext()) { // hasNext pregunta en cada iteración: ¿Queda algún elemento por recorrer?
            Card card = iterator.next(); // Esto obtiene el siguiente elemento y hace avanzar el iterator.

            if (i == randomIndex) {
                // Así estás modificando la colección a través del mismo mecanismo que la está recorriendo, que es la forma segura de hacerlo durante esa iteración.
                iterator.remove(); // Elimina de la colección el elemento que acabas de devolverme mediante next().
                return card; // devuelves la carta que acabas de retirar.
            }

            i++;
        }

        throw new IllegalStateException("No se pudo seleccionar una carta");
    }

    public int size(){
        return deck.size();
    }
}
