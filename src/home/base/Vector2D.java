package home.base;

/**
 * Created by VALV on 7/18/2017.
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D (float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2D()
    {
        this(0,0);
    }

    public void addUp(float x, float y)
    {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other)
    {
        addUp(other.x, other.y);
    }

    public Vector2D add(float x, float y)
    {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other)
    {
        return add(other.x,other.y);
    }

    public void set (float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    public void set(Vector2D other)
    {
        set(other.x,other.y);
    }


    public Vector2D multiply(int a)
    {
        Vector2D c = new Vector2D(x*a,y*a);
        return c;
    }
    public Vector2D normallize()
    {
        Vector2D a = new Vector2D((float) (x / Math.sqrt(x*x + y*y)),(float) (y / Math.sqrt(x*x + y*y)));
        return a;
    }

    public Vector2D clone()
    {
        Vector2D c = new Vector2D(x,y);
        return c;
    }
    public Vector2D invert()
    {
        Vector2D a = new Vector2D(-x, -y);
        return a;
    }
    public Vector2D Substract(Vector2D b)
    {
        Vector2D c = new Vector2D(x - b.x, y - b.y);
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

