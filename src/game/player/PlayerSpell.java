package game.player;

import com.sun.media.sound.UlawCodec;
import game.Utils;
import game.bases.GameObject;
import game.bases.ImageRenderer;
import game.bases.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by VALV on 7/11/2017.
 */
public class PlayerSpell extends GameObject{
    //properties : thuoc tinh

    public PlayerSpell(){
        this.renderer = new ImageRenderer(Utils.loadAssetImage("player-spell/a/0.png"));
    }

    public void run(Vector2D parentPosition){
        super.run(parentPosition);
        this.position.addUp(0, -10);
    }

}
