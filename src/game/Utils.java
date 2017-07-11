package game;

import com.sun.org.apache.xpath.internal.operations.String;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by VALV on 7/11/2017.
 */
public class Utils {
    public static BufferedImage loadImage(String url)
    {
        return ImageIO.read(new File(url));
        return null;


    }
    public static BufferedImage loadAssetImage(String url)
    {
        return loadImage("assets/images"+url);
    }
}
