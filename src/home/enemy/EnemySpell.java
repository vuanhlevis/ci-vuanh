package home.enemy;

import home.Utils;
import home.base.FrameCounter;
import home.base.ImageRenderer;
import home.base.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by VALV on 7/18/2017.
 */
public class EnemySpell {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    boolean spellDissable;
    FrameCounter coolDownCounter;

    public EnemySpell () {
        this.position = new Vector2D();
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("enemies/bullets/cyan.png"));
        this.coolDownCounter = new FrameCounter(20);
    }
//    public void castSpell ( ArrayList<EnemySpell> enemySpells) {
//        if (!spellDissable) {
//            EnemySpell enemySpell = new EnemySpell();
//            enemySpell.position.set();
//            enemySpells.add(enemySpell);
//            spellDissable = true;
//        }
//    }
    public void coolDownSpell () {
        if (spellDissable) {
            boolean status = coolDownCounter.run();
            if (status) {
                spellDissable = false;
                coolDownCounter.reset();
            }
        }
    }

    public void move() {
        Random random = new Random();
        float tmp = (float) (random.nextFloat() * 1 + 0.5);
        this.position.addUp(0,5);
    }

    public void render (Graphics2D g) {
        imageRenderer.render(g,position);
    }
}
