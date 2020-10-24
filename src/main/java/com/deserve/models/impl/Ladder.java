package com.deserve.models.impl;

import com.deserve.models.GameObject;

public class Ladder implements GameObject {

    private final int headPosition;
    private final int tailPosition;

    public Ladder(
        final int headPosition,
        final int tailPosition) {
        this.headPosition = headPosition;
        this.tailPosition = tailPosition;
    }

    @Override
    public int behave() {
        return 0;
    }
}
