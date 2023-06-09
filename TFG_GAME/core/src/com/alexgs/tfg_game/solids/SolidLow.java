package com.alexgs.tfg_game.solids;

import com.alexgs.tfg_game.elements.Element;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SolidLow extends Element {
//    solid class for player / npc / enemy collision

    public SolidLow(float xPos, float yPos, Stage stage, float width, float height) {
        super(xPos, yPos, stage, width, height);

        float[] vertices = {0, 0, width, 0, width, height, 0, height};
        colision = new Polygon(vertices);
        this.setSize(width, height);

    }

    public SolidLow(float x, float y, Stage s, Polygon poly) {
        super(x, y, s);
        this.colision = poly;

    }

}
