package com.pokerlabs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/*
El jugador antes de recibir sus cartas debe de cumplir varios requisitos previos:
- Suficientes jugadores en esa mesa (2+ jugadores) (esto se encarga la clase de Table)
- Recibe la posición en la que se encuentra actualmente (SB, BB, UTG, UTG+, HJ, CO, BTN) (esta información se la transmite Table a Player)
- Player debe tener un stack válido para participar.
 */
public class Player {

    private static final AtomicLong CONTADOR = new AtomicLong(0);
    private final long id;

    private String name;
    private final int stack;

    static final int maxCards = 2;

    private final List<Card> hand = new ArrayList<>();

    public Player(String name, int stack) {
        if (name == null || stack <= 0) {
            throw new IllegalArgumentException("El nombre o el stack no puede ir vacío");
        }

        this.id = CONTADOR.incrementAndGet();
        this.name = name;
        this.stack = stack;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStack() {
        return stack;
    }

    public static int getMaxCards() {
        return maxCards;
    }

    public void receiveCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("No existe ninguna carta");
        }
        if (hand.size() >= maxCards) {
            throw new IllegalStateException("No puede tener más de 2 cartas");
        }
        hand.add(card);
    }

    public List<Card> getHand() {
        return List.copyOf(hand);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Player)) {
            return false;
        }
        Player otherPlayer = (Player) obj;

        return this.id == otherPlayer.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

}
