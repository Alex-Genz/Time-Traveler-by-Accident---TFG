package com.alexgs.tfg_game.elements.bullets;

import com.alexgs.tfg_game.elements.characters.hostiles.Hostiles;
import com.alexgs.tfg_game.elements.characters.neutrals.Neutrals;
import com.alexgs.tfg_game.managers.SoundManager;
import com.alexgs.tfg_game.scr.game_scr.MainScreen;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BulletFriendly extends Bullet {

    public BulletFriendly(float x, float y, Stage s, MainScreen lvl, 
    int dmg, float timeBeforeCulling) {
        super(x, y, s, lvl, dmg, timeBeforeCulling);

    }

    public void act(float delta) {
        super.act(delta);

        collide();

    }

    private void collide() {
        for (Neutrals neutral :
                lvl.neutralNPCs) {
            if (this.getEnabled() && neutral.getEnabled() &&
                    this.overlaps(neutral.getHitbox())) {
                this.setEnabled(false);
//                System.out.println("ouch!");
                SoundManager.playSound("audio/sfx/csgo_hostage_pain_sfx.mp3", 0.5f);

            }

        }

        for (Hostiles hostile :
                lvl.hostiles) {
            if (this.getEnabled() && hostile.getEnabled() &&
                    this.overlaps(hostile.getHitbox())) {
                this.setEnabled(false);
//                System.out.println("die!");
                hostile.hit(super.dmg);

            }

        }

        if (lvl.isBossMap())
            if (this.getEnabled() && lvl.finalBoss.getEnabled() && this.overlaps(lvl.finalBoss.getHitbox())) {
                this.setEnabled(false);
                lvl.finalBoss.hit(dmg);

            }

    }

}
