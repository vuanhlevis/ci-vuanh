package game.player;

import java.util.Vector;

/**
 * Created by VALV on 7/16/2017.
 */
public class Vector2D {
    public float x;
    public float y;

    public void addUp(Vector2D b)
    {
        x+= b.x;
        y+= b.y;
    }
    public Vector2D add(Vector2D b)
    {
        Vector2D c = new Vector2D();
        c.x = b.x + x;
        c.y = b.y + y;
        return c;
    }
    public Vector2D multiply(int a)
    {
        Vector2D c = new Vector2D();
        c.x = x*a;
        c.y = y*a;
        return c;
    }
    public Vector2D normallize()
    {
        Vector2D a = new Vector2D();
        a.x = (float) (x / Math.sqrt(x*x + y*y));
        a.y = (float) (y / Math.sqrt(x*x + y*y));
        return a;
    }

    public Vector2D clone()
    {
        Vector2D c = new Vector2D();
        c.x = x;
        c.y = y;
        return c;
    }
    public Vector2D invert()
    {
        Vector2D a = new Vector2D();
        a.x = - x;
        a.y = - y;
        return a;
    }
    public Vector2D Substract(Vector2D b)
    {
        Vector2D c = new Vector2D();
        c.x = x - b.x;
        c.y = y - b.y;
        return c;
    }

    public float magnitude()
    {
        double s;
        s = Math.sqrt(x*x + y*y);
        return (float) s;
    }
//    public void normallize()
//    {
//
//    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
