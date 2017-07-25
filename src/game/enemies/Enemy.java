package game.enemies;

import game.Utils;
import game.bases.*;
import game.bases.physics.PhysicsBody;
import game.bases.renderers.Animation;
import game.bases.renderers.ImageRenderer;
import game.player.Player;

/**
 * Created by VALV on 7/23/2017.
 */
public class Enemy extends GameObject implements PhysicsBody {
    public Vector2D velocity;
    FrameCounter shootCounter;
    BoxCollider boxCollider;

    public Enemy() {
        super();
        this.renderer = new Animation(
                Utils.loadAssetImage("enemies/level0/blue/0.png"),
                Utils.loadAssetImage("enemies/level0/blue/1.png"),
                Utils.loadAssetImage("enemies/level0/blue/2.png"),
                Utils.loadAssetImage("enemies/level0/blue/3.png"));
        velocity = new Vector2D();
        this.shootCounter = new FrameCounter(2);

        this.boxCollider = new BoxCollider(20, 20);
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
    }

    Vector2D target = Player.instance.position;

    private void shoot() {
        EnemyBullet enemyBullet = GameObjectPool.recycle(EnemyBullet.class);

        Vector2D bulletVelocity = target.substract(position).normalize().multiply(4);
//        enemyBullet.velocity.set(0,4);
        enemyBullet.velocity.set(bulletVelocity);
        enemyBullet.position.set(this.position);

    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
