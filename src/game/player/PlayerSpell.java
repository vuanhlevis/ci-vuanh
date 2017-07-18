package game.player;

import com.sun.media.sound.UlawCodec;
import game.Utils;
import game.bases.ImageRenderer;
import game.bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by VALV on 7/11/2017.
 */
public class PlayerSpell {
    //properties : thuoc tinh
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
