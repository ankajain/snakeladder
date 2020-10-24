package com.deserve.models;

public class Player {

    private final String name;
    private int position;

    public Player(
        final String name) {
        this.name = name;
        this.position = 1;
    }

    public void setPosition(
        final int position) {
        this.position = position;
    }
}
