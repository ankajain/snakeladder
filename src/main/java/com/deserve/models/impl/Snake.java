package com.deserve.models.impl;

import com.deserve.models.GameObject;

public class Snake extends GameObject {

    public Snake(
        final int headPosition,
        final int tailPosition) {
        super(headPosition, tailPosition);
    }

    @Override
    public int checkPosition(
        final int position) {
        if (position == headPosition)
            return tailPosition;
        else
            return position;
    }
}
