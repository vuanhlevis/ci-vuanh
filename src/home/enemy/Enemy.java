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
public class Enemy {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    FrameCounter coolDownCounter;
    boolean enemyDissable;
    boolean spellDissable;
    public Enemy () {
        this.position = new Vector2D();
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("enemies/level0/pink/0.png"));
        this.coolDownCounter = new FrameCounter(17);
    }
    public void move(float dx, float dy) {
        position.addUp(dx,dy);
    }

    public void castEnemy (ArrayList<Enemy> enemies) {
        if (!enemyDissable) {
            Random random = new Random();
            float ran = random.nextInt(300) + 5;
            Enemy enemy = new Enemy();
            enemy.position.set(ran,0);
            enemies.add(enemy);
            enemyDissable = true;
        }
    }



    public void coolDown () {
        if (enemyDissable) {
            boolean status = coolDownCounter.run();
            if (status) {
                enemyDissable = false;
                coolDownCounter.reset();
            }
        }
    }

    public void castSpell ( ArrayList<EnemySpell> enemySpells) {
        if (!spellDissable) {
            EnemySpell enemySpell = new EnemySpell();
            enemySpell.position.set(this.position.add(0,10));
            enemySpells.add(enemySpell);
            spellDissable = true;
        }
    }

    public void coolDownSpell () {
        if (spellDissable) {
            boolean status = coolDownCounter.run();
            if (status) {
                spellDissable = false;
                coolDownCounter.reset();
            }
        }
    }

    public void render(Graphics2D g) {
        imageRenderer.render(g,position);
    }
}
