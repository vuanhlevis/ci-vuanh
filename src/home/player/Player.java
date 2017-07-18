package home.player;

import home.Utils;
import home.base.Contraints;
import home.base.FrameCounter;
import home.base.ImageRenderer;
import home.base.Vector2D;
import home.enemy.Enemy;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by VALV on 7/18/2017.
 */
public class Player {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    Contraints contraints;

    FrameCounter coolDownCounter;
    boolean spellDisabled;


    public Player(){
        this.position = new Vector2D();
        this.coolDownCounter = new FrameCounter(17);  // 17 frame  = 300 millisecond
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("players/straight/0.png"));
    }

    public void move(float dx, float dy){
        this.position.addUp(dx, dy);
        contraints.make(this.position);
    }

    public void CastSpell(ArrayList<PlayerSpell> playerSpells){
        if (!spellDisabled){
            PlayerSpell playerSpell = new PlayerSpell();
            playerSpell.position.set(this.position.add(0,-20));
            playerSpells.add(playerSpell);

            spellDisabled = true;
        }
    }

    public void castEnemy(ArrayList<Enemy> enemies) {
        if (!spellDisabled) {
            Enemy enemy = new Enemy();
            enemy.position.set(150,0);
            enemies.add(enemy);
            spellDisabled = true;
        }
    }

    public void coolDown() {
        if (spellDisabled) {
            boolean status = coolDownCounter.run();
            if (status) {
                spellDisabled = false;
                coolDownCounter.reset();
            }
        }
    }

    public void render(Graphics2D g2d){
        imageRenderer.render(g2d, position);
    }

    public void setContraints(Contraints contraints){
        this.contraints = contraints;
    }
}
