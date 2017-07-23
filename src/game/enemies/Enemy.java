package game.enemies;

import game.Utils;
import game.bases.*;
import game.player.Player;

/**
 * Created by VALV on 7/23/2017.
 */
public class Enemy extends GameObject {
    public Vector2D velocity;
    FrameCounter shootCounter;
    BoxCollider boxCollider;
    public Enemy() {
        super();
        this.renderer = new ImageRenderer(Utils.loadAssetImage("enemies/level0/blue/1.png"));
        velocity = new Vector2D();
        this.shootCounter = new FrameCounter(2);
        this.boxCollider = new BoxCollider(20,20);
        this.children.add(boxCollider);
    }

    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        velocity.y = 2;
        this.position.addUp(velocity);
        if (shootCounter.run()) {
            this.shootCounter.reset();
            shoot();
        }

        System.out.println(this.boxCollider);
    }

    Vector2D target = Player.instance.position;

    private void shoot() {
        EnemyBullet enemyBullet = new EnemyBullet();

        Vector2D bulletVelocity  = target.substract(position).normalize().multiply(4);
//        enemyBullet.velocity.set(0,4);
        enemyBullet.velocity.set(bulletVelocity);
        enemyBullet.position.set(this.position);
        GameObject.add(enemyBullet);
    }

}
