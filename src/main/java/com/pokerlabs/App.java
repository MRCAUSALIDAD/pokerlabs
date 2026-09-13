package com.pokerlabs;

import com.pokerlabs.domain.Player;
import com.pokerlabs.domain.Table;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
        Table table = new Table(6, 0.1, 0.2);
        Player player1 = new Player("Gabriel", 200);
        Player player2 = new Player("Sonia", 200);
        Player player3 = new Player("Angy", 200);
        Player player4 = new Player("Rony", 200);
        Player player5 = new Player("Ari", 200);
        Player player6 = new Player("Anouk", 200);
        Player player7 = new Player("Gala", 200);
        Player player8 = new Player("Adry", 200);
        Player player9 = new Player("Tony", 200);
        Player player10 = new Player("ANTONIO", 200);

        table.registerAtTheDesk(player1);
        table.registerAtTheDesk(player2);
        table.registerAtTheDesk(player3);
        table.registerAtTheDesk(player4);
        table.registerAtTheDesk(player5);
        table.registerAtTheDesk(player6);
        table.registerAtTheDesk(player7);
        table.registerAtTheDesk(player8);
        table.registerAtTheDesk(player9);
        table.registerAtTheDesk(player10);

    }
}
