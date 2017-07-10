package Home;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by VALV on 7/10/2017.
 */
public class Home_Game extends JFrame {
    BufferedImage background;
    BufferedImage player;
    private int PlayerX;
    private int PlayerY;
    private boolean checkR;
    private boolean checkL;
    private boolean checkU;
    private boolean checkD;

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;

    public Home_Game()
    {
        setupWindow();
        loadImages();
        PlayerX = background.getWidth()/2;
        PlayerY = this.getHeight() - player.getHeight();
        backBufferImage = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();
        setupInputs();
        this.setVisible(true);
    }

    private void setupInputs() {
        int temp = PlayerY;
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:

                        if ( (PlayerX + 17) >= background.getWidth())
                            break;
                        else PlayerX+=5;
                        break;

                    case KeyEvent.VK_LEFT:
                        if (PlayerX - 5 <=0)
                            break;
                        else PlayerX-=5;
                        break;

//                        System.out.println(background.getWidth());
//                        System.out.println(PlayerX);
                    case KeyEvent.VK_UP:
                        if (PlayerY - 20 <=0)
                            break;
                        else PlayerY-=5;
                        break;

                    case KeyEvent.VK_DOWN:
                        if (PlayerY + 5 >= temp )
                            break;
                        else PlayerY +=5;
                        break;


                    default:
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:

                }

            }
        });
    }
    public void Run()
    {
        int bgHeigh = background.getHeight();
        int oy = this.getHeight() - background.getHeight();
        boolean tmp = true;
        while(true)
        {
            try {
                Thread.sleep(17);
                backBufferGraphics2D.setColor(Color.BLACK);
                backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());

                backBufferGraphics2D.drawImage(background,0,this.getHeight()-bgHeigh,null);
                backBufferGraphics2D.drawImage(player,PlayerX,PlayerY,null);

                if(tmp)
                {
                    bgHeigh-=5;

                    if (bgHeigh <= this.getHeight())
                        tmp = false;
                }

                Graphics2D g2d = (Graphics2D) this.getGraphics();
                g2d.drawImage(backBufferImage,0,0,null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadImages() {
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupWindow() {
        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("Toughou - remade by Vũ Cơ");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
    }
}
