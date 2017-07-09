package Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by VALV on 7/9/2017.
 */
public class GameWindow extends JFrame{
    BufferedImage background;
    BufferedImage player;
    private int playerX;

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;



    public GameWindow()
    {
        setupwindow();
        loadImages();
        playerX = background.getWidth()/2;
        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();

        setupInputs();


        this.setVisible(true);
    }

    private void setupInputs() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // nham phim
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:
//                        System.out.println("right");
                        playerX+=5;
//                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:

                        break;
                    default:
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // nha phim

            }
        });
    }

    public void Run()
    {
        // game loop
        while(true)
        {
            // khoang time repain
            try {
                Thread.sleep(17);
                backBufferGraphics2D.setColor(Color.BLACK);
                backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());
                int bgheigh = background.getHeight();
                int bgwidth = background.getWidth();

                backBufferGraphics2D.drawImage(background,0,this.getHeight() - bgheigh,null);
                backBufferGraphics2D.drawImage(player,playerX,this.getHeight() - player.getHeight(),null  );
                Graphics2D g2d = (Graphics2D) this.getGraphics();
                g2d.drawImage(backBufferImage,0,0,null);
//                repaint();
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

    private void setupwindow() {
        this.setSize(800,600);
        // this.setSize(800,600)
        this.setResizable(false);// ko cho to man hinh

        this.setTitle("Toughoud - remade by Vũ Cơ");
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
    }

//    @Override
//    public void paint(Graphics g) {
//        Graphics2D g2d = (Graphics2D)g; // ep kieu
//        // cast, convert
//        g2d.drawImage(backBufferImage,0,0,null);
//
////        super.paint(g);
//    }
}
