package com.pokerlabs.domain;

import java.util.Objects;

/* cantidad de cartas  
    4 cartas del mismo numero con diferentes palos * 13 = 52 cartas.
    Antes de recibir cartas ((52 * 51) / 2): 1.326 combos posibles de 2 cartas.
    Después de ver la primera: 51 combos posibles que contienen esa carta.
    Después de recibir la segunda: tienes exactamente 1 combo físico concreto.
 */
public final class Card {

    private final Rank rank;
    private final Suit suit;
   
    public Card(Rank rank, Suit suit) {
        if(rank == null || suit == null){
            throw new IllegalArgumentException("El rank o suit no puede ser null");
        }
        this.rank = rank;
        this.suit = suit;
       
    }

    // getters para poder leer fuera de la clase Card
    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override 
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Card)){
            return false;
        }

        Card otherCard = (Card) obj;

        return (this.rank == otherCard.rank && this.suit == otherCard.suit);
    }

    @Override 
    public int hashCode(){
        //Objects.hash(rank, suit) construye un número entero (int) a partir de esos objetos, de forma que puedas usar ese número como una especie de "huella" para búsquedas rápidas
        return Objects.hash(rank, suit);
    }

}
