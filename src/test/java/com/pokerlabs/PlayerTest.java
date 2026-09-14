package com.pokerlabs;

import org.junit.Test;

import com.pokerlabs.domain.Player;

public class PlayerTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void createPlayer(){
        Player player = new Player(null, 0);
    }
}
