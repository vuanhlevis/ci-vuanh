package game.screnes;

import game.Utils;
import game.bases.GameObject;
import game.bases.ImageRenderer;
import game.bases.Vector2D;

/**
 * Created by VALV on 7/23/2017.
 */
public class BackGround extends GameObject {
    public BackGround() {
        super(); // lop cha -> muon cac ham trong lop cha
        this.renderer = new ImageRenderer(Utils.loadAssetImage("background/0.png"));
        this.renderer.anchor.set(0,1);
    }

    public void run(Vector2D parentPosition) {
        if (this.position.y - this.renderer.getHeigh() < 0) {
            this.position.addUp(0,1);
        }
    }
}
