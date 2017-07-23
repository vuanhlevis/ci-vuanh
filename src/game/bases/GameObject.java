package game.bases;

import java.awt.*;
import java.util.Vector;

/**
 * Created by VALV on 7/18/2017.
 */
public class GameObject {
    public Vector2D position; // relative
    public Vector2D screenPosition; // screen

    public ImageRenderer renderer;

    public Vector<GameObject> children;

    private static Vector<GameObject> gameObjects = new Vector<>();

    private static Vector<GameObject> newgameObjects = new Vector<>();

    public static void add(GameObject gameObject) {
        newgameObjects.add(gameObject);
    }

    public static void renderAll(Graphics2D graphics2D) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(graphics2D);
        }
    }

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            gameObject.run(Vector2D.ZERO);
        }
        gameObjects.addAll(newgameObjects);
        newgameObjects.clear();

        // kiem tra doi mot
//        for (int i = 0; i < gameObjects.size() - 1; i++) {
//            for (int j = i + 1; j < gameObjects.size(); j++) {
//                GameObject gi = gameObjects.get(i);
//                GameObject gj = gameObjects.get(j);
//
//            }
//        }
    }

    public void render(Graphics2D g2d) {
        if (renderer != null) {
            renderer.render(g2d,this.position);
        }
    }

    public GameObject() {
        this.position = new Vector2D();
        this.screenPosition = new Vector2D();
        this.children = new Vector<>();
        this.renderer = null;
    }

    public void run(Vector2D parentPosition) {
        // position = relative
        this.screenPosition = parentPosition.add(position);
        for (GameObject child : children) {
            child.run(this.screenPosition);
        }
    }
}
