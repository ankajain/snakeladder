package com.deserve;

import com.deserve.models.Player;
import org.junit.Test;

public class GameTest {

    @Test
    public void play() {
        final Game game = new Game(100);
        game.play(new Player("Akanksha"));
    }
}