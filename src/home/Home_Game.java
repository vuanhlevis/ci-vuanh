package home;


import home.enemy.Enemy;
import home.player.Player;
import home.player.Player_Spell;

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
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by VALV on 7/10/2017.
 */
public class Home_Game extends JFrame {
    BufferedImage background;
    BufferedImage backBufferImage;
    Graphics2D backBufferGraphics2D;

    boolean CR;
    boolean CL;
    boolean CD;
    boolean CU;
    boolean CX;


    Player player = new Player();
    ArrayList<Player_Spell> player_spells = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    private int backgroundY;
    public Home_Game()
    {
        setupWindow();
        loadImages();
        backgroundY = this.getHeight() - background.getHeight();
        player.x = background.getWidth()/2;
        player.y = this.getHeight() - player.image.getHeight();
        backBufferImage = new BufferedImage(this.getWidth(), this.getHeight(),BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics2D = (Graphics2D) backBufferImage.getGraphics();
        setupInputs();
        setVisible(true);
    }
    public void Loop()
    {
        while (true)
        {
            try {
                Thread.sleep(17);
                Run();
                Render();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void Render() {
        backBufferGraphics2D.setColor(Color.BLACK);
        backBufferGraphics2D.fillRect(0,0,this.getWidth(),this.getHeight());
        backBufferGraphics2D.drawImage(background,0,backgroundY,null);
        player.Render(backBufferGraphics2D);
        for (int i = 0; i < player_spells.size(); i++)
        {
            if (i%4 == 0) player_spells.get(i).Render(backBufferGraphics2D);
        }
        for (int i = 0; i < enemies.size(); i++)
        {
            if (i%69 == 0) enemies.get(i).Render(backBufferGraphics2D);
        }
        backBufferGraphics2D.setColor(Color.CYAN);
        backBufferGraphics2D.drawString("♦Vũ Cơ♦",player.x - 12,player.y);

        Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.drawImage(backBufferImage,0,0,null);

    }

    private void Run() {
        if (backgroundY <= 0)
            backgroundY += 1;

        int dx = 0;
        int dy = 0;
        if (CD)
        {
            if (player.y + 5 <= this.getHeight() - player.image.getHeight())
                dy += 5;
        }
        if (CU)
        {
            if (player.y - 5 >= player.image.getHeight()/2)
                dy -= 5;
        }
        if (CL)
        {
            if (player.x - 5 >=0)
                dx -= 5;
        }
        if (CR)
        {
            if (player.x + 5 <= background.getWidth() - player.image.getWidth()/2)
                dx += 5;
        }
        player.Move(dx,dy);
        if (CX)
        {
            Player_Spell player_spell = new Player_Spell();
            player_spell.x = player.x + 3;
            player_spell.y = player.y - 15;
            try {
                player_spell.image = ImageIO.read(new File("assets/images/player-spell/a/1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            player_spells.add(player_spell);
        }
        for (Player_Spell player_spell : player_spells)
        {
            player_spell.Move();
        }
        //

        if (Math.abs(backgroundY) % 3 == 0 || Math.abs(backgroundY) % 2 == 0 || Math.abs(backgroundY) % 5 == 0){
            Enemy enemy = new Enemy();
            enemy.x = player.x + 3;
            enemy.y = 0;
            try {
                enemy.image = ImageIO.read(new File("assets/images/enemies/level0/blue/2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            enemies.add(enemy);
        }


        for (Enemy enemy : enemies)
        {
            enemy.Move();
        }


    }

    private void setupInputs() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:
                        CR = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        CL = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        CD = true;
                        break;
                    case KeyEvent.VK_UP:
                        CU = true;
                        break;
                    case KeyEvent.VK_X:
                        CX = true;
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
                        CR = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        CL = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        CD = false;
                        break;
                    case KeyEvent.VK_UP:
                        CU = false;
                        break;
                    case KeyEvent.VK_X:
                        CX = false;
                        break;
                    default:
                        break;

                }
            }
        });
    }

    private void loadImages() {
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player.image = ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupWindow() {
        this.setSize(800,600);
        this.setTitle("Toughou - remade by Vũ Cơ");
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                super.windowClosing(e);
            }
        });
    }
}
