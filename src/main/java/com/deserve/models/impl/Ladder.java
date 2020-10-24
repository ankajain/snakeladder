package com.deserve.models.impl;

import com.deserve.models.GameObject;

public class Ladder extends GameObject {

    public Ladder(
        final int headPosition,
        final int tailPosition) {
        super(headPosition, tailPosition);
    }

    @Override
    public int checkPosition(
        final int position) {
        if (position == tailPosition)
            return headPosition;
        else
            return position;
    }
}
