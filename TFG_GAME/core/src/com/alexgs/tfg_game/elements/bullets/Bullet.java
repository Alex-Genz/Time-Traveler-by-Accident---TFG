package com.alexgs.tfg_game.elements.bullets;

import com.alexgs.tfg_game.elements.Element;
import com.alexgs.tfg_game.elements.world_obj.WorldObjects;
import com.alexgs.tfg_game.scr.game_scr.MainScreen;
import com.alexgs.tfg_game.solids.SolidHigh;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Bullet extends Element {
    MainScreen lvl;

    private float timeBeforeCulling;
    private float timeExisting = 0;

// TODO: EXPERIMENTAL CODE! test and troubleshoot is prioritized and mandatory
    protected int dmg;
    protected int bulletSpeed;

    protected Animation<TextureRegion> projectileTexture;

    public Bullet(float x, float y, Stage s, MainScreen lvl, 
    int dmg, /*int bulletSpeed, */float timeBeforeCulling) {
        super(x, y, s);

        this.lvl = lvl;

        projectileTexture = loadFullAnimation("sprites/other/bullet.png", 1, 1, 0, false);
        this.setPolygon(8);

// TODO: EXPERIMENTAL CODE! test and troubleshoot is prioritized and mandatory
        this.dmg = dmg;
//        this.bulletSpeed = bulletSpeed;
        this.timeBeforeCulling = timeBeforeCulling;

    }

    public void act(float delta) {
        if (this.getEnabled()) {
            this.applyPhysics(delta);

            collide();
            checkIfOutOfBounds();

            if (timeExisting > timeBeforeCulling)
                this.setEnabled(false);

            else
                this.timeExisting+=delta;

        }

    }

// TODO: EXPERIMENTAL CODE! test and troubleshoot is prioritized and mandatory
    public void fire(float startX, float startY, float speedX, float speedY) {
        this.setEnabled(true);

        this.timeExisting = 0;

        this.setPosition(startX, startY);

        this.velocity.x = speedX;
        this.velocity.y = speedY;

    }

// TODO: EXPERIMENTAL CODE! test and troubleshoot is prioritized and mandatory
    private void collide() {
        for (SolidHigh solidHigh :
                this.lvl.hiSolids) {
            if (this.getEnabled() && this.overlaps(solidHigh)) {
                this.setEnabled(false);

            }

        }

        for (WorldObjects wObj :
                this.lvl.worldObjects) {
            if (this.getEnabled() && this.overlaps(wObj)) {
                this.setEnabled(false);

            }

        }

    }

    private void checkIfOutOfBounds() {
        if (this.getX() < -5 || this.getY() < -5 ||
                this.getX() > (lvl.getMapWidthRaw() + 5) ||
                this.getY() > (lvl.getMapHeightRaw() + 5)) {
            this.setEnabled(false);

        }

    }

}
