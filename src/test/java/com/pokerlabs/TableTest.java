package com.pokerlabs;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.pokerlabs.domain.Player;
import com.pokerlabs.domain.Table;

public class TableTest {
    //Este test pasa si durante su ejecución aparece un IllegalStateException.
    @Test(expected = IllegalStateException.class)
    public void fullTableShouldRejectNewPlayer() {
        Table table = new Table(2, 100, 200);
        Player player1 = new Player("Player1", 200);
        Player player2 = new Player("Player2", 200);
        Player player3 = new Player("Player3", 200);

        table.registerAtTheDesk(player1);
        table.registerAtTheDesk(player2);
        table.registerAtTheDesk(player3);
    }

    @Test
    public void successfulPlayerRegistration(){
        Table table = new Table(2, 100, 200);
        Player player1 = new Player("Player1", 200);
        table.registerAtTheDesk(player1);

        boolean result = table.isPlayerRegistered(player1);
        assertTrue(result);
    }

    @Test(expected= IllegalStateException.class)
    public void samePlayerShouldNotBeRegisteredTwice(){
        Table table = new Table(2, 100, 200);
        Player player1 = new Player("Player1", 200);
        table.registerAtTheDesk(player1);
        table.registerAtTheDesk(player1);
    }
}
