package home.player;

import home.Utils;
import home.base.ImageRenderer;
import home.base.Vector2D;

import java.awt.*;

/**
 * Created by VALV on 7/18/2017.
 */
public class PlayerSpell {
    public Vector2D position;

    public ImageRenderer imageRenderer;

    public PlayerSpell(){
        this.position = new Vector2D();
        this.imageRenderer = new ImageRenderer(Utils.loadAssetImage("player-spell/a/0.png"));
    }

    public void move(){
        this.position.addUp(0, -10);
    }

    public void render(Graphics2D g2d){
        imageRenderer.render(g2d, this.position);
    }
}
