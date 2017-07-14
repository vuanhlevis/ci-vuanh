package home.enemy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by VALV on 7/13/2017.
 */
public class Enemy {
    public int x;
    public int y;

    public BufferedImage image;


    public void Move()
    {
        y+=5;
        if (y <= 250)
        {
            if (x + 3 <= 350)
                x+=3;
        } else
            if (x - 3 >= 10)
                x-= 3;
    }
    public void Render(Graphics2D g2d)
    {
        g2d.drawImage(image,x,y,null);
    }
}
