package home.player;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by VALV on 7/12/2017.
 */
public class Player {
    public int x;
    public int y;
    public BufferedImage image;

    public void Move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    public void Render(Graphics2D g2d)
    {
        g2d.drawImage(image,x,y,null);
    }

}
