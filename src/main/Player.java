package main;

import java.util.Objects;

/**
 * Clase Player
 * Clase desde la cual se representa cada jugador registrado para jugar.
 * @author Marcelo Vásquez
 * @version 0.1, 2022/07/14
 */

public class Player {

    private String player;

    // Constructor de Player.
    public Player(String player) {
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player1 = (Player) o;
        return Objects.equals(getPlayer(), player1.getPlayer());
    }

    @Override
    public String toString() {
        return "player=" + player;
    }
}
