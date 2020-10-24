package com.deserve.models;

public abstract class GameObject {

    protected final int headPosition;
    protected final int tailPosition;

    public GameObject(
        final int headPosition,
        final int tailPosition) {
        this.headPosition = headPosition;
        this.tailPosition = tailPosition;
    }

    public int getHeadPosition() {
        return headPosition;
    }

    public int getTailPosition() {
        return tailPosition;
    }

    public abstract int checkPosition(
        int position);

}
