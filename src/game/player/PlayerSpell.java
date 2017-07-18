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
public class Player_Spell {
    //properties : thuoc tinh
    public Vector2D position;
    public ImageRenderer imageRenderer;

    public Player_Spell()
    {
        position = new Vector2D();
        imageRenderer = new ImageRenderer(Utils.loadAssetImage("player-spell/a/1.png"));
    }

    //method: phuong thuc
    public void Move()
    {
        this.position.addUp(0,-10);
    }

    public void Render(Graphics2D g2d)
    {
        imageRenderer.render(g2d,position);
    }
}
