package com.vh.View;

import com.badlogic.gdx.math.Rectangle;

import lombok.Getter;

public class CellView {

    @Getter Rectangle rectangle;

    public CellView(int x, int y) {
        rectangle = new Rectangle(x, y, 10, 10);
    }

    //the cell will be paired with the model.
}
