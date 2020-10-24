package com.deserve.models;

import java.util.Objects;

public class Player {

    private final String name;
    private int position;

    public Player(
        final String name) {
        this.name = name;
        this.position = 0;
    }

    @Override
    public boolean equals(
        final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Player player = (Player)o;
        return position == player.position && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(
        final int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
