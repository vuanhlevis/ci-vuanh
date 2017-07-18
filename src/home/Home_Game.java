package home;

import home.base.Contraints;
import home.enemy.Enemy;
import home.enemy.EnemySpell;
import home.player.Player;
import home.player.PlayerSpell;

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

/**
 * Created by VALV on 7/18/2017.
 */
public class Home_Game extends JFrame{
    BufferedImage background;
    Player player = new Player();
    Enemy enemy = new Enemy();
//    Enemy enemy2 = new Enemy();
    EnemySpell enemySpell = new EnemySpell();
    ArrayList<PlayerSpell> playerSpells = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<EnemySpell> enemySpells = new ArrayList<>();


    private int backGroudY;

    private BufferedImage backBufferImage;
    private Graphics2D backBufferGraphic2D;

    private boolean rightPressed, leftPressed, upPressed, downPressed, xPressed;

    private int delaySpells;

    public Home_Game(){

        setUpWindow();
        loadImage();

        Contraints contraints = new Contraints(0, this.getHeight(), 0, background.getWidth());

        player.position.set(background.getWidth() / 2, this.getHeight() - 50);
        player.setContraints(contraints);
        backBufferImage = new BufferedImage(this.getWidth(),this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic2D = (Graphics2D) backBufferImage.getGraphics();

        backGroudY = this.getHeight() - background.getHeight();

        setupInput();
        this.setVisible(true);
    }

    private void setupInput() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        rightPressed = true;
                        break;

                    case KeyEvent.VK_LEFT:
                        leftPressed = true;
                        break;

                    case KeyEvent.VK_UP:
                        upPressed = true;
                        break;

                    case KeyEvent.VK_DOWN:
                        downPressed = true;
                        break;
                    case  KeyEvent.VK_X:
                        xPressed = true;
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        rightPressed = false;
                        break;

                    case KeyEvent.VK_LEFT:
                        leftPressed = false;
                        break;

                    case KeyEvent.VK_UP:
                        upPressed = false;
                        break;

                    case KeyEvent.VK_DOWN:
                        downPressed = false;
                        break;

                    case KeyEvent.VK_X:
                        xPressed = false;
                        break;

                    default:
                        break;
                }
            }
        });

    }

    long lastUpdateTime;

    public void loop(){
        while (true){

            long  currentTime = System.currentTimeMillis();

            if (currentTime - lastUpdateTime > 17){
                lastUpdateTime = currentTime;
                render();
                run();
            }


        }
    }

    private void run(){
        if (backGroudY <= 0 ) {
            backGroudY += 1;
        }

        int dx = 0;
        int dy = 0;

        if (rightPressed){
            dx += 5;
        }
        if (leftPressed){
            dx -= 5;
        }
        if (upPressed){
            dy -= 5;
        }
        if (downPressed){
            dy += 5;
        }

        if (xPressed) {
            player.CastSpell(playerSpells);
        }

        player.coolDown();

        player.move(dx, dy);

        for (PlayerSpell playerSpell : playerSpells) {
            playerSpell.move();
        }
        enemy.castEnemy(enemies);
        enemy.coolDown();
        for (Enemy enemy1 : enemies) {
            enemy1.move(0,5);
            enemy1.castSpell(enemySpells);
            enemy1.coolDownSpell();
        }
//        enemy2.castSpell(enemySpells);
//        enemy2.coolDownSpell();
        for (EnemySpell enemySpell : enemySpells) {
            enemySpell.move();
        }


//        System.out.println(backGroudY);

    }

    private void render() {
        backBufferGraphic2D.setColor(Color.BLACK);
        backBufferGraphic2D.fillRect(0,0,this.getWidth(),this.getHeight());

        backBufferGraphic2D.drawImage(background, 0, backGroudY, null);
        player.render(backBufferGraphic2D);
        for (PlayerSpell playerspell : playerSpells) {
            playerspell.render(backBufferGraphic2D);
        }
        for (Enemy enemy : enemies) {
            enemy.render(backBufferGraphic2D);
        }
        for (EnemySpell enemySpell : enemySpells) {
            enemySpell.render(backBufferGraphic2D);
        }

        backBufferGraphic2D.setColor(Color.CYAN);
        backBufferGraphic2D.drawString("♦Vũ Cơ♦",player.position.x - 28,player.position.y - 25);
        Graphics2D g2d = (Graphics2D)this.getGraphics();
        g2d.drawImage(backBufferImage,0,0,null);
    }

    private void loadImage() {

        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUpWindow() {
        this.setSize(800, 600);

        this.setResizable(false);
        this.setTitle("Touhou - remade by Vũ Cơ");

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
