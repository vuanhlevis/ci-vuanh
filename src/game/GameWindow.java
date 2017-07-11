package game;

import game.player.Player;
import game.player.Player_Spell;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by VALV on 7/9/2017.
 */
public class GameWindow extends JFrame{
    BufferedImage background;

    private int backgroundY ;
    boolean RightPress;
    boolean LeftPress;
    boolean DownPress;
    boolean UpPress;
    boolean xPress;

    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;

    Player player = new Player();
    ArrayList<Player_Spell> player_spells = new ArrayList<>();

    public GameWindow()
    {
        setupwindow();
        loadImages();
        backgroundY = this.getHeight() - background.getHeight();
        player.x = background.getWidth()/2;
        player.y = this.getHeight() - player.Image.getHeight();
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
                        RightPress = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        LeftPress = true;
                        break;
                    case KeyEvent.VK_UP:
                        UpPress = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        DownPress = true;
                        break;
                    case KeyEvent.VK_X:
                        xPress = true;
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // nha phim
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:
                        RightPress = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        LeftPress = false;
                        break;
                    case KeyEvent.VK_UP:
                        UpPress = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        DownPress = false;
                        break;
                    case KeyEvent.VK_X:
                        xPress = false;
                        break;
                    default:
                            break;
                }

            }
        });
    }

    public void Loop()
    {
        // game loop
        while(true)
        {
            // khoang time repain
            try {
                Thread.sleep(17);
                Run();
                Render();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void Run() {
        if (backgroundY <=0)
            backgroundY+=1;
        int dx = 0;
        int dy = 0;
        if (RightPress)
        {
            if (player.x + 5 <= background.getWidth() - player.Image.getWidth())
                dx += 5;
        }
        if (LeftPress)
        {
            if (player.x - 5 >= 0)
                dx -= 5;
        }
        if (DownPress)
        {
            if(player.y + 5 <= this.getHeight() - player.Image.getHeight())
                dy += 5;
        }
        if (UpPress)
        {
            if(player.y - 5 >= player.Image.getHeight()/2)
                dy -= 5;
        }
        if (xPress)
        {
            Player_Spell player_spell = new Player_Spell(); // construct
            //config
            player_spell.x = player.x;
            player_spell.y = player.y;
            try {
                player_spell.image = ImageIO.read(new File("assets/images/player-spell/a/0.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // add to Arraylist
            player_spells.add(player_spell);
        }
        player.Move(dx,dy);
        for(Player_Spell player_spell : player_spells)
        {
            player_spell.Move();
        }
    }


    private void Render() {
        backBufferGraphics2D.setColor(Color.BLACK);
        backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());
        int bgheigh = background.getHeight();
        int bgwidth = background.getWidth();

        backBufferGraphics2D.drawImage(background,0,backgroundY,null);
        player.Render(backBufferGraphics2D);

        for (Player_Spell player_spell : player_spells)
        {
            player_spell.Render(backBufferGraphics2D);
        }

        backBufferGraphics2D.drawString("Vũ Cơ",player.x,player.y);

        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.drawImage(backBufferImage,0,0,null);

    }

    private void loadImages() {
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player.Image = ImageIO.read(new File("assets/images/players/straight/0.png"));
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
