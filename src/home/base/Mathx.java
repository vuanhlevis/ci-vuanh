package home.base;

/**
 * Created by VALV on 7/18/2017.
 */
public class Mathx {
    public static float clamp(float x, float y, float z)
    {
        if (x < y) return y;
        else if (x > z) return z;
        else return x;
    }
}
