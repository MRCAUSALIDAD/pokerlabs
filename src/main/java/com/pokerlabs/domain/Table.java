package com.pokerlabs.domain;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final int TIMEBANK = 30;
    private final int maxPlayers;
    private final double minBet;
    private final double maxBet;
    List<Position> enablePositions = new ArrayList<>();
    private List<Player> listPlayers = new ArrayList<>();
    private List<PlayerPosition> listPlayersPosition = new ArrayList<>();
    public Table(int maxPlayers, double minBet, double maxBet) {
        this.maxPlayers = maxPlayers;
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.generatePositions();
    }

    public List<Position> generatePositions() {
        Position[] positions = Position.values();
        for (Position position : positions) {
            this.enablePositions.add(position);
        }
        return this.enablePositions;
    }

    public void registerAtTheDesk(Player player) {
        
        if (this.listPlayers.contains(player)) { // contains utiliza el método equals por dentro
            throw new IllegalStateException("No puedes registrarte varias veces en esta mesa.");
        }else if (this.listPlayers.size() != this.maxPlayers) {
            this.listPlayers.add(player);
            this.positionPlayer(player);
        }  else {
            throw new IllegalStateException(player.getName() + " no puedes registrarte, la mesa está llena.");
        }

    }

     public void positionPlayer(Player p) {
        if(enablePositions.isEmpty()){
            System.out.println("No quedan posiciones disponibles");
        }
        Position position = this.enablePositions.removeFirst();
        this.listPlayersPosition.add(new PlayerPosition(p, position));
        System.out.println("Acabas de entrar a la mesa " + p.getName() + " con un stack de: " + p.getStack() + " estas en la posición: " + position);
    }

    public boolean isPlayerRegistered(Player player) {
        return this.listPlayers.contains(player);
    }

    // 3+ jugadores:
    // PREFLOP: empieza UTG.
    // POSTFLOP: empieza SB (o el primer jugador activo a la izquierda del BTN).
    //
    // HEADS-UP (2 jugadores):
    // PREFLOP: empieza SB, que también es BTN.
    // POSTFLOP: empieza BB.
}
